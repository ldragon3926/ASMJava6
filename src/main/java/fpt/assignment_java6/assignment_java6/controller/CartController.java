package fpt.assignment_java6.assignment_java6.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

public class CartController {


    @PostMapping("/cart/add")
    public String addToCart(@RequestParam("productId") Long productId, HttpSession session) {
        List<Long> cart = (List<Long>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }

        cart.add(productId);
        session.setAttribute("cart", cart);

        return "redirect:/";
    }

}
