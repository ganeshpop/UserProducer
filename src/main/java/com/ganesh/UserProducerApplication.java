package com.ganesh;

import com.ganesh.bean.User;
import com.ganesh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = "com.ganesh")
@EnableJpaRepositories(basePackages = "com.ganesh.persistence")
@EntityScan(basePackages = "com.ganesh.bean")
public class UserProducerApplication implements CommandLineRunner {
    private UserService userService;


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(UserProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userService.insertUser(new User(1, "Ganesh", "password"));
        userService.insertUser(new User(2, "Rajesh", "password"));
        userService.insertUser(new User(3, "Ben", "password"));
        userService.insertUser(new User(4, "Oman", "password"));
        userService.insertUser(new User(5, "Hari", "password"));
    }
}
