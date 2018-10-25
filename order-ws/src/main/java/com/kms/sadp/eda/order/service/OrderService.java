package com.kms.sadp.eda.order.service;

import com.kms.sadp.eda.order.domain.Order;
import com.kms.sadp.eda.order.domain.OrderDetails;
import com.kms.sadp.eda.order.domain.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

//  @Autowired
//  private DomainEventPublisher domainEventPublisher;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderEventProducer orderEventProducer;

    public Order createOrder(OrderDetails orderDetails) {
//    ResultWithEvents<Order> orderWithEvents = Order.createOrder(orderDetails);
//    Order order = orderWithEvents.result;
        Order order = new Order(orderDetails);
        orderEventProducer.send(order);
        return orderRepository.save(order);
//    domainEventPublisher.publish(Order.class, order.getId(), orderWithEvents.events);
    }

//  public void approveOrder(Long orderId) {
//    Order order = orderRepository.findOne(orderId);
//    order.noteCreditReserved();
//    domainEventPublisher.publish(Order.class,
//            orderId, singletonList(new OrderApprovedEvent(order.getOrderDetails())));
//  }
//
//  public void rejectOrder(Long orderId) {
//    Order order = orderRepository.findOne(orderId);
//    order.noteCreditReservationFailed();
//    domainEventPublisher.publish(Order.class,
//            orderId, singletonList(new OrderRejectedEvent(order.getOrderDetails())));
//  }
}
