package com.kms.sadp.eda.common.event;

import com.google.gson.Gson;
import com.kms.sadp.eda.common.domain.Order;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class OrderEvent extends Event {
    public static final String ORDER_CREATED = "orderCreated";
    public static final String DEBIT_RESERVED = "debitReserved";
    public static final String DEBIT_NOT_ENOUGH = "debitNotEnough";

    private Order payload;

    private OrderEvent(String eventType, Order order) {
        this.payload = order;
        setEventType(eventType);
    }

    public static OrderEvent orderCreatedEvent(Order order) {
        return new OrderEvent(ORDER_CREATED, order);
    }

    public static OrderEvent debitReservedEvent(Order order) {
        return new OrderEvent(DEBIT_RESERVED, order);
    }

    public static OrderEvent debitNotEnoughEvent(Order order) {
        return new OrderEvent(DEBIT_NOT_ENOUGH, order);
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
