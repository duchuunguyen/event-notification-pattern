package com.kms.sadp.eda.order.service;

import com.kms.sadp.eda.common.domain.Order;
import com.kms.sadp.eda.common.domain.OrderDetails;
import com.kms.sadp.eda.order.domain.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderEventProducer orderEventProducer;

    public Order createOrder(OrderDetails orderDetails) {
        Order order = new Order(orderDetails);
        orderEventProducer.send(order);
        return orderRepository.save(order);
    }

    public Order findOrder(String orderId) {
        return orderRepository.find(orderId);
    }
}
