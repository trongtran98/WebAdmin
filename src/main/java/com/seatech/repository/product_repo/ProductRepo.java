package com.seatech.repository.product_repo;

import com.seatech.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ProductRepo {
    List<Product> getAll();
    List<Product> findByName(String keyWord);
    void add(Product product);
    Product findById(String id);
    void delete(String id);
    boolean existId(String id);
    void update(Product product);
}
