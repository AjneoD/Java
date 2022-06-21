package Entities;

import java.util.Date;

public class Spid extends Base {
    private User user;
    private Status status;

    public Spid() {

    }

    public Spid(long id, Date createdAt, User user) {
        super(id, createdAt);
        this.user = user;
        this.status = Status.PENDING; // Setting to default state
    }


    @Override
    public String toString() {
        return "Spid{" +
                "id=" + getId() +
                ", user=" + user +
                ", status='" + status + '\'' +
                '}';
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Status getStatus() {
        return this.status;
    }
    public void setStatus(Status status) throws Exception {
        this.status = status;
    }
}