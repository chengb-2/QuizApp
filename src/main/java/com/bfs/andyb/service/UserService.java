package com.bfs.andyb.service;

import com.bfs.andyb.dao.UserDao;
import com.bfs.andyb.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) { this.userDao = userDao; }

    public int createNewUser(String username, String password, String firstname, String lastname, String phone, String address, String email) {
        return userDao.createNewUser(username, password, false, true, firstname, lastname, phone, address, email);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public Optional<User> getUserById(int id) {
//        return userDao.getAllUsers().stream()
//                .filter(a -> a.getId() == id)
//                .findFirst()
//                .orElse(new User(-1, "invalid username", "invalid password"));
        Optional<User> possibleUser = Optional.ofNullable(userDao.getUserById(id));
        return possibleUser;
    }

    public Optional<User> getUserByUsername(String username) {
        Optional<User> possibleUser = Optional.ofNullable(userDao.getUserByUsername(username));
        return possibleUser;
    }

    public Optional<User> validateLogin(String username, String password) {
//        System.out.println("validateLogin");
//        System.out.println(userDao.getAllUsers().toString());
        return userDao.getAllUsers().stream()
                .filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password))
                .findAny();
    }

    public int setIs_activeById(Integer id, Integer action) {
        return userDao.setIs_activeById(id, action);
    }

}
