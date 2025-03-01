package org.bank.base.config;

import org.bank.entity.CreditCard;
import org.bank.repository.CreditCardRepository;
import org.bank.repository.impl.CreditCardRepositoryImpl;
import org.bank.service.CreditCardService;
import org.bank.service.impl.CreditCardServiceImpl;

public class ApplicationContext {

    private static final Class<CreditCard> creditCardClass;
    private static final CreditCardRepository CREDIT_CARD_REPOSITORY;
    private static final CreditCardService CREDIT_CARD_SERVICE;

    static {
        creditCardClass = CreditCard.class;
        CREDIT_CARD_REPOSITORY = new CreditCardRepositoryImpl(creditCardClass);
        CREDIT_CARD_SERVICE = new CreditCardServiceImpl(CREDIT_CARD_REPOSITORY);
    }
    public static CreditCardService getCreditCardService() {return CREDIT_CARD_SERVICE; }
    public static CreditCardRepository getCreditCardRepository() {return CREDIT_CARD_REPOSITORY; }
}
