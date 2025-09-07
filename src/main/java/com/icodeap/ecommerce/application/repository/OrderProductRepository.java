package com.icodeap.ecommerce.application.repository;

import com.icodeap.ecommerce.domain.Order;
import com.icodeap.ecommerce.domain.OrderProduct;

import java.util.List;

public interface OrderProductRepository {
    public OrderProduct create (OrderProduct orderProduct);
    public Iterable<OrderProduct>  getOrderProducts();
    public List<OrderProduct> getOrdersProductByOrder(Order order);
}
