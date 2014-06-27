package main.java.dao;

import main.java.hibernate.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.List;

public class CommonDAO
{

    private final static Logger LOGGER = Logger.getLogger(CommonDAO.class.getName());


    Session session = HibernateUtil.getSessionFactory().openSession();

    public void save(Object object)
    {
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
    }

    public void saveOrUpdate(Object object)
    {
        session.beginTransaction();
        session.saveOrUpdate(object);
        session.getTransaction().commit();
    }

    public void update(Object object)
    {
        session.beginTransaction();
        session.update(object);
        session.getTransaction().commit();
    }

    public void delete(Object object) {
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
    }

    public <T> List<T> findAll(Class T) {
        Criteria criteria = session.createCriteria(T);
        return criteria.list();
    }
}
