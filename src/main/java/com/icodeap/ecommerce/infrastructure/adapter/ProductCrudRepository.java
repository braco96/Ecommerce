package com.icodeap.ecommerce.infrastructure.adapter;

import com.icodeap.ecommerce.domain.Product;
import com.icodeap.ecommerce.infrastructure.entity.ProductEntity;
import com.icodeap.ecommerce.infrastructure.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductCrudRepository  extends CrudRepository<ProductEntity, Integer> {
    Iterable<ProductEntity> findByUserEntity (UserEntity userEntity);
}
