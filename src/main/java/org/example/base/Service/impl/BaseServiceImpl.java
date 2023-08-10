package org.example.base.Service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.base.Service.BaseService;
import org.example.base.entity.BaseEntity;
import org.example.base.reository.BaseRepository;
import org.example.config.AppEntityManagerFactory;

import java.io.Serializable;
import java.util.Collection;

public class BaseServiceImpl<ID extends Serializable, T extends BaseEntity<ID>,
        R extends BaseRepository<ID,T>> implements BaseService<ID, T> {
    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    protected final R entityRepository;

    {
        entityManagerFactory = AppEntityManagerFactory.getEMF();
        entityManager = entityManagerFactory.createEntityManager();
    }
    BaseServiceImpl(R entityRepository){
        this.entityRepository = entityRepository;
    }

    @Override
    public void save(T entity) {
        entityManager.getTransaction().begin();
        entityRepository.save(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(T entity) {

    }

    @Override
    public T findById(ID id) {
        return null;
    }

    @Override
    public Collection<T> findAll() {
        return null;
    }
}
