package org.example.service.impl;

import jakarta.persistence.EntityManager;
import org.example.base.Service.impl.BaseServiceImpl;
import org.example.base.reository.BaseRepository;
import org.example.base.reository.impl.BaseRepositoryImpl;
import org.example.entity.Task;
import org.example.service.TaskService;

public class TaskServiceImpl extends BaseServiceImpl<Long, Task, BaseRepository<Long, Task>> implements TaskService {
    public TaskServiceImpl(BaseRepository repository, EntityManager entityManager){

        super(repository, entityManager);
    }
}
