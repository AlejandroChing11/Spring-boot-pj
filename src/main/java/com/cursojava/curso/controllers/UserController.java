package com.cursojava.curso.controllers;

import com.cursojava.curso.models.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @RequestMapping(value = "usuario")
    public User getUser () {
        User user = new User(); //Creacion del objeto
        user.setName("Alejandro"); //Seteamos el name
        user.setLastName("Ching"); //Seteamos last name OJO TODO AL OBJETO
        user.setEmail("Alejandroching2004@hotmail.com"); //Seteamos el email
        user.setPhoneNumber("2456788"); //Seteamos el phone number
        return user; //Retornamos en formato JSON el objeto user
    }
}
