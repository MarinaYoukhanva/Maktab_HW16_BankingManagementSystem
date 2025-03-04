package org.bank.base.service;

import org.bank.base.model.BaseEntity;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BaseService <ID extends Serializable,T extends BaseEntity<ID>> {

    T singleEntitySave(T entity);

    T multipleEntitySave(Session session, T entity);

    T update(T entity);
    List<T> findAll();
    Optional<T> findById(ID id);
    void delete(ID id);
    void updateColumns(T entity, T foundEntity);


}
