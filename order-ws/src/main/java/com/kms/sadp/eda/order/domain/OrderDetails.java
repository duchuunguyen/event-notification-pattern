package com.kms.sadp.eda.order.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetails {
  private Long customerId;
  private Long orderTotal;

  public OrderDetails() {
  }

  public OrderDetails(Long customerId, Long orderTotal) {
    this.customerId = customerId;
    this.orderTotal = orderTotal;
  }
}
