package com.web.sprintboot.demo.service;

import com.web.sprintboot.demo.entities.Spid;
import com.web.sprintboot.demo.entities.User;
import com.web.sprintboot.demo.utilities.array;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    private List<User> data = new ArrayList<User>();
    private array arr = new array();

    private Set<String> usernames = new HashSet<String>();


    private boolean doesUsernameExists(String username) {
        return usernames.contains(username);
    }

    private User getUser(String username) throws Exception {
        for (int i = 0; i < data.size(); ++i) {
            if (data.get(i).getUsername() == username) {
                return data.get(i);
            }
        }
        throw new Exception("Username does not exists!");
    }

    public User createUser(String name, String surname, String username) throws Exception {
        if (doesUsernameExists(username)) {
            throw new Exception("Username already in use!");
        }
        long id = arr.iota();
        User user = new User(id, new Date(), name, surname, username);
        data.add(user);
        usernames.add(username);
        System.out.println(String.format("User %d was created successfully!", id));
        return user;
    }


    public void modifyUser(String username, String name, String surname) throws Exception {
        if (name != null) {
            getUser(username).setName(name);
        }

        if (surname != null) {
            getUser(username).setSurname(surname);
        }
    }


    public Spid showSpidOf(String username) throws Exception {
        if (!doesUsernameExists(username)) throw new Exception("The user your are searching for does not exists!");

        for (int i = 0; i < data.size(); ++i) {
            if (data.get(i).getUsername() == username) {
                return data.get(i).getSpid();
            }
        }
        return null;
    }
}