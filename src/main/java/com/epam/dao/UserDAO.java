package com.epam.dao;

import com.epam.model.User;
import com.epam.model.utill.UserRole;

import java.util.ArrayList;

public class UserDAO {
    private static ArrayList<User> users;

    public UserDAO() {
        initialise();
    }

    private void initialise() {
        users = new ArrayList<User>();
        users.add(new User(1, "login1", "password1", UserRole.NEW_USER));
        users.add(new User(2, "login2", "password2", UserRole.NEW_USER));
        users.add(new User(3, "login3", "password3", UserRole.NEW_USER));
        users.add(new User(4, "login4", "password4", UserRole.SIMPLE_USER));
        users.add(new User(5, "login5", "password5", UserRole.SIMPLE_USER));
        users.add(new User(6, "login6", "password6", UserRole.SIMPLE_USER));
        users.add(new User(7, "login7", "password7", UserRole.OLD_USER));
        users.add(new User(8, "login8", "password8", UserRole.OLD_USER));
        users.add(new User(9, "login9", "password9", UserRole.OLD_USER));
        users.add(new User(10, "login10", "password10", UserRole.SIMPLE_USER));
        users.add(new User(11, "admin", "adminPassword", UserRole.ADMIN));

    }

    public void add(User user) {
        users.add(user);
    }

    public boolean containsUserWithLogin(String login) {
        return getByLogin(login) == null ? false : true;
    }

    public boolean checkLoginAndPassword(String login, String password) {
        if (containsUserWithLogin(login)) {
            return getByLogin(login).getPassword().equals(password);
        }
        return false;
    }

    public boolean delete(User user) {
        return users.remove(user);
    }

    public boolean deleteById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                users.remove(user);
                return true;
            }
        }
        return false;
    }

    public void addUser(User user){
        users.add(user);
    }
    public boolean deleteByLogin(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                users.remove(user);
                return true;
            }
        }
        return false;
    }

    public ArrayList<User> getAll() {
        return users;
    }

    public User getById(Integer id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User getByLogin(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    public User getAdmin() {
        for (User user : users) {
            if (user.getRole().equalsIgnoreCase(UserRole.ADMIN))
                return user;
        }
        return null;
    }

    public boolean verifyIsUserAdmin(User user) {
        if (user.getRole().equalsIgnoreCase(UserRole.ADMIN))
            return true;
        return false;
    }
    public ArrayList<User> getAllUsersByRole(String role){
        ArrayList<User>userByRole = new ArrayList<User>();
        for (User user : users) {
            if(user.getRole().equals(role))
                userByRole.add(user);
        }
        return userByRole;
    }

    public ArrayList<User> getAllNewUsers() {
        ArrayList<User> newUsers = new ArrayList<User>();
        for (User user : users) {
            if (user.getRole().equalsIgnoreCase(UserRole.NEW_USER))
                newUsers.add(user);
        }
        return newUsers;
    }
    public ArrayList<User> getAllOldUsers() {
        ArrayList<User> oldUsers = new ArrayList<User>();
        for (User user : users) {
            if (user.getRole().equalsIgnoreCase(UserRole.OLD_USER))
                oldUsers.add(user);
        }
        return oldUsers;
    }

    public ArrayList<User> getAllSimpleUsers() {
        ArrayList<User> simpleUsers = new ArrayList<User>();
        for (User user : users) {
            if (user.getRole().equalsIgnoreCase(UserRole.SIMPLE_USER))
                simpleUsers.add(user);
        }
        return simpleUsers;
    }

    public String showRole(Integer id) {
        return getById(id).getRole();
    }

}
