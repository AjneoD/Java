package Entities;

import java.util.Date;

public class User extends Base {
    private String name;
    private String surname;
    private String username;
    private Spid spid;

    public User() {}

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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Spid getSpid() {
        return this.spid;
    }

    public void setSpid(Spid spid) {
        this.spid = spid;
    }
}