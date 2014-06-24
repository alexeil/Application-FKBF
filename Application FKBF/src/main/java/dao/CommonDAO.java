package main.java.dao;

import main.java.hibernate.HibernateUtil;
import org.hibernate.Session;

public class CommonDAO
{

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

    public void delete(Object object)
    {
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
    }

}
