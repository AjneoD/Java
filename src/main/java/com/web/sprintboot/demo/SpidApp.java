package com.web.sprintboot.demo;

import com.web.sprintboot.demo.entities.Spid;
import com.web.sprintboot.demo.entities.User;
import com.web.sprintboot.demo.service.SpidService;
import com.web.sprintboot.demo.service.UserService;
import com.web.sprintboot.demo.utilities.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpidApp implements CommandLineRunner {
    @Autowired
    public UserService userService;
    @Autowired
    public SpidService spidService;

    public static void main(String[] args) {
        SpringApplication.run(SpidApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try {

            User newUser = userService.createUser("Ajneo", "Dalipi", "AjneoD");
            System.out.println(newUser);

            Spid newSpid = spidService.createSpid(newUser);
            System.out.println(newSpid);

            spidService.aproveSpid(1);

            spidService.showList();

            System.out.println(userService.showSpidOf("AjneoD"));

            System.out.println("Modifying user with the user of 'AjneoD'");
            // Modify user (Only the surname)
            userService.modifyUser("AjneoD", "hello", "AjneoD");

            System.out.println("Modify the SPID with the id of 1 ");
            spidService.modifySpid(1, Status.READY_FOR_REVIEW);
            System.out.println(newSpid);
        } catch (Exception err) {
            System.out.println("There was an error!");
        }
    }
}