package com.seatech.service.logger_service;

import com.seatech.entity.LoggerLogin;
import com.seatech.entity.User;
import com.seatech.repository.logger_repo.LoggerRepo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;



@Aspect
public class LoggerAspectJ {
    @Autowired
    LoggerRepo loggerRepo;

    @AfterReturning(pointcut = "execution(* com.seatech.service.logger_service.LoggerService.doLogin(..))", returning = "user_verified")
    public void logAfterLoginSuccess(Object user_verified) {
        if (user_verified != null) {
            LoggerLogin loggerLogin = new LoggerLogin();
            loggerLogin.setLgId("lg" + System.currentTimeMillis());
            loggerLogin.setUser((User) user_verified);
            loggerRepo.logLoginTime(loggerLogin);
        }
    }


    @Before(value = "execution(* com.seatech.service.logger_service.LoggerService.doLogin(..))")
    public void c(JoinPoint point) {
        System.out.println("chạy vào đây đầu tiên "+((User)(point.getArgs()[0])).getUsername());
    }
}
