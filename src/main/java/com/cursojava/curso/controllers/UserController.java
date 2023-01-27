package com.cursojava.curso.controllers;

import com.cursojava.curso.models.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @RequestMapping(value = "usuario/{id}")
    public User getUser (@PathVariable Long id) {
        User user = new User(); //Creacion del objeto
        user.setId(id);
        user.setName("Mei Li"); //Seteamos el name
        user.setLastName("Ching"); //Seteamos last name OJO TODO AL OBJETO
        user.setEmail("MeiChill@hotmail.com"); //Seteamos el email
        user.setPhoneNumber("24567343"); //Seteamos el phone number
        return user; //Retornamos en formato JSON el objeto user
    }

    @RequestMapping(value = "usuario")
    public List<User> getUsers (@PathVariable Long id) {

        List <User> usuarios = new ArrayList<>(); //Creamos el array list para nuestros usuarios

        User user = new User(); //Creacion del objeto
        user.setId(id);
        user.setName("Alejandro"); //Seteamos el name
        user.setLastName("Ching"); //Seteamos last name OJO TODO AL OBJETO
        user.setEmail("Alejandroching2004@hotmail.com"); //Seteamos el email
        user.setPhoneNumber("2456788"); //Seteamos el phone number


        User user2 = new User(); //Creacion del objeto
        user2.setId(id);
        user2.setName("Sandra"); //Seteamos el name
        user2.setLastName("Franco"); //Seteamos last name OJO TODO AL OBJETO
        user2.setEmail("SandraFranco@hotmail.com"); //Seteamos el email
        user2.setPhoneNumber("24567343"); //Seteamos el phone number


        User user3 = new User(); //Creacion del objeto
        user3.setId(id);
        user3.setName("Marlon"); //Seteamos el name
        user3.setLastName("Ching"); //Seteamos last name OJO TODO AL OBJETO
        user3.setEmail("Marlon@hotmail.com"); //Seteamos el email
        user3.setPhoneNumber("2456343"); //Seteamos el phone number

        usuarios.add(user);
        usuarios.add(user2);
        usuarios.add(user3);

        return usuarios;
    }

    @RequestMapping(value = "usuario2")
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
