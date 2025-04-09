package fpt.assignment_java6.assignment_java6.controller;

import fpt.assignment_java6.assignment_java6.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReiviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/review/hienthi")
    public String hienthiall(
            Model model
    ){
        model.addAttribute("listDG",reviewService.getAllReview());
        return "danhGia";
    }
}
