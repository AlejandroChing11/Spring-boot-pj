package com.cursojava.curso.controllers;

import com.cursojava.curso.dao.UserDAO;
import com.cursojava.curso.models.User;
import com.cursojava.curso.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login (@RequestBody User usuario) {
        User usuarioLogeado = userDao.obtenerUsuarioPorCredenciales(usuario);
       if (usuarioLogeado != null){
           String tokenJwt = jwtUtil.create(String.valueOf(usuarioLogeado.getId()), usuarioLogeado.getEmail());
           return tokenJwt;

       }
           return "ERROR";
    }

}
