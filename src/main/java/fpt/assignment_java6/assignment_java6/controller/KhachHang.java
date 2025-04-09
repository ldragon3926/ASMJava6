package fpt.assignment_java6.assignment_java6.controller;

import fpt.assignment_java6.assignment_java6.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KhachHang {
    @Autowired
    private CustomerService customerService;
    @GetMapping("/khachHang")
    public String hienThiKhachHang(Model model){
        model.addAttribute("listKH",customerService.getAllCustomer());
        return "khachHang/khach-Hang";
    }
}
