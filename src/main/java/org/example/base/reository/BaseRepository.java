package org.example.base.reository;

import org.example.base.entity.BaseEntity;

import java.io.Serializable;
import java.util.Collection;

public interface BaseRepository <ID extends Serializable, T extends BaseEntity<ID>>{
    void save(T entity);
    void update(T entity);
    T findById(ID id);
    Collection<T> findAll();
}
