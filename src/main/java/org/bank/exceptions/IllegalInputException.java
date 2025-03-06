package org.bank.exceptions;

public class IllegalInputException extends RuntimeException {
    public IllegalInputException() {
        super("wrong input type!");
    }
}
