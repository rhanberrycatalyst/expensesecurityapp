package com.catalyst.springboot.webservices;

import com.catalyst.springboot.entities.User;
import com.catalyst.springboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by rhanberry on 1/25/2016.
 */

@RestController
public class SecurityWebService {
    @Autowired
    private UserService userService;

    public void setuserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value="/security/current", method=RequestMethod.GET)
    public User currentUser(Principal principal){
        return userService.getUserByUsername(principal.getName());
    }
}
