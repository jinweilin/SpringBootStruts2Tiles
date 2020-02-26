package com.demo.struts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.demo.struts.dao.UserDAO;
import com.demo.struts.model.User;

import java.util.List;

@Service("userService")
public class UserService implements ServiceFacade {
     
    @Autowired
    private UserDAO userDAO;

    @Override
    public void putUsers() {
        userDAO.insertBatch();
    }

    @Override
    public List<User> retrieveUsers() {
        return userDAO.getUsers();
    }

}