package com.bms.management.system.service;

import com.bms.management.system.model.User;

public interface UserServiceI {
    User createUser(String userName,String password);
    User getUserById(Long id);
}
