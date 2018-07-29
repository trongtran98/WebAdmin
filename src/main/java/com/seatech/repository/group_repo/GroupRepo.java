package com.seatech.repository.group_repo;

import com.seatech.entity.Group;
import com.seatech.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface GroupRepo {
    List<Group> getAll();
    Group findById(String id);
    Group findByProduct(Product product);
}
