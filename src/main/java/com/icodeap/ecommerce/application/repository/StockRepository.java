package com.icodeap.ecommerce.application.repository;

import com.icodeap.ecommerce.domain.Product;
import com.icodeap.ecommerce.domain.Stock;

import java.util.List;

public interface StockRepository {
    Stock saveStock(Stock stock);
    List<Stock> getStockByProduct(Product product);
}
