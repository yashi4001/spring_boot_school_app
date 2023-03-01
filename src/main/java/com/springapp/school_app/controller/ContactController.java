package com.springapp.school_app.controller;

import com.springapp.school_app.model.Contact;
import com.springapp.school_app.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Slf4j
@Controller
public class ContactController {
    private final ContactService contactService;
    @Autowired
    public ContactController(ContactService contactService){
        this.contactService=contactService;
    }
    @RequestMapping("/contact")
    public String getContactPage(Model model){
        model.addAttribute("contact",new Contact());
        return "contact.html";
    }

    @PostMapping("/saveMsg")
    public String saveMessage(@Valid @ModelAttribute("contact") Contact contact, Errors errors){
        contactService.setCounter(contactService.getCounter()+1);
        if(errors.hasErrors()){
            log.error("Contact form validation failed");
            return "contact.html";
        } else {
            contactService.saveMessageDetails(contact);
            log.info("Number of times contact form is submitted:"+contactService.getCounter());
            return "redirect:/contact";
        }
    }
}
