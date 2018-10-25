package com.kms.sadp.eda.customer.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {
  private Long id;
  private String name;
  private Long money;

//  Money availableCredit() {
//    return money.subtract(creditReservations.values().stream().reduce(Money.ZERO, Money::add));
//  }

  public Customer() {
  }

  public Customer(Long id, String name, Long money) {
      this.id = id;
      this.name = name;
      this.money = money;
  }

//  public static ResultWithEvents<Customer> create(String name, Money creditLimit) {
//    Customer customer = new Customer(name, creditLimit);
//    return new ResultWithEvents<>(customer,
//            singletonList(new CustomerCreatedEvent(customer.getName(), customer.getMoney())));
//  }

//  public void reserveCredit(Long orderId, Money orderTotal) {
//    if (availableCredit().isGreaterThanOrEqual(orderTotal)) {
//      creditReservations.put(orderId, orderTotal);
//    } else
//      throw new CustomerCreditLimitExceededException();
//  }
}
