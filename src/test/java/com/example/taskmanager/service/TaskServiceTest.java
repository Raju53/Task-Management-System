package com.example.taskmanager.service;

import com.example.taskmanager.exception.ResourceNotFoundException;
import com.example.taskmanager.dto.TaskRequest;
import com.example.taskmanager.dto.TaskResponse;
import com.example.taskmanager.entity.Task;
import com.example.taskmanager.entity.TaskStatus;
import com.example.taskmanager.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {

    @Mock
    private TaskRepository repository;

    @InjectMocks
    private TaskService taskService;

    private Task sampleTask;
    private TaskRequest sampleRequest;

    @BeforeEach
    void setUp() {
        sampleTask = new Task();
        sampleTask.setId(1L);
        sampleTask.setTitle("Test Task");
        sampleTask.setStatus(TaskStatus.PENDING);

        sampleRequest = new TaskRequest();
        sampleRequest.setTitle("Test Task");
        sampleRequest.setStatus(TaskStatus.PENDING);
    }

    @Test
    @DisplayName("Should successfully mark task as completed")
    void markAsComplete_Success() {
        // Arrange
        when(repository.findById(1L)).thenReturn(Optional.of(sampleTask));
        when(repository.save(any(Task.class))).thenReturn(sampleTask);

        // Act
        TaskResponse response = taskService.markAsComplete(1L);

        // Assert
        assertEquals(TaskStatus.COMPLETED, response.getStatus());
        verify(repository, times(1)).save(any(Task.class));
    }

    @Test
    @DisplayName("Should throw ResourceNotFoundException when task id does not exist")
    void markAsComplete_TaskNotFound() {
        // Arrange
        when(repository.findById(2L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> {
            taskService.markAsComplete(2L);
        });

        // Verify save was never called
        verify(repository, never()).save(any(Task.class));
    }

    @Test
    @DisplayName("Should successfully create a new task and return a response dto")
    void createTask_Success() {
        // Arrange
        when(repository.save(any(Task.class))).thenReturn(sampleTask);

        // Act
        TaskResponse response = taskService.createTask(sampleRequest);

        // Assert
        assertNotNull(response);
        assertEquals("Test Task", response.getTitle());
        verify(repository, times(1)).save(any(Task.class));
    }
}