package com.kms.sadp.eda.order.domain;

import com.kms.sadp.eda.common.domain.Order;

public interface OrderRepository {
    Order find(String orderId);

    Order save(Order order);
}
