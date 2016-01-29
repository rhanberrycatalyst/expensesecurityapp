package com.catalyst.springboot.webservices;

import com.catalyst.springboot.entities.EndUser;
import com.catalyst.springboot.services.EndUserService;
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
    private EndUserService userService;

    public void setuserService(EndUserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value="/security/current", method=RequestMethod.GET)
    public EndUser currentUser(Principal principal){
        return userService.getUserByUsername(principal.getName());
    }

    @RequestMapping(value = "/signin", method = RequestMethod.GET)

    public String loginPage() {
        return "/signin.html";
    }

//    // Map all urls to this method aside from ones starting with api
//    @RequestMapping(value = "/**")
//    public String getIndex() {
//        // return the view called "index.html" (in the current directory)
//        return "/index";
//    }
}
