package com.kms.sadp.eda.common.domain;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class OrderDetails implements Serializable {
    private Long customerId;
    private Long orderTotal;

    public OrderDetails() {
    }

    public OrderDetails(Long customerId, Long orderTotal) {
        this.customerId = customerId;
        this.orderTotal = orderTotal;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
