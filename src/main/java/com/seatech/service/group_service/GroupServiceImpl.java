package com.seatech.service.group_service;

import com.seatech.entity.Group;
import com.seatech.entity.Product;
import com.seatech.repository.group_repo.GroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    GroupRepo groupRepo;

    public List<Group> getAll() {
        return groupRepo.getAll();
    }

    public Group findById(String id) {
        return groupRepo.findById(id);
    }

    public Group findByProduct(Product product) {
        return groupRepo.findByProduct(product);
    }
}
