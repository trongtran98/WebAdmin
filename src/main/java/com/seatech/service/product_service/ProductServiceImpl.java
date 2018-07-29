package com.seatech.service.product_service;

import com.seatech.entity.Product;
import com.seatech.repository.product_repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepo productRepo;

    public List<Product> getAll() {
        return productRepo.getAll();
    }

    public List<Product> findByName(String keyWord) {
        return productRepo.findByName(keyWord);
    }

    public void add(Product product) {
        productRepo.add(product);
    }

    public Product findById(String id) {
        return productRepo.findById(id);
    }

    public void delete(String id) {
        productRepo.delete(id);
    }

    public boolean existId(String id) {
        return productRepo.existId(id);
    }

    public void update(Product product) {
        productRepo.update(product);
    }
}
