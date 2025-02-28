package org.bank.repository.impl;

import org.bank.base.repository.BaseRepositoryImpl;
import org.bank.entity.User;
import org.bank.repository.UserRepository;

public abstract class UserRepositoryImpl<T extends User> extends BaseRepositoryImpl<Long, T>
        implements UserRepository<T> {
    public UserRepositoryImpl(Class<T> entityClass) {
        super(entityClass);}}
