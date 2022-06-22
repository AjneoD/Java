package com.web.sprintboot.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

public class Base {
    private long id;
    private Date createdAt;

    public Base() {
    }

    public Base(long id, Date createdAt) {
        this.id = id;
        this.createdAt = createdAt;
    }

}