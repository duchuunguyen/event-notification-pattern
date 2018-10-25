package com.kms.sadp.eda.customer;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.jms.Queue;

@SpringBootApplication
public class CustomerServiceApp {
    @Bean
    public Queue queue() {
        return new ActiveMQQueue("orderProcessed.queue");
    }

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApp.class, args);
    }
}
