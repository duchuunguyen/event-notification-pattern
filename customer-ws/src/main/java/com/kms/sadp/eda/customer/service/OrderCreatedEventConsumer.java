package com.kms.sadp.eda.customer.service;

import com.kms.sadp.eda.common.event.OrderEvent;
import com.kms.sadp.eda.customer.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

@Component
public class OrderCreatedEventConsumer {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private Queue queue;

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @JmsListener(destination = "orderCreated.queue")
    public void receiveQueue(OrderEvent event) {
        System.out.println("Receive event: " + event.toString());
        // find customer and check credit
        Customer customer = customerService.find(event.getPayload().getOrderDetails().getCustomerId());
        jmsMessagingTemplate.convertAndSend(this.queue, customer.getMoney() >= event.getPayload().getOrderDetails().getOrderTotal()
                ? OrderEvent.debitReservedEvent(event.getPayload())
                : OrderEvent.debitNotEnoughEvent(event.getPayload()));
    }
}
