package fpt.assignment_java6.assignment_java6.repository;

import fpt.assignment_java6.assignment_java6.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
