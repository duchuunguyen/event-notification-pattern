package com.kms.sadp.eda.customer.domain;

public interface CustomerRepository {
    Customer find(Long customerId);

    Customer save(Customer customer);
}
