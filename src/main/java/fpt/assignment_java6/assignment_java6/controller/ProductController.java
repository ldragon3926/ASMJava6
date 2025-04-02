package fpt.assignment_java6.assignment_java6.controller;



import fpt.assignment_java6.assignment_java6.entity.Product;
import fpt.assignment_java6.assignment_java6.service.CategoryService;
import fpt.assignment_java6.assignment_java6.service.ProductsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/product/")
public class ProductController {
    @Autowired
    private ProductsService productsService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("hien-thi")
    private String hienThi(
            Model model
    ) {
        Product product = new Product();
        product.setCategory(categoryService.findById(1));
        model.addAttribute("product", product);
        model.addAttribute("productList", productsService.getAllProducts());
        model.addAttribute("categoryList", categoryService.findAll());
        return "Product";
    }
    @PostMapping("add")
    public String addProduct(
            @Valid @ModelAttribute("product") Product product,
            BindingResult bindingResult,
            @RequestParam("ltca")Integer id,
            Model model
    ){
        if (bindingResult.hasErrors()) {
            model.addAttribute("productList", productsService.getAllProducts());
            model.addAttribute("categoryList", categoryService.findAll());
            return "Product";
        }else {
            if (productsService.checkIfProductExist(product.getName())) {
                product.setCategory(categoryService.findById(id));
                productsService.save(product);
                return "redirect:/product/hien-thi";
            }else {
                model.addAttribute("loi", "Tên sản phẩm đã trùng");
                model.addAttribute("productList", productsService.getAllProducts());
                model.addAttribute("categoryList", categoryService.findAll());
                product.setCategory(categoryService.findById(id));
                model.addAttribute("product", product);
                return "Product";
            }
        }
    }
    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable Integer id, Model model) {
        model.addAttribute("product",productsService.getById(id));
        model.addAttribute("categoryList", categoryService.findAll());
        return "ProductUpdate";
    }

    @PostMapping("update")
    public String updateProduct(
            @Valid @ModelAttribute("product")Product product,
            BindingResult result,
            @RequestParam("ltca")Integer id,
            Model model
    ){
        if (result.hasErrors()) {
            return "ProductUpdate";
        }else {
            product.setCategory(categoryService.findById(id));
            productsService.save(product);
            return "redirect:/product/hien-thi";
        }
    }
    @GetMapping("detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        model.addAttribute("product",productsService.getById(id));
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("productList", productsService.getAllProducts());
        return "Product";
    }
}
