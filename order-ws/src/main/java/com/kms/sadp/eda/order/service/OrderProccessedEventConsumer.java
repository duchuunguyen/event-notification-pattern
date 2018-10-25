package com.kms.sadp.eda.order.service;

import com.kms.sadp.eda.common.domain.Order;
import com.kms.sadp.eda.common.domain.OrderState;
import com.kms.sadp.eda.common.event.OrderEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import java.text.MessageFormat;

@Component
public class OrderProccessedEventConsumer {
    @Autowired
    private OrderService orderService;

    @JmsListener(destination = "orderProcessed.queue")
    public void receiveQueue(OrderEvent event) {
        System.out.println("Receive event: " + event.toString());
        // find customer and check credit
        Order order = orderService.findOrder(event.getPayload().getId());
        OrderState state = OrderEvent.DEBIT_RESERVED.equals(event.getEventType()) ? OrderState.APPROVED : OrderState.REJECTED;
        System.out.println(MessageFormat.format("Change order [{0}] state to [{1}]", order, state));
        order.setState(state);
    }
}
