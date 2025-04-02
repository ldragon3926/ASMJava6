package fpt.assignment_java6.assignment_java6.service;

import fpt.assignment_java6.assignment_java6.entity.Product;
import fpt.assignment_java6.assignment_java6.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    @Autowired
    private ProductRepo productRepo;
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product getById(Integer id) {
        return productRepo.findById(id).orElse(null);
    }

    public void save(Product product) {
        productRepo.save(product);
    }
    public Boolean checkIfProductExist(String productName) {
        return productRepo.findAll().stream().noneMatch(product -> product.getName().equalsIgnoreCase(productName.trim()));
    }

    public void delete(Integer id) {
        productRepo.deleteById(id);
    }
}