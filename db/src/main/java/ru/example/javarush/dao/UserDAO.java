package ru.example.javarush.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.example.javarush.models.Auto;
import ru.example.javarush.models.User;
import ru.example.javarush.utils.HibernateSessionFactoryUtil;

import java.util.List;

public class UserDAO implements DAO<User> {
    @Override
    public User findById(int id) {
        Session session = getSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    @Override
    public void save(User entity) {
        Session session = getSession();
        Transaction tx1 = session.beginTransaction();
        session.save(entity);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(User entity) {
        Session session = getSession();
        Transaction tx1 = session.beginTransaction();
        session.update(entity);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(User entity) {
        Session session = getSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(entity);
        tx1.commit();
        session.close();
    }

    @Override
    public List<User> findAll() {
        Session session = getSession();
        List<User> list = (List<User>) session.createQuery("From User").list();
        session.close();
        return list;
    }

    public Auto findAutoById(int id) {
        Session session = getSession();
        Auto auto = session.get(Auto.class, id);
        session.close();
        return auto;
    }

    private Session getSession() {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession();
    }
}
