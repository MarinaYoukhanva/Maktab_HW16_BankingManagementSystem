package org.bank.service.impl;

import org.bank.base.config.SessionFactoryInstance;
import org.bank.base.service.BaseServiceImpl;
import org.bank.entity.CreditCard;
import org.bank.entity.CreditCard_;
import org.bank.entity.Customer;
import org.bank.exceptions.NotEnoughBalanceException;
import org.bank.exceptions.NotFoundException;
import org.bank.exceptions.OwnException;
import org.bank.exceptions.WrongInputInfoException;
import org.bank.repository.CreditCardRepository;
import org.bank.service.CreditCardService;
import org.bank.service.fieldGenerator.RandomGenerator;
import org.bank.validations.UniqueFieldCheckable;
import org.bank.validations.UniquenessValidator;
import org.hibernate.Session;

import java.time.LocalDate;
import java.util.List;

public class CreditCardServiceImpl extends BaseServiceImpl<Long, CreditCard, CreditCardRepository>
        implements CreditCardService, UniqueFieldCheckable<CreditCard> {


    public CreditCardServiceImpl(CreditCardRepository repository) {
        super(repository);
    }

    @Override
    public void updateColumns(CreditCard entity, CreditCard foundEntity) {
        foundEntity.setCardNumber(entity.getCardNumber());
        foundEntity.setCvv2(entity.getCvv2());
        foundEntity.setExpiryDate(entity.getExpiryDate());
        foundEntity.setFirstPass(entity.getFirstPass());
        foundEntity.setSecondPass(entity.getSecondPass());
    }

    @Override
    public void checkUniqueFields(Session session, CreditCard entity) {
        UniquenessValidator.checkUniqueFieldOrThrowException(getRepository(),
                session, CreditCard.class, CreditCard_.cardNumber, entity.getCardNumber());
    }

    @Override
    public CreditCard create(Session session) {
        CreditCard card = new CreditCard();
        card.setCardNumber(RandomGenerator.generateCardNumber(session));
        card.setCvv2(RandomGenerator.generateCardCvv2(session));
        card.setFirstPass(RandomGenerator.generateCardFirstPass(session));
        card.setSecondPass(RandomGenerator.generateCardSecondPass(session));
        card.setAccount(null);
        card.setExpiryDate(null);
        return card;
    }

    @Override
    public void cardToCard(Long customerId, String sourceCardNumber,
                           String destinationCardNumber, Long amount,
                           String secondPass, String cvv2, LocalDate expiryDate) {
        try (Session session = SessionFactoryInstance.sessionFactory.openSession()) {
            CreditCard sourceCard = getRepository()
                    .findEntityByUniqueField(session, CreditCard.class,
                            CreditCard_.cardNumber, sourceCardNumber)
                    .orElseThrow(() -> new NotFoundException(CreditCard.class));

            if (!sourceCard.getAccount().getOwner().getId().equals(customerId))
                throw new OwnException(Customer.class, CreditCard.class);

            CreditCard destinationCard = getRepository()
                    .findEntityByUniqueField(session, CreditCard.class,
                            CreditCard_.cardNumber, destinationCardNumber)
                    .orElseThrow(() -> new NotFoundException(CreditCard.class));

            if (!sourceCard.getSecondPass().equals(secondPass)
                    || !sourceCard.getCvv2().equals(cvv2)
                    || !sourceCard.getExpiryDate().toLocalDate().equals(expiryDate))
                throw new WrongInputInfoException();

            if (sourceCard.getAccount().getBalance() < (5600 + amount))
                throw new NotEnoughBalanceException();
            try {
                session.beginTransaction();

                sourceCard.getAccount().setBalance(
                        sourceCard.getAccount().getBalance() - (amount + 600)
                );
                destinationCard.getAccount().setBalance(
                        destinationCard.getAccount().getBalance() + amount
                );
                getRepository().save(session, sourceCard);
                getRepository().save(session, destinationCard);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    @Override
    public List<String> findCustomerCards(Long customerId) {
        try(Session session = SessionFactoryInstance.sessionFactory.openSession()){
            return getRepository().findCustomerCards(session, customerId);
        }
    }
}
