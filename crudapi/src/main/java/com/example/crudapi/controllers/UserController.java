package com.example.crudapi.controllers;

import com.example.crudapi.dao.IUserDao;
import com.example.crudapi.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private IUserDao iUserDao;

    @RequestMapping(value = "api/users", method = RequestMethod.GET)
    public List<UserModel> getUsers(){

        return iUserDao.getAllUsers();
    } // trae todos los usuarios de la DB

    @RequestMapping(value = "api/users/{id}", method = RequestMethod.GET)
    public UserModel getAnUserById(@PathVariable Long id){
        return iUserDao.findAnUserById(id);
    } // trae un usuario por ID de la DB

    @RequestMapping(value = "api/users/register", method = RequestMethod.POST)
    public UserModel registerUser(@RequestBody UserModel userModel){
        return iUserDao.registerUser(userModel);
    } // registra un user

    @RequestMapping(value = "api/users/update", method = RequestMethod.PUT)
    public UserModel updateUSer(@RequestBody UserModel userModel){
        return iUserDao.updateUser(userModel);
    } // actualiza un user

    @RequestMapping(value = "api/users/delete/{id}", method = RequestMethod.DELETE)
    public boolean deleteById(@PathVariable Long id){
        return iUserDao.deleteAnUserById(id);
    } // elimina un usuario por ID de la DB

}
