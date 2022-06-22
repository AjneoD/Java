package com.web.sprintboot.demo.service;

import com.web.sprintboot.demo.entities.Spid;
import com.web.sprintboot.demo.entities.User;
import com.web.sprintboot.demo.utilities.Status;
import com.web.sprintboot.demo.utilities.array;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SpidService {
    private List<Spid> data = new ArrayList<Spid>();
    private array arr = new array();


    //spid section
    public Spid getSpid(long id) throws Exception {
        for (int i = 0; i < data.size(); ++i) {
            if (data.get(i).getId() == id) {
                return data.get(i);
            }
        }
        throw new Exception(String.format("Spid with an id:'%d' does not exists!", id));
    }

    public Spid createSpid(User user) {
        long id = arr.iota();
        Spid spid = new Spid(id, new Date(), user);
        user.setSpid(spid);
        data.add(spid);
        System.out.println(String.format("Spid %d created successfully!", id));
        return spid;
    }


    public void modifySpid(long id, Status status) throws Exception {
        getSpid(id).setStatus(status);
    }


    public void aproveSpid(long id) throws Exception {
        getSpid(id).setStatus(Status.APPROVED);
    }


    public void showList() {
        System.out.println("\nList of SPIDs: ");
        data.forEach(el -> System.out.println("\t" + el));
    }
}