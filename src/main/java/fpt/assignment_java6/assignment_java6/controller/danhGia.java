package fpt.assignment_java6.assignment_java6.controller;

import fpt.assignment_java6.assignment_java6.service.CustomerService;
import fpt.assignment_java6.assignment_java6.service.ProductsService;
import fpt.assignment_java6.assignment_java6.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class danhGia {
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private ProductsService productsService;
    @Autowired
    private CustomerService customerService;

    @GetMapping("/danhGia")
    public String hienThi(Model model){
        model.addAttribute("listDG",reviewService.getAllReview());
        model.addAttribute("listProduct",productsService.getAllProducts());
        model.addAttribute("listKH",customerService.getAllCustomer());
        return "danhGia";
    }
}
