package com.cursojava.curso.controllers;

import com.cursojava.curso.dao.UserDAO;
import com.cursojava.curso.dao.UserDaoImp;
import com.cursojava.curso.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserDAO usuarioDao;

    @RequestMapping(value = "api/usuario/{id}")
    public User getUser (@PathVariable Long id) {
        User user = new User(); //Creacion del objeto
        user.setId(id);
        user.setName("Mei Li"); //Seteamos el name
        user.setLastName("Ching"); //Seteamos last name OJO TODO AL OBJETO
        user.setEmail("MeiChill@hotmail.com"); //Seteamos el email
        user.setPhoneNumber("24567343"); //Seteamos el phone number
        return user; //Retornamos en formato JSON el objeto user
    }

    @RequestMapping(value = "api/usuarios")
    public List<User> getUsers () {
        return usuarioDao.getUsers();
    }

    @RequestMapping(value = "api/usuario2")
    public User editar () {
        User user = new User(); //Creacion del objeto
        user.setName("Alejandro"); //Seteamos el name
        user.setLastName("Ching"); //Seteamos last name OJO TODO AL OBJETO
        user.setEmail("Alejandroching2004@hotmail.com"); //Seteamos el email
        user.setPhoneNumber("2456788"); //Seteamos el phone number
        return user; //Retornamos en formato JSON el objeto user
    }

    @RequestMapping(value = "usuario3")
    public User eliminar () {
        User user = new User(); //Creacion del objeto
        user.setName("Alejandro"); //Seteamos el name
        user.setLastName("Ching"); //Seteamos last name OJO TODO AL OBJETO
        user.setEmail("Alejandroching2004@hotmail.com"); //Seteamos el email
        user.setPhoneNumber("2456788"); //Seteamos el phone number
        return user; //Retornamos en formato JSON el objeto user
    }

    @RequestMapping(value = "usuario4")
    public User buscar () {
        User user = new User(); //Creacion del objeto
        user.setName("Alejandro"); //Seteamos el name
        user.setLastName("Ching"); //Seteamos last name OJO TODO AL OBJETO
        user.setEmail("Alejandroching2004@hotmail.com"); //Seteamos el email
        user.setPhoneNumber("2456788"); //Seteamos el phone number
        return user; //Retornamos en formato JSON el objeto user
    }
}
