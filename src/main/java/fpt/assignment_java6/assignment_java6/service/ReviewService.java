package fpt.assignment_java6.assignment_java6.service;

import fpt.assignment_java6.assignment_java6.entity.Review;
import fpt.assignment_java6.assignment_java6.repository.ReviewRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public List<Review> getAllReview(){
        return reviewRepository.findAll();
    }

    public List<Review> findByProductId(Long productId) {
        return entityManager
                .createQuery("SELECT r FROM Review r WHERE r.product.id = :productId", Review.class)
                .setParameter("productId", productId)
                .getResultList();
    }
}