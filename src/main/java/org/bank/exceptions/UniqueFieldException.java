package org.bank.exceptions;

public class UniqueFieldException extends RuntimeException {
    public UniqueFieldException(String fieldName) {
        super(fieldName + " already exists! ");
    }
}
