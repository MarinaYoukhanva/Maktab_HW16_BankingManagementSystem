package org.bank.exceptions;

public class WrongInputInfoException extends RuntimeException {
    public WrongInputInfoException() {
        super("input information is incorrect! ");
    }
}
