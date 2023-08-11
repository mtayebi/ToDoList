package org.example.service.impl;

import jakarta.persistence.EntityManager;
import org.example.base.Service.impl.BaseServiceImpl;
import org.example.base.reository.BaseRepository;
import org.example.entity.User;
import org.example.service.UserService;



public class UserServiceImpl extends
        BaseServiceImpl<Long, User, BaseRepository<Long, User>>
        implements UserService {
    public UserServiceImpl(BaseRepository<Long, User> repository, EntityManager entityManager) {

        super(repository, entityManager);
    }

}
