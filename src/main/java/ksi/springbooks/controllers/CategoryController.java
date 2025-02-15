package ksi.springbooks.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ksi.springbooks.models.Category;
import ksi.springbooks.services.CategoryService;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/category_list")
    public String viewCategoryList(Model model) {
        List<Category> categories = categoryService.findAll();  // Fetch all categories
        model.addAttribute("categories", categories);  // Pass the categories to the view
        return "category_list";  // Return the name of the Thymeleaf template
    }
    
    
    @GetMapping("/new_category")
    public String showAddCategoryForm(Model model) {

        model.addAttribute("category", new Category());
        return "add_category"; 
    }
    
    
    @PostMapping("/save_category")
    public String saveCategory(@ModelAttribute("category") Category category) {
        categoryService.save(category); 
        return "redirect:/category_list"; 
    }
    
    
    @GetMapping("/edit_category/{id}")
    public String showEditCategoryForm(@PathVariable("id") Long id, Model model) {
        Optional<Category> category = categoryService.findById(id);
        if (category.isPresent()) {
            model.addAttribute("category", category.get()); 
            return "edit_category"; 
        } else {
            return "redirect:/category_list"; 
        }
    }
    
    
    
    @GetMapping("/delete_category/{id}")
    public String deleteCategory(@PathVariable("id") Long id) {
        categoryService.deleteById(id); 
        return "redirect:/category_list"; 
    }
    
    

    @PostMapping("/update_category")
    public String updateCategory(@ModelAttribute("category") Category category) {
        categoryService.save(category); 
        return "redirect:/category_list"; 
    }

    @GetMapping("/category_list")
    public String listCategories(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "category_list"; 
    }
    
    
    
}

