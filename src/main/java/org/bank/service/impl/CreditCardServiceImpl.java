package org.bank.service.impl;

import org.bank.base.service.BaseServiceImpl;
import org.bank.entity.CreditCard;
import org.bank.entity.CreditCard_;
import org.bank.repository.CreditCardRepository;
import org.bank.service.CreditCardService;
import org.bank.service.fieldGenerator.RandomGenerator;
import org.bank.validations.UniqueFieldCheckable;
import org.bank.validations.UniquenessValidator;
import org.hibernate.Session;

public class CreditCardServiceImpl extends BaseServiceImpl<Long, CreditCard, CreditCardRepository>
        implements CreditCardService, UniqueFieldCheckable<CreditCard> {


    public CreditCardServiceImpl(CreditCardRepository repository) {
        super(repository);
    }

    @Override
    public void updateColumns(CreditCard entity, CreditCard foundEntity) {

    }

    @Override
    public void checkUniqueFields(Session session, CreditCard entity) {
        UniquenessValidator.checkUniqueFieldOrThrowException(getRepository(),
                session, CreditCard.class, CreditCard_.firstPass, entity.getFirstPass());
    }

    @Override
    public CreditCard create(Session session){
        CreditCard card = new CreditCard();
        card.setCardNumber(RandomGenerator.generateCardNumber(session));
        card.setCvv2(RandomGenerator.generateCardCvv2(session));
        card.setFirstPass(RandomGenerator.generateCardFirstPass(session));
        card.setSecondPass(RandomGenerator.generateCardSecondPass(session));
        card.setAccount(null);
        card.setExpiryDate(null);
        return card;
    }

}
