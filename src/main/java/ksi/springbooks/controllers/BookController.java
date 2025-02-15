package ksi.springbooks.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ksi.springbooks.models.Book;
import ksi.springbooks.repositories.CategoryRepository;
import ksi.springbooks.repositories.PublisherRepository;
import ksi.springbooks.services.BookService;
import ksi.springbooks.services.CategoryService;
import ksi.springbooks.services.PublisherService;

@Controller
public class BookController {

    @Autowired
    private BookService service;
    private final CategoryService categoryService;   
    private final PublisherService publisherService; 
   
    

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    
    @Autowired
    public BookController(BookService bookService, PublisherService publisherService, CategoryService categoryService) {
        this.service = bookService;
        this.publisherService = publisherService;
        this.categoryService = categoryService;
    }


    @RequestMapping("/book_list")
    public String viewBookList(Model model) {
        List<Book> lb = service.findAll();
        model.addAttribute("lb", lb);
        return "book_list";
    }

    

    @GetMapping("/new_book")
    public String showFormNewBook(Model model) {
        model.addAttribute("book", new Book());  
        model.addAttribute("publishers", publisherRepository.findAll());
        model.addAttribute("categories", categoryRepository.findAll());
        return "new_book";
    }


    @PostMapping(value = "/save_book")
    public String saveBook(@ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "new_book";  
        }
        service.save(book);
        return "redirect:/book_list";
    }

    
    @GetMapping("/edit_book/{idb}")
    public String showEditForm(@PathVariable("idb") Long idb, Model model) {
        Optional<Book> book = service.findById(idb);
        if (book.isPresent()) {
            System.out.println("Book found: " + book.get().getTitle() + " (ID: " + book.get().getIdb() + ")");
            model.addAttribute("book", book.get());
            model.addAttribute("publishers", publisherService.findAll());
            model.addAttribute("categories", categoryService.findAll());
            return "edit_book";
        } else {
            System.out.println("Book not found, redirecting to book list.");
            return "redirect:/book_list";
        }
    }


    @PostMapping("/update_book/{idb}")
    public String updateBook(@PathVariable("idb") Long idb, @ModelAttribute("book") Book book) {

        System.out.println("Received book ID: " + idb);
        System.out.println("Received book object: " + book);

        if (book.getIdb() == null || !book.getIdb().equals(idb)) {
            System.out.println("ID mismatch or book ID is null, redirecting to book list.");
            return "redirect:/book_list";
        }
        System.out.println("Saving book with ID: " + book.getIdb() + " and title: " + book.getTitle());

        service.save(book); 
        return "redirect:/book_list";  
    }

    @PostMapping("/delete_book/{idb}")
    public String deleteBook(@PathVariable("idb") Long idb) {
        service.deleteById(idb);
        return "redirect:/book_list";
    }
    
    @RequestMapping("/book_list_sort")
    public String viewSortedBookList(Model model) {
        model.addAttribute("lb", service.findAllSortedByTitle());
        return "book_list_sort";
    }
}
