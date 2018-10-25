# event-notification-pattern
Demo project to demonstrate event notification pattern
- Need to install Apache ActiveMQ locally to help order-ws and customer-ws work properly
- Order-ws manage orders, support creating and querying orders.
- Customer-ws manages customers + their balance. There're 2 existing customers in the system with customerId = 1|2. Customer-ws handle the order and check the customer balance to determine the payment is valid or not, then send the corresponding event to message queue

Nice to have feature:
- Update projects to support building docker images
- Support docker-compose to setup ActiveMQ + order-ws + customer-ws

Note: please ignore the coding style. It's just for the demo purpose

Thanks,
