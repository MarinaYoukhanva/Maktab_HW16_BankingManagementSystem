package org.bank.service;

import org.bank.base.service.BaseService;
import org.bank.entity.User;

public interface UserService<T extends User> extends BaseService<Long, T> { }
