package com.codgym.controller;

import com.codgym.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.codgym.service.CustomerService;
import com.codgym.service.CustomerServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CustomerController {
    private CustomerService customerService = new CustomerServiceImpl();

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("customers", customerService.findAll());
        return "index";
    }

    @GetMapping("/create")
    public String createCustomer(Model model){
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping("/save")
    public String saveCustomer(Customer customer, RedirectAttributes redirect){
        customer.setId((int)Math.random()*10000);
        customerService.save(customer);
        redirect.addFlashAttribute("success", "Saved customer successfully!");
        return "redirect:/";
    }

    @
}
