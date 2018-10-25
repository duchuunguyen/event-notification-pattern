package com.kms.sadp.eda.common.domain;

import com.google.gson.Gson;
import com.kms.sadp.eda.common.utils.UUIDGenerator;
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

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
