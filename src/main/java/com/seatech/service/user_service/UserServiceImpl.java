package com.seatech.service.user_service;

import com.seatech.entity.User;
import com.seatech.repository.user_repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepo userRepo;

    public User doLogin(User user) {
        return userRepo.doLogin(user);
    }
}
