package com.seatech.service.logger_service;

import com.seatech.entity.User;
import com.seatech.repository.user_repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoggerService {
    @Autowired
    UserRepo userRepo;

    public User doLogin(User user) {
        return userRepo.doLogin(user);
    }
}
