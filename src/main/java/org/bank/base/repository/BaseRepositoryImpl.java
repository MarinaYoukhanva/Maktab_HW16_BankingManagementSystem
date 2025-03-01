package org.bank.base.repository;

import jakarta.persistence.metamodel.SingularAttribute;
import lombok.RequiredArgsConstructor;
import org.bank.base.model.BaseEntity;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public abstract class BaseRepositoryImpl<ID extends Serializable, T extends BaseEntity<ID>>
        implements BaseRepository<ID, T> {

    private final Class<T> entityClass;

    @Override
    public T save(Session session, T entity) {
        session.persist(entity);
        return entity;
    }

    @Override
    public List<T> findAll(Session session) {
        return session.createQuery("from " + entityClass.getName(), entityClass)
                .list();
    }

    @Override
    public Optional<T> findById(Session session, ID id) {
        return session.byId(entityClass)
                .loadOptional(id);
    }

    @Override
    public int delete(Session session, ID id) {
        return session
                .createMutationQuery("DELETE FROM " + entityClass.getName() + " e WHERE e.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public Long fieldIdCounter(Session session, Class<?> entityClass, SingularAttribute<?, ?> field, Object value) {
        String query = "SELECT COUNT(id) FROM "
                + entityClass.getSimpleName() +
                " WHERE " + field.getName() + " = :value";
        return session
                .createQuery(query, Long.class)
                .setParameter("value", value)
                .getSingleResult();
    }
//    @Override
//    public Long fieldIdCounter(Session session, Class<?> entityClass, SingularAttribute<?, ?> field, Object value) {
//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery<Long> query = builder.createQuery(Long.class);
//        Root<?> root = query.from(entityClass);
//
//        query.select(builder.count(root.get("id")))
//                .where(builder.equal(root.get(field.getName()), value));
//
//        return session.createQuery(query).getSingleResult();
//    }
}
