package com.kms.sadp.eda.order.service;

import com.kms.sadp.eda.order.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

@Component
public class OrderEventProducer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    public void send(Order order) {
        this.jmsMessagingTemplate.convertAndSend(this.queue, order);
    }
}
