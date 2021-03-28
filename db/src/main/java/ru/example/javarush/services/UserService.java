package ru.example.javarush.services;

import lombok.NoArgsConstructor;
import ru.example.javarush.dao.UserDAO;
import ru.example.javarush.models.Auto;
import ru.example.javarush.models.User;

import java.util.List;

@NoArgsConstructor
public class UserService {
    private final UserDAO userDao = new UserDAO();

    public User findUser(int id) {
        return userDao.findById(id);
    }

    public void saveUser(User user) {
        userDao.save(user);
    }

    public void deleteUser(User user) {
        userDao.delete(user);
    }

    public void updateUser(User user) {
        userDao.update(user);
    }

    public List<User> findAllUsers() {
        return userDao.findAll();
    }

    public Auto findAuto(int id) {
        return userDao.findAutoById(id);
    }
}
