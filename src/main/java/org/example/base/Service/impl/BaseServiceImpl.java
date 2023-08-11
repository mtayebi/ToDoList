package org.example.base.Service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.base.Service.BaseService;
import org.example.base.entity.BaseEntity;
import org.example.base.reository.BaseRepository;
import org.example.config.AppEntityManagerFactory;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class BaseServiceImpl<ID extends Serializable, T extends BaseEntity<ID>,
        R extends BaseRepository<ID,T>> implements BaseService<ID, T> {
    EntityManager entityManager;
    protected final R entityRepository;

    public BaseServiceImpl(R entityRepository, EntityManager entityManager){
        this.entityRepository = entityRepository;
        this.entityManager = entityManager;
    }

    @Override
    public void save(T entity) {
        entityManager.getTransaction().begin();
        entityRepository.save(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(T entity) {
        entityManager.getTransaction().begin();
        entityRepository.update(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public T findById(ID id) {
        entityManager.getTransaction().begin();
        T entity = entityRepository.findById(id);
        entityManager.getTransaction().commit();
        return entity;
    }

    @Override
    public Collection<T> findAll() {
        entityManager.getTransaction().begin();
        List<T> entities = (List<T>) entityRepository.findAll();
        entityManager.getTransaction().commit();
        return entities;
    }
}
