package org.example;

import jakarta.persistence.EntityManager;
import org.example.config.AppEntityManagerFactory;
import org.example.entity.Task;
import org.example.entity.User;
import org.example.entity.enumeration.Status;
import org.example.repository.UserRepository;
import org.example.repository.impl.TaskRepositoryImpl;
import org.example.repository.impl.UserRepositoryImpl;
import org.example.service.TaskService;
import org.example.service.UserService;
import org.example.service.impl.TaskServiceImpl;
import org.example.service.impl.UserServiceImpl;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        User user = new User();
        user.setUsername("ali");
        user.setPassword("12345");

        Task task = new Task();
        task.setUser(user);
        task.setTitle("important task");
        task.setStatus(Status.IN_PROGRESS);

        Task task1 = new Task();
        task1.setUser(user);
        task1.setTitle("another important task");
        task1.setStatus(Status.OPEN);

        EntityManager entityManager = AppEntityManagerFactory.getEMF().createEntityManager();

        UserRepository userRepository = new UserRepositoryImpl(entityManager);
        UserService userService = new UserServiceImpl(userRepository, entityManager);

        TaskRepositoryImpl taskRepository = new TaskRepositoryImpl(entityManager);
        TaskService taskService = new TaskServiceImpl(taskRepository, entityManager);

        userService.save(user);


        taskService.save(task);
        taskService.save(task1);

    }
}