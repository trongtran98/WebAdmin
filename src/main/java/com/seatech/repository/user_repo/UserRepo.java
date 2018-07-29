package com.seatech.repository.user_repo;

import com.seatech.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo {
    User doLogin(User user);
}
