package com.seatech.repository.product_repo;

import com.seatech.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Set;

@Repository
@Transactional
public class ProductRepoImpl implements ProductRepo{

    @Autowired
    SessionFactory sessionFactory;

    public List<Product> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Product> products = session.createQuery("from Product p where p.deleted = 'N'").getResultList();
        return products;
    }

    public List<Product> findByName(String keyWord) {
        Session session = sessionFactory.getCurrentSession();
        List<Product> products = session.createQuery("from Product p where LOWER(p.productName) like :keyWord and p.deleted = 'N'")
                .setParameter("keyWord","%"+keyWord.toLowerCase()+"%")
                .getResultList();
        return products;
    }

    public void add(Product product) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.save(product);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public Product findById(String id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = session.get(Product.class,id);
        return product;
    }

    public void delete(String id) {
        Session session = sessionFactory.getCurrentSession();
        try {
            Product product = session.get(Product.class,id);
            product.setDeleted('Y');
            session.merge(product);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public boolean existId(String id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = session.get(Product.class,id);
        if(product!=null)
            return true;
        return false;
    }

    public void update(Product product) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.merge(product);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
