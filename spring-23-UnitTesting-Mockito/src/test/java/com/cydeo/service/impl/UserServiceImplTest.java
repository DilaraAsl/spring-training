package com.cydeo.service.impl;

import com.cydeo.mapper.UserMapper;
import com.cydeo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // tells mockito to create mocks using @Mock -JUnit5 --for JUnit 4 use Mock.init()
//Junit and mockito works well together if we are using them together
class UserServiceImplTest {
    @Mock
    UserRepository userRepository;

    @Mock
    UserMapper userMapper;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    void findByUserName_Test() {

        // calls the real method
        userService.findByUserName("harold@manager.com");

        // verify checks if the methods are executed or not
        verify(userRepository).findByUserNameAndIsDeleted("harold@manager.com",false);
        verify(userRepository,times(1)).findByUserNameAndIsDeleted("harold@manager.com",false);
        verify(userRepository,atLeastOnce()).findByUserNameAndIsDeleted("harold@manager.com",false);
        verify(userRepository,atLeast(1)).findByUserNameAndIsDeleted("harold@manager.com",false);
        verify(userRepository,atMostOnce()).findByUserNameAndIsDeleted("harold@manager.com",false);
        verify(userRepository,atMost(10)).findByUserNameAndIsDeleted("harold@manager.com",false);

        InOrder inOrder=inOrder(userRepository,userMapper); // inorder takes care of the order of method calls that the mock is going to make

        inOrder.verify(userRepository).findByUserNameAndIsDeleted("harold@manager.com",false);
        inOrder.verify(userMapper).convertToDto(null);

    }

}