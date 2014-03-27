/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.infonal.service.interfaces;

import com.infonal.model.User;
import java.util.List;

/**
 *
 * @author abc
 */
public interface UserServiceInt {
    String COLLECTION_NAME = "";

    void addUser(User user);

    void deleteUser(User user);

    void deleteUserById(String userId);

    List<User> listUser();

    void updateUser(User user);

    void updateUserById(String userId);
    
}
