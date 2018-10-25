package com.kms.sadp.eda.customer.domain.impl;

import com.kms.sadp.eda.customer.domain.Customer;
import com.kms.sadp.eda.customer.domain.CustomerRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class InMemoryCustomerRepository implements CustomerRepository {
    private Map<Long, Customer> customers;

    @PostConstruct
    private void init() {
        customers = new HashMap<>();
        customers.put(1L, new Customer(1L, "Thomas Edison", 100L));
        customers.put(2L, new Customer(2L, "Isacc Newton", 10L));
    }

    @Override
    public Customer find(Long customerId) {
        if (customers.containsKey(customerId)) {
            return customers.get(customerId);
        }
        return null;
    }

    @Override
    public Customer save(Customer customerId) {
        customers.put(customerId.getId(), customerId);
        return customerId;
    }
}
