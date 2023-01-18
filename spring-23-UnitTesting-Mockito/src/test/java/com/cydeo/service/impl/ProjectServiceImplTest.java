package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.entity.Project;
import com.cydeo.mapper.ProjectMapper;
import com.cydeo.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProjectServiceImplTest {
    @Mock
    ProjectRepository projectRepository;

    @Mock
    ProjectMapper projectMapper;

    @InjectMocks
    ProjectServiceImpl projectService;
//stubbing methods will have fake implementation
    // the methods that I am stubbing will have fake implementations
    //stubbing when() thenReturn() thenThrow
    // defining the fake behavior of your fake obj
    @Test
    void getProjectCode_Test(){
        // given

        //when findByProjectCode is called return something
        when(projectRepository.findByProjectCode(anyString())).thenReturn(new Project());

        //
        when(projectMapper.convertToDto(any(Project.class))).thenReturn(new ProjectDTO());

        // when
        ProjectDTO projectDTO=projectService.getByProjectCode(anyString());

        // then
        InOrder inOrder=inOrder(projectRepository, projectMapper);

        inOrder.verify(projectRepository).findByProjectCode(anyString());
        inOrder.verify(projectMapper).convertToDto(any(Project.class));

        assertNotNull(projectDTO); // test will pass if the object is not null


    }

    @Test
    void getProjectByCode_ExceptionTest(){
        when(projectRepository.findByProjectCode("")).thenThrow(new NoSuchElementException("Project Not Found"));

        Throwable throwable=assertThrows(NoSuchElementException.class,()->projectService.getByProjectCode(""));

        verify(projectRepository).findByProjectCode("");
        verify(projectMapper,never()).convertToDto(any(Project.class)); // if there is an exception thrown
        // this should not run
        assertEquals("Project Not Found", throwable.getMessage());
        // checking if correct exception is thrown by checking the message
    }




}