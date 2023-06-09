package com.cav.springboot.restapi.user;

import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsCommandLineRunner implements CommandLineRunner {

    public UserDetailsCommandLineRunner(UserDetailsRepository repository) {
        super();
        this.repository = repository;
    }

    private Logger logger = LoggerFactory.getLogger(getClass());

    private UserDetailsRepository repository;

    @Override
    public void run(String... args) throws Exception {

      //logger.info(Arrays.toString(args));

        repository.save(new UserDetails("Carlos", "Admin"));
        repository.save(new UserDetails("Maria", "Admin"));

        List<UserDetails> users = repository.findAll();

        users.forEach(user -> logger.info(user.toString()));

        List<UserDetails> usersRole = repository.findByRole("Admin");

        usersRole.forEach(user -> logger.info(user.getName()));

    }
}
