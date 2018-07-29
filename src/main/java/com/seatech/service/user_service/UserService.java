package com.seatech.service.user_service;

import com.seatech.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User doLogin(User user);
}
