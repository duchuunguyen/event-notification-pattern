package com.kms.sadp.eda.order.domain;

public interface OrderRepository {
    Order find(String orderId);
    Order save(Order order);
}
