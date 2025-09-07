package com.icodeap.ecommerce.application.service;

import com.icodeap.ecommerce.application.repository.OrderRepository;
import com.icodeap.ecommerce.domain.Order;
import com.icodeap.ecommerce.domain.User;

public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(Order order){
        return  orderRepository.createOrder(order);
    }

    public Iterable<Order> getOrders(){
        return  orderRepository.getOrders();
    }

    public Iterable<Order> getOrdersByuser(User user){
        return orderRepository.getOrdersByUser(user);
    }
}
