package com.kms.sadp.eda.order.service;

import com.kms.sadp.eda.common.domain.Order;
import com.kms.sadp.eda.common.event.OrderEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import java.text.MessageFormat;

@Component
public class OrderEventProducer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    public void send(Order order) {
        System.out.println(MessageFormat.format("Persist orderCreated event for [{0}]", order));
        this.jmsMessagingTemplate.convertAndSend(this.queue, OrderEvent.orderCreatedEvent(order));
    }
}
