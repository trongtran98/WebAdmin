package com.seatech.repository.group_repo;

import com.seatech.entity.Group;
import com.seatech.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Repository
@Transactional
public class GroupRepoImpl implements GroupRepo {
    @Autowired
    SessionFactory sessionFactory;

    public List<Group> getAll()
    {
        Session session = sessionFactory.getCurrentSession();
        List<Group> groups = session.createQuery("from Group g").getResultList();
        return groups;
    }

    public Group findById(String id) {
        Session session = sessionFactory.getCurrentSession();
        Group group = session.get(Group.class,id);
        return group;
    }

    public Group findByProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        Group group = (Group) session.createQuery( "select p.group from Product p where p.productId = :productId")
                .setParameter("productId",product.getProductId())
                .getSingleResult();
        return group;
    }
}
