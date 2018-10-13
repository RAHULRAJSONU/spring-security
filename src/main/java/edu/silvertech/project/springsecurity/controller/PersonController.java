package edu.silvertech.project.springsecurity.controller;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RestController
@RequestMapping("/api")
public class PersonController {

    @RequestMapping(value = "/{name}",method = RequestMethod.GET, produces = "application/json")
    protected String sayHello(@PathVariable("name") String name, @AuthenticationPrincipal final UserDetails userDetails) {
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        authorities.stream().forEach(System.out::print);
        return "Hey "+name;
    }
}
