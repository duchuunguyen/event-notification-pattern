package com.kms.sadp.eda.customer.service;

import com.kms.sadp.eda.customer.domain.Customer;
import com.kms.sadp.eda.customer.domain.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer find(Long customerId) {
        return customerRepository.find(customerId);
    }
}
