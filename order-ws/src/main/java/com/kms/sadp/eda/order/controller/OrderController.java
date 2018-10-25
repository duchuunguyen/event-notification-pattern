package com.kms.sadp.eda.order.controller;

import com.kms.sadp.eda.common.domain.Order;
import com.kms.sadp.eda.common.domain.OrderDetails;
import com.kms.sadp.eda.order.domain.OrderRepository;
import com.kms.sadp.eda.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private OrderService orderService;
    private OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderService orderService, OrderRepository orderRepository) {
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    public ResponseEntity<Order> createOrder(@RequestBody OrderDetails detail) {
        Order order = orderService.createOrder(detail);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @RequestMapping(value = "/orders/{orderId}", method = RequestMethod.GET)
    public ResponseEntity<Order> getOrder(@PathVariable String orderId) {

        Order order = orderRepository.find(orderId);

        if (order == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(order, HttpStatus.OK);
        }
    }
}

