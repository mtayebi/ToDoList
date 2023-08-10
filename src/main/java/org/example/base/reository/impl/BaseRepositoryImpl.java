package org.example.base.reository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.example.base.entity.BaseEntity;
import org.example.base.reository.BaseRepository;

import java.io.Serializable;
import java.util.Collection;

public abstract class BaseRepositoryImpl<ID extends Serializable,T extends BaseEntity<ID>>
        implements BaseRepository<ID, T> {
    EntityManager entityManager;
    public BaseRepositoryImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    public void save(T entity) {
        entityManager.persist(entity);
    }

    @Override
    public void update(T entity) {
        entityManager.merge(entity);
    }

    @Override
    public T findById(ID id) {
        entityManager.find(getClassType(), id);
        return null;
    }

    @Override
    public Collection<T> findAll() {
        Query query = entityManager.createQuery(getAllEntityQuery());
        return query.getResultList();
    }

    public abstract String getAllEntityQuery();
    public abstract Class<T> getClassType();
}
