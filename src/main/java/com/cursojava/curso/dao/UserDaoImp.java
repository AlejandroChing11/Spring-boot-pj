package com.cursojava.curso.dao;

import com.cursojava.curso.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class UserDaoImp implements UserDAO{


    @Override
    public List<User> getUsers() {
        return null;
    }
}
