package com.cursojava.curso.dao;

import com.cursojava.curso.models.User;

import java.util.List;

public interface UserDAO {


    List<User> getUsers();


    void eliminar(Long id);

    void register(User usuario);
}
