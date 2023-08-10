package org.example.repository.impl;

import jakarta.persistence.EntityManager;
import org.example.base.reository.impl.BaseRepositoryImpl;
import org.example.entity.User;
import org.example.repository.UserRepository;


public class UserRepositoryImpl extends BaseRepositoryImpl<Long, User> implements UserRepository {

    public UserRepositoryImpl(EntityManager entityManager){
        super(entityManager);
    }
    public String getAllEntityQuery(){
           return "from User";
    }
    public Class<User> getClassType(){
        return User.class;
    }
}
