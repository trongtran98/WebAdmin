package com.seatech.service.group_service;

import com.seatech.entity.Group;
import com.seatech.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface GroupService {
    List<Group> getAll();
    Group findById(String id);
    Group findByProduct(Product product);
}
