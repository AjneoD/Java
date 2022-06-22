package com.web.sprintboot.demo.entities;

import com.web.sprintboot.demo.utilities.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Spid extends Base {
    private User user;
    private Status status;

    public Spid(){

    }


    public Spid(long id, Date createdAt, User user) {
        super(id, createdAt);
        this.user = user;
        this.status = Status.PENDING; // Setting to default state
    }

    @Override
    public String toString() {
        return "Spid{" +
                "user=" + user +
                ", status=" + status +
                '}';
    }
}