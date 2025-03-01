package org.bank.validations;

import org.hibernate.Session;

public interface UniqueFieldCheckable<T> {
    void checkUniqueFields(Session session, T entity);
}
