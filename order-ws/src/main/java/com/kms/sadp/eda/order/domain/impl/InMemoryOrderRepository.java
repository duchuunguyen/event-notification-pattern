package com.kms.sadp.eda.order.domain.impl;

import com.kms.sadp.eda.common.domain.Order;
import com.kms.sadp.eda.order.domain.OrderRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class InMemoryOrderRepository implements OrderRepository {
    private Map<String, Order> orders = new HashMap<>();

    @Override
    public Order find(String orderId) {
        if (orders.containsKey(orderId)) {
            return orders.get(orderId);
        }
        return null;
    }

    @Override
    public Order save(Order order) {
        orders.put(order.getId(), order);
        return order;
    }
}
