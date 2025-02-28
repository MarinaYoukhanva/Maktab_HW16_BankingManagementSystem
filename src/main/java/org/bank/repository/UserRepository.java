package org.bank.repository;

import org.bank.base.repository.BaseRepository;
import org.bank.entity.User;

public interface UserRepository<T extends User> extends BaseRepository<Long, T> {
}
