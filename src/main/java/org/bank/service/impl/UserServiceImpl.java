package org.bank.service.impl;

import org.bank.base.repository.BaseRepository;
import org.bank.base.service.BaseServiceImpl;
import org.bank.entity.User;
import org.bank.repository.UserRepository;
import org.bank.service.UserService;
import org.hibernate.Session;

public abstract class UserServiceImpl<T extends User, R extends UserRepository<T>>
        extends BaseServiceImpl<Long, T, R>
        implements UserService<T> {
    public UserServiceImpl(R repository) {
        super(repository);}}
