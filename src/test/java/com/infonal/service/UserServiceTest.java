/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.infonal.service;

import com.infonal.model.User;
import com.infonal.service.interfaces.UserServiceInt;

import java.util.List;
import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author abc
 */


public class UserServiceTest extends TestCase {
    
    public UserServiceTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

       /**
     * Test of addUser method, of class UserServiceInt.
     */
    public void testAddUser() {
        System.out.println("addUser");
        User user = new User();
        user.setId("1");
        user.setName("1");
        user.setPhoneNumber("1");
        user.setSurname("1");
        
        userService.deleteAllUsers();
        userService.addUser(user);
        User userToTest=userService.listUser().get(0);
        
        assertEquals("1", userToTest.getId());
         assertEquals("1", userToTest.getName());
          assertEquals("1", userToTest.getPhoneNumber());
           assertEquals("1", userToTest.getSurname());
        
    }
    
        /**
     * Test of listUser method, of class UserServiceInt.
     */
    public void testListUser() {
        System.out.println("listUser");
        
        User user = new User();
        user.setId("1");
        user.setName("1");
        user.setPhoneNumber("1");
        user.setSurname("1");
        
        
        List<User> result = userService.listUser();
        assertEquals(1, result.size());
        
        User userToTest=result.get(0);
         assertEquals("1", userToTest.getId());
         assertEquals("1", userToTest.getName());
          assertEquals("1", userToTest.getPhoneNumber());
           assertEquals("1", userToTest.getSurname());
        
    }

    /**
     * Test of updateUser method, of class UserServiceInt.
     */
    public void testUpdateUser() {
        System.out.println("updateUser");
        
       
        User user = userService.listUser().get(0);
        user.setId("2");
        userService.updateUser(user);
        User updatedUser=userService.listUser().get(0);
        assertEquals("2", updatedUser.getId());
    }

    /**
     * Test of deleteUser method, of class UserServiceInt.
     */
    public void testDeleteUser() {
        System.out.println("deleteUser");
         
        
       User user= userService.listUser().get(0);
        userService.deleteUser(user);
     int mustBeZero=   userService.listUser().size();
        assertEquals(0, mustBeZero);
        
    }
    
    @Autowired(required = true)
    private UserServiceInt userService;
    
}
