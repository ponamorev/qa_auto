package ru.example.javarush.dao;

import java.util.List;

public interface DAO<T> {
    public T findById(int id);

    public void save(T entity);

    public void update(T entity);

    public void delete(T entity);

    public List<T> findAll();
}
