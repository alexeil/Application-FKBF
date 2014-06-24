package main.java.dao;


import main.java.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;

public class CommonDAO
{

    Session session = HibernateUtil.getSessionFactory().openSession();

    public void saveToDB(Object object)
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

    public void updateToDB(Object object)
    {
           session.beginTransaction();
        session.update(object);
        session.getTransaction().commit();
    }


    public void deleteToDB(Object object)
    {
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
    }

}
