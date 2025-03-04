package org.bank.exceptions;

import org.bank.base.model.BaseEntity;

public class OwnException extends RuntimeException {
    public OwnException(Class<? extends BaseEntity<Long>> firstEntity,
                        Class<? extends BaseEntity<Long>> secondEntity) {
        super(firstEntity.getSimpleName() + " does not have this " + secondEntity.getSimpleName());
    }
}
