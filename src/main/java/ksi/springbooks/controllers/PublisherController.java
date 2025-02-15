package ksi.springbooks.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ksi.springbooks.models.Publisher;
import ksi.springbooks.repositories.PublisherRepository;
import ksi.springbooks.services.PublisherService;


@Controller
public class PublisherController {

    @Autowired
    private PublisherRepository publisherRepository;

    

    @Autowired
    private PublisherService publisherService;

    
    
    @RequestMapping("/publisher_list")
    public String viewPublisherList(Model model) {
        List<Publisher> publishers = publisherRepository.findAll(Sort.by(Sort.Order.asc("name")));
        model.addAttribute("publishers", publishers);
        return "publisher_list";  
    }
    
    
    @GetMapping("/publisher_list")
    public String showPublisherList(Model model) {
        model.addAttribute("publishers", publisherService.findAll());
        return "publisher_list"; 
    }

    
    @GetMapping("/edit_publisher/{idp}")
    public String showEditPublisherForm(@PathVariable("idp") Long idp, Model model) {
        Publisher publisher = publisherRepository.findById(idp).orElse(null); 
        if (publisher != null) {
            model.addAttribute("publisher", publisher); 
            return "edit_publisher";  
        }
        return "redirect:/publisher_list";  
    }
    
    @GetMapping("/new_publisher")
    public String showNewPublisherForm(Model model) {
        model.addAttribute("publisher", new Publisher());  
        return "new_publisher";  
    }
    
    
    
    @GetMapping("/delete_publisher/{idp}")
    public String deletePublisher(@PathVariable("idp") Long idp) {
        publisherService.deleteById(idp); 
        return "redirect:/publisher_list"; 
    }
    
    
    @PostMapping("/save_publisher")
    public String savePublisher(@ModelAttribute("publisher") Publisher publisher) {
        publisherRepository.save(publisher);  
        return "redirect:/publisher_list";  
    }
    
    @PostMapping("/update_publisher/{idp}")
    public String updatePublisher(@PathVariable("idp") Long idp, @ModelAttribute("publisher") Publisher publisher) {
        publisher.setIdp(idp);  
        publisherRepository.save(publisher);  
        return "redirect:/publisher_list";  
    }
}