package fpt.assignment_java6.assignment_java6.controller;

import fpt.assignment_java6.assignment_java6.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class KhuyenMai {
    @Autowired
    private PromotionService promotionService;
    @GetMapping("/khuyenMai")
    public String hienThi(Model model){
        model.addAttribute("listKM",promotionService.getAllPromotion());
        return "KhuyenMai/KhuyenMai";
    }
}
