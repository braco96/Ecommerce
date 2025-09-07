package com.icodeap.ecommerce.application.repository;

import com.icodeap.ecommerce.domain.Order;
import com.icodeap.ecommerce.domain.User;

public interface OrderRepository {
    public Order createOrder(Order order);
    public Iterable<Order> getOrders();
    public Iterable<Order> getOrdersByUser(User user);
}
