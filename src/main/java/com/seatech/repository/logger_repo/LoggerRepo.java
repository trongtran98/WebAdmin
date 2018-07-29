package com.seatech.repository.logger_repo;

import com.seatech.entity.LoggerLogin;
import com.seatech.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggerRepo {
    void logLoginTime(LoggerLogin loggerLogin);
}
