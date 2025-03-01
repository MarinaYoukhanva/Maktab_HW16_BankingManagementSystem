package org.bank.base.service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ValidationException;
import lombok.Getter;
import org.bank.base.config.SessionFactoryInstance;
import org.bank.base.model.BaseEntity;
import org.bank.base.repository.BaseRepository;
import org.bank.exceptions.NotFoundException;
import org.bank.validations.HibernateValidator;
import org.bank.validations.UniqueFieldCheckable;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Getter
public abstract class BaseServiceImpl<ID extends Serializable, T extends BaseEntity<ID>,
        R extends BaseRepository<ID, T>> implements BaseService<ID, T> {

    private final R repository;
    HibernateValidator<ID, T> hibernateValidator = new HibernateValidator<>();

    public BaseServiceImpl(R repository) {
        this.repository = repository;
    }


    @Override
    public T save(T entity) {
        Set<ConstraintViolation<T>> violations = hibernateValidator.validate(entity);
        if (!violations.isEmpty())
            throw new ValidationException(String.valueOf(violations));
        try (var session = SessionFactoryInstance.sessionFactory.openSession()) {

            if (this instanceof UniqueFieldCheckable)
                ((UniqueFieldCheckable<T>) this).checkUniqueFields(session, entity);

            try {
                session.beginTransaction();
                repository.save(session, entity);
                session.getTransaction().commit();
                return entity;
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

//    @Override
//    public T save(T entity) {
//        Set<ConstraintViolation<T>> violations = validation.checkValidations(entity);
//        if (!violations.isEmpty()) {
//            throw new ValidationException(String.valueOf(violations));
//        }
//        return sessionManager.executeWithinTransaction(session -> {
//            infoLogicCheck(session, entity);
//            repository.save(session, entity);
//            return entity;
//        });
//    }


    @Override
    public T update(T entity) {
        Set<ConstraintViolation<T>> violations = hibernateValidator.validate(entity);
        if (!violations.isEmpty())
            throw new ValidationException(String.valueOf(violations));
        try (var session = SessionFactoryInstance.sessionFactory.openSession()) {

            if (this instanceof UniqueFieldCheckable)
                ((UniqueFieldCheckable<T>) this).checkUniqueFields(session, entity);
            try {
                session.beginTransaction();
                var foundEntity = repository.findById(session, entity.getId())
                        .orElseThrow(() -> new NotFoundException());
                updateColumns(entity, foundEntity);
                repository.save(session, foundEntity);
                session.getTransaction().commit();
                return foundEntity;
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    @Override
    public List<T> findAll() {
        try (var session = SessionFactoryInstance.sessionFactory.openSession()) {
            try {
                session.beginTransaction();
                var result = repository.findAll(session);
                session.getTransaction().commit();
                return result;
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    @Override
    public Optional<T> findById(ID id) {
        try (var session = SessionFactoryInstance.sessionFactory.openSession()) {
            try {
                session.beginTransaction();
                var result = repository.findById(session, id);
                session.getTransaction().commit();
                return result;
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    @Override
    public void delete(ID id) {
        try (var session = SessionFactoryInstance.sessionFactory.openSession()) {
            try {
                session.beginTransaction();
                var affectedRows = repository.delete(session, id);
                if (affectedRows == 0)
                    throw new NotFoundException();
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    public abstract void updateColumns(T entity, T foundEntity);

}

