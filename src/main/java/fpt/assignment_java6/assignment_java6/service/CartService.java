package fpt.assignment_java6.assignment_java6.service;


import fpt.assignment_java6.assignment_java6.entity.Cart;
import fpt.assignment_java6.assignment_java6.repository.CartRepository;
import fpt.assignment_java6.assignment_java6.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    public List<Cart> getAllCart() {
        return cartRepository.findAll();
    }
}
