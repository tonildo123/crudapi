package com.example.crudapi.dao;

import com.example.crudapi.dto.UserDTO;
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
    public List<UserDTO> getAllUsers() {
        String query = "SELECT new com.example.crudapi.dto.UserDTO(u.id, u.email) FROM UserModel u";
        return entityManager.createQuery(query, UserDTO.class).getResultList();
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

    @Override
    public UserModel login(UserModel userModel) {
        String query = "SELECT u FROM UserModel u WHERE u.email = :email AND u.password = :password";
        List<UserModel> users = entityManager.createQuery(query, UserModel.class)
                .setParameter("email", userModel.getEmail())
                .setParameter("password", userModel.getPassword())
                .getResultList();

        return users.isEmpty() ? null : users.get(0);
    }

}
