package org.bank.service.impl;

import org.bank.base.service.BaseServiceImpl;
import org.bank.entity.CreditCard;
import org.bank.entity.CreditCard_;
import org.bank.repository.CreditCardRepository;
import org.bank.service.CreditCardService;
import org.bank.validations.UniqueFieldCheckable;
import org.bank.validations.UniquenessValidator;
import org.hibernate.Session;

public class CreditCardServiceImpl extends BaseServiceImpl<Long, CreditCard, CreditCardRepository>
        implements CreditCardService, UniqueFieldCheckable<CreditCard> {


    public CreditCardServiceImpl(CreditCardRepository repository
    ) {
        super(repository);
    }

    @Override
    public void updateColumns(CreditCard entity, CreditCard foundEntity) {

    }

    @Override
    public void checkUniqueFields(Session session, CreditCard entity) {
        UniquenessValidator.checkUniqueField(getRepository(),
                session, CreditCard.class, CreditCard_.firstPass, entity.getFirstPass());
    }
}
