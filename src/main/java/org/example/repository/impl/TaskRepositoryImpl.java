package org.example.repository.impl;

import jakarta.persistence.EntityManager;
import org.example.base.reository.impl.BaseRepositoryImpl;
import org.example.entity.Task;
import org.example.repository.TaskRepository;

public class TaskRepositoryImpl extends BaseRepositoryImpl<Long, Task> implements TaskRepository {
    public TaskRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public String getAllEntityQuery() {
        return "from Task";
    }

    @Override
    public Class<Task> getClassType() {
        return Task.class;
    }
}
