package org.bank.exceptions;

public class NotEnoughBalanceException extends RuntimeException {
    public NotEnoughBalanceException() {
        super("balance of the card is not enough! ");
    }
}
