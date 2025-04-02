package fpt.assignment_java6.assignment_java6.service;

import fpt.assignment_java6.assignment_java6.entity.Category;
import fpt.assignment_java6.assignment_java6.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    public Category findById(Integer id) {
        return categoryRepo.findById(id).orElse(null);
    }

    public void save(Category category) {
        categoryRepo.save(category);
    }

    public void delete(Integer id) {
        categoryRepo.deleteById(id);
    }

    public Boolean checkIfCategoryExists(String name) {
        return categoryRepo.findAll().stream().noneMatch(category -> category.getName().equalsIgnoreCase(name.trim()));
    }
}
