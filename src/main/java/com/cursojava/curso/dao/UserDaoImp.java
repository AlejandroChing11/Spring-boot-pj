package com.cursojava.curso.dao;

import com.cursojava.curso.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
@Transactional
public class UserDaoImp implements UserDAO{

    @PersistenceContext
    EntityManager entityManager;


    @Override
    @Transactional
    public List<User> getUsers() {
        String query = "FROM User";
        return entityManager.createQuery(query).getResultList();

    }

    @Override
    public void eliminar(Long id) {
        User usuario = entityManager.find(User.class, id);
        entityManager.remove(usuario);
    }
}
