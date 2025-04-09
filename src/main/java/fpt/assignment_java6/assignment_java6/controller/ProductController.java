package fpt.assignment_java6.assignment_java6.controller;

import fpt.assignment_java6.assignment_java6.entity.Products;
import fpt.assignment_java6.assignment_java6.entity.Review;
import fpt.assignment_java6.assignment_java6.service.ProductsService;
import fpt.assignment_java6.assignment_java6.service.ReviewService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductsService productsService;
    @Autowired
    private ReviewService reviewService;
    @GetMapping("/admin/product/hien-thi")
    public String hienthitatca(Model model
    ) {
        model.addAttribute("listProduct",productsService.getAllProducts());
        return "SanPham/products";
    }


    @GetMapping("product/hienthi")
    public String hienthitatca(Model model, HttpSession session) {
        model.addAttribute("listProduct", productsService.getAllProducts());

        // Lấy giỏ hàng
        List<Long> cartIds = (List<Long>) session.getAttribute("cart");
        List<Products> cartItems = new ArrayList<>();
        BigDecimal totalPrice = BigDecimal.ZERO;

        if (cartIds != null) {
            for (Long id : cartIds) {
                Products product = productsService.findById(id);
                if (product != null) {
                    cartItems.add(product);
                    totalPrice = totalPrice.add(BigDecimal.valueOf(product.getPrice()));
                }
            }
        }

        model.addAttribute("cartItems", cartItems);
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("cartCount", cartItems.size());

        return "trangchu";
    }


    @GetMapping("/danhgia/{id}")
    public String hienThiDanhGiaTheoSanPham(
            @PathVariable("id") Long productId, Model model
    ) {
        List<Review> listDG = reviewService.findByProductId(productId);
        model.addAttribute("listDG", listDG);
        return "spchitiet";
    }

    @PostMapping("/cart/add")
    public String addToCart(@RequestParam("productId") Long productId, HttpSession session) {

        List<Long> cart = (List<Long>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }

        cart.add(productId);

        session.setAttribute("cart", cart);

        return "redirect:/product/hienthi";
    }

}
