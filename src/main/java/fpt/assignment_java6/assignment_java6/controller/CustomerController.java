package fpt.assignment_java6.assignment_java6.controller;

import fpt.assignment_java6.assignment_java6.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping("/customer/view")
    public String hienThiCustomer(Model model){
        model.addAttribute("listCustomer",customerService.getAllCustomer());
        return "Customer";

    }
}
