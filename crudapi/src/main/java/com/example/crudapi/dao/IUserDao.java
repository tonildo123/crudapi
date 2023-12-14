package com.example.crudapi.dao;

import com.example.crudapi.dto.UserDTO;
import com.example.crudapi.models.UserModel;

import java.util.List;

public interface IUserDao {

    List<UserDTO> getAllUsers();

    UserModel registerUser(UserModel userModel);

    UserModel findAnUserById(Long id);

    UserModel updateUser(UserModel userModel);

    boolean deleteAnUserById(Long id);

    UserModel login(UserModel userModel);
}
