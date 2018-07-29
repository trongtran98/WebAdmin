package com.seatech.repository.user_repo;

import com.seatech.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;

@Repository
@Transactional
public class UserRepoImpl implements UserRepo{
    @Autowired
    SessionFactory sessionFactory;

    public User doLogin(User user) {
        User user_verified = null;
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User u where u.username = :username and u.password = :password")
                .setParameter("username",user.getUsername())
                .setParameter("password",user.getPassword());
        try {
            user_verified = (User) query.getSingleResult();
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
        return user_verified;
    }
}
