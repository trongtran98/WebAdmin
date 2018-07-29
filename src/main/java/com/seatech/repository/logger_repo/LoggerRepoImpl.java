package com.seatech.repository.logger_repo;

import com.seatech.entity.LoggerLogin;
import com.seatech.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class LoggerRepoImpl implements LoggerRepo {
    @Autowired
    SessionFactory sessionFactory;

    public void logLoginTime(LoggerLogin loggerLogin) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.save(loggerLogin);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
