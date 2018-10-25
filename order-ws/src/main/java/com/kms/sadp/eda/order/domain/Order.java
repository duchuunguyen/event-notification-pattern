package com.kms.sadp.eda.order.domain;

import com.kms.sadp.eda.order.utils.UUIDGenerator;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Order implements Serializable {
    private String id;
    private OrderState state;
    private OrderDetails orderDetails;

    public Order(OrderDetails orderDetails) {
        this.id = UUIDGenerator.generateUUID();
        this.orderDetails = orderDetails;
        this.state = OrderState.PENDING;
    }

//  public static ResultWithEvents<Order> createOrder(OrderDetails orderDetails) {
//    Order order = new Order(orderDetails);
//    OrderCreatedEvent orderCreatedEvent = new OrderCreatedEvent(orderDetails);
//    return new ResultWithEvents<>(order, singletonList(orderCreatedEvent));
//  }

    public void noteCreditReserved() {
        this.state = OrderState.APPROVED;
    }

    public void noteCreditReservationFailed() {
        this.state = OrderState.REJECTED;
    }
}
