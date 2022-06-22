package com.web.sprintboot.demo.entities;

import lombok.*;

import java.util.Date;

@Getter
@Setter
public class User extends Base {
    private String name;
    private String surname;
    private String username;
    private Spid spid;
    public User(){

    }

    public User(long id, Date createdAt, String name, String surname, String username) {
        super(id, createdAt);
        this.name = name;
        this.surname = surname;
        this.username = username;
    }
    @Override
    public String toString() {
        return "User{" +
                "id='" + getId() + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

}