package com.demo.struts.dao;

import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.struts.model.User;
 
public interface UserDAO {
    List<User> getUsers();
    void insertBatch();
}