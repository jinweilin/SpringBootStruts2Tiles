package com.demo.struts.service;


import java.util.List;

import com.demo.struts.model.User;

public interface ServiceFacade {
    void putUsers();
    List<User> retrieveUsers();
}