package com.cydeo.service.impl;

import com.cydeo.dto.TaskDTO;
import com.cydeo.entity.Task;
import com.cydeo.mapper.TaskMapper;
import com.cydeo.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;


import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;
// Mocking is the process of simulating the external dependencies of the code that is being tested.
// Simulation can be fake data or fake interaction
// we are just testing a method that depends on different things such db
// mock interaction with the db
@ExtendWith(MockitoExtension.class)
class TaskServiceImplTest {
    @Mock
    TaskRepository taskRepository;
    @Mock
    TaskMapper taskMapper;

    @InjectMocks
    TaskServiceImpl taskService;

    @ParameterizedTest
    @ValueSource(longs={1L,2L,3L})
    void findById_Test(long id){

        // given - preparation -context- prepare the mock interaction
        Task task=new Task();
        when(taskRepository.findById(id)).thenReturn(Optional.of(task)); // Optional<Task> task may be null or not
        when(taskMapper.convertToDto(task)).thenReturn(new TaskDTO());

        // when - action
        taskService.findById(id); // this is the method that we are testing

        // then -assertion and verification
        verify(taskService).findById(id);
        verify(taskMapper).convertToDto(task);
    }

    @Test
    void findById_BDD_Test(){ // behavior driven development

        // given
        Task task=new Task();
        given(taskRepository.findById(anyLong())).willReturn(Optional.of(task));
        given(taskMapper.convertToDto(task)).willReturn(new TaskDTO());

        // when
        taskService.findById(anyLong());

        //then
        then(taskRepository).should().findById(anyLong());
        then(taskMapper).should(atLeastOnce()).convertToDto(task);
    }


}