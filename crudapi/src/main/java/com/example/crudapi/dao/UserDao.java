package com.example.crudapi.dao;

import com.example.crudapi.models.UserModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDao implements IUserDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<UserModel> getAllUsers() {
        String query = "FROM UserModel";
        return entityManager.createQuery(query, UserModel.class).getResultList();

    }

    @Override
    public UserModel registerUser(UserModel userModel) {
        entityManager.persist(userModel);
        return userModel;
    }

    @Override
    public UserModel findAnUserById(Long id) {
        return entityManager.find(UserModel.class, id);
    }

    @Override
    public UserModel updateUser(UserModel userModel) {
        return entityManager.merge(userModel);
    }

    @Override
    public boolean deleteAnUserById(Long id) {
        UserModel userToDelete = entityManager.find(UserModel.class, id);
        if (userToDelete != null) {
           entityManager.remove(userToDelete);
           return true;
        } else return false;
    }

}
