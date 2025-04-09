package fpt.assignment_java6.assignment_java6.service;
import fpt.assignment_java6.assignment_java6.entity.Customer;
import fpt.assignment_java6.assignment_java6.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomersRepository customerRepository;
    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }
}
