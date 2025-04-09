package fpt.assignment_java6.assignment_java6.config; // hoặc package phù hợp với dự án bạn

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ModelAttribute("cartCount")
    public int cartItemCount(HttpSession session) {
        List<Long> cart = (List<Long>) session.getAttribute("cart");
        return (cart != null) ? cart.size() : 0;
    }
}
