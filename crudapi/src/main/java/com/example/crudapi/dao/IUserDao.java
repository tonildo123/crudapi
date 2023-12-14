package com.example.crudapi.dao;

import com.example.crudapi.models.UserModel;

import java.util.List;

public interface IUserDao {

    List<UserModel> getAllUsers();

    UserModel registerUser(UserModel userModel);

    UserModel findAnUserById(Long id);

    UserModel updateUser(UserModel userModel);

    boolean deleteAnUserById(Long id);
}
