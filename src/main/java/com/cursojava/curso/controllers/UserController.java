package com.cursojava.curso.controllers;

import com.cursojava.curso.dao.UserDAO;
import com.cursojava.curso.models.User;
import com.cursojava.curso.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserDAO usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/users/{id}", method = RequestMethod.GET)
    public User getUser (@PathVariable Long id) {
        User user = new User(); //Creacion del objeto
        user.setId(id);
        user.setName("Mei Li"); //Seteamos el name
        user.setLastName("Ching"); //Seteamos last name OJO TODO AL OBJETO
        user.setEmail("MeiChill@hotmail.com"); //Seteamos el email
        user.setPhoneNumber("24567343"); //Seteamos el phone number
        return user; //Retornamos en formato JSON el objeto user
    }

    @RequestMapping(value = "api/users", method = RequestMethod.GET)
    public List<User> getUsers (@RequestHeader(value="Authorization") String token) {
        if (!validarToken(token)) {
            return null;
        }


        return usuarioDao.getUsers();
    }

    private boolean validarToken(String token) {
        String usuarioId = jwtUtil.getKey(token);
        return usuarioId != null;
    }

    @RequestMapping(value = "api/users", method = RequestMethod.POST)
    public void registrarUsuario (@RequestBody User usuario) {

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        argon2.hash(1, 1024, 1, usuario.getPassword());
        String hash = argon2.hash(1, 1024, 1, usuario.getPassword());
        usuario.setPassword(hash);

        usuarioDao.register(usuario);
    }

    @RequestMapping(value = "api/users/{id}", method = RequestMethod.DELETE)
    public void eliminar (@RequestHeader(value="Authorization") String token , @PathVariable Long id) {
        if (!validarToken(token)) {
            return;
        }
        usuarioDao.eliminar(id);
    }

}
