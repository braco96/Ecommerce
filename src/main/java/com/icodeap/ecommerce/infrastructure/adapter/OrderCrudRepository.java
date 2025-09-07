package com.icodeap.ecommerce.infrastructure.adapter;

import com.icodeap.ecommerce.infrastructure.entity.OrderEntity;
import com.icodeap.ecommerce.infrastructure.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderCrudRepository extends CrudRepository<OrderEntity , Integer> {
    public Iterable<OrderEntity> findByUser(UserEntity userEntity);
}
