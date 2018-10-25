package com.kms.sadp.eda.customer.domain;

public interface CustomerRepository {
    Customer find(String orderId);

    Customer save(Customer order);
}
