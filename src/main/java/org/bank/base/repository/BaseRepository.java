package org.bank.base.repository;

import jakarta.persistence.metamodel.SingularAttribute;
import org.bank.base.model.BaseEntity;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BaseRepository <ID extends Serializable,T extends BaseEntity<ID>> {

     T save(Session session, T entity);
     List<T> findAll(Session session);
     Optional<T> findById(Session session, ID id);
     int delete(Session session, ID id);
     Long fieldIdCounter(Session session, Class<?> entityClass, SingularAttribute<?, ?> field, Object value);

     Optional<T> findEntityByUniqueField (Session session, Class<T> entityClass, SingularAttribute<?, ?> field, Object value);
}
