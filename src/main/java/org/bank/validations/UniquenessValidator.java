package org.bank.validations;

import jakarta.persistence.metamodel.SingularAttribute;
import org.bank.base.model.BaseEntity;
import org.bank.base.repository.BaseRepository;
import org.bank.exceptions.UniqueFieldException;
import org.hibernate.Session;

import java.io.Serializable;

public class UniquenessValidator {

    public static <ID extends Serializable, T extends BaseEntity<ID>> void checkUniqueField(
            BaseRepository<ID, T> repository, Session session,
            Class<?> entityClass, SingularAttribute<?, ?> field, Object value) {
        Long fieldCount = repository.fieldIdCounter(session,entityClass, field, value);
        if (fieldCount != null && fieldCount > 0)
            throw new UniqueFieldException(field.getName());
    }
}
