package com.icodeap.ecommerce.infrastructure.adapter;

import com.icodeap.ecommerce.application.repository.OrderRepository;
import com.icodeap.ecommerce.domain.Order;
import com.icodeap.ecommerce.domain.User;
import com.icodeap.ecommerce.infrastructure.mapper.OrderMapper;
import com.icodeap.ecommerce.infrastructure.mapper.UserMapper;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
    private final OrderCrudRepository orderCrudRepository;
    private final OrderMapper orderMapper;
    private  final UserMapper userMapper;

    public OrderRepositoryImpl(OrderCrudRepository orderCrudRepository, OrderMapper orderMapper, UserMapper userMapper) {
        this.orderCrudRepository = orderCrudRepository;
        this.orderMapper = orderMapper;
        this.userMapper = userMapper;
    }

    @Override
    public Order createOrder(Order order) {
        return orderMapper.toOrder( orderCrudRepository.save( orderMapper.toOrderEntity(order) ) );
    }

    @Override
    public Iterable<Order> getOrders() {
        return orderMapper.toOrders( orderCrudRepository.findAll() );
    }

    @Override
    public Iterable<Order> getOrdersByUser(User user) {
        return orderMapper.toOrders(orderCrudRepository.findByUser(userMapper.toUserEntity(user) ));
    }
}
