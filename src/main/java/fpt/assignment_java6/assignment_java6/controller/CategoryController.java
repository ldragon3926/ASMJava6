package fpt.assignment_java6.assignment_java6.controller;

import fpt.assignment_java6.assignment_java6.entity.Category;
import fpt.assignment_java6.assignment_java6.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category/")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("hien-thi")
    public String hienThi(
            Model model
    ) {
        model.addAttribute("category", new Category());
        model.addAttribute("categoryList", categoryService.findAll());
        return "Category";
    }

    @PostMapping("add")
    public String addCategory(
            @Valid @ModelAttribute("category") Category category,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categoryList", categoryService.findAll());
            return "Category";
        } else {
            if (categoryService.checkIfCategoryExists(category.getName())) {
                categoryService.save(category);
                return "redirect:/category/hien-thi";
            }else {
                model.addAttribute("categoryList", categoryService.findAll());
                model.addAttribute("loi", "Loại trái cây đã tồn tại");
                return "Category";
            }
        }
    }

}
