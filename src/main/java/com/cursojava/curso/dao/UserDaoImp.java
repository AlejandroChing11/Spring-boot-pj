package com.cursojava.curso.dao;

import com.cursojava.curso.models.User;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
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

    @Override
    public void register(User usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public boolean verificarCredenciales(User usuario) {
        String query = "FROM User WHERE email = :email";
        List<User> lista = entityManager.createQuery(query)
            .setParameter("email", usuario.getEmail())
                .getResultList();


        if (lista.isEmpty()){
            return false;
        }

        String passwordHashed = lista.get(0).getPassword();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        return argon2.verify(passwordHashed, usuario.getPassword());


    }

}
