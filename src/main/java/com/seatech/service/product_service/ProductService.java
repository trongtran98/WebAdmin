package com.seatech.service.product_service;

import com.seatech.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface ProductService {
    List<Product> getAll();
    List<Product> findByName(String keyWord);
    void add(Product product);
    void update(Product product);
    Product findById(String id);
    void delete(String id);
    public boolean existId(String id);
}
