package com.icodeap.ecommerce.infrastructure.adapter;

import com.icodeap.ecommerce.infrastructure.entity.ProductEntity;
import com.icodeap.ecommerce.infrastructure.entity.StockEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StockCrudRepository extends CrudRepository<StockEntity, Integer> {
    List<StockEntity> findByProductEntity(ProductEntity productEntity);
}
