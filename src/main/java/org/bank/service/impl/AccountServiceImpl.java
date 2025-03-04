package org.bank.service.impl;

import org.bank.base.config.ApplicationContext;
import org.bank.base.config.SessionFactoryInstance;
import org.bank.base.service.BaseServiceImpl;
import org.bank.entity.Account;
import org.bank.entity.BankBranch;
import org.bank.entity.CreditCard;
import org.bank.entity.Customer;
import org.bank.entity.dto.CreatedAccountInfoDto;
import org.bank.exceptions.NotFoundException;
import org.bank.repository.AccountRepository;
import org.bank.service.AccountService;
import org.bank.service.fieldGenerator.RandomGenerator;
import org.hibernate.Session;

import java.time.LocalDateTime;

public class AccountServiceImpl extends BaseServiceImpl<Long, Account, AccountRepository>
        implements AccountService {
    public AccountServiceImpl(AccountRepository repository) {
        super(repository);
    }

    @Override
    public void updateColumns(Account entity, Account foundEntity) {

    }

    @Override
    public Account create(Session session, Account.AccountDto dto) {
        Account account = new Account();
        account.setAccountType(dto.accountType());
        account.setBankBranch(
                ApplicationContext.getBankBranchService().findById(dto.bankBranchId())
                        .orElseThrow(() -> new NotFoundException(BankBranch.class)));
        account.setBalance(dto.balance());
        account.setAccountNumber(RandomGenerator.generateAccountNumber(session));
        account.setAccountSheba(RandomGenerator.generateAccountSheba(session));
        account.setCreatedAt(LocalDateTime.now());
        account.setOwner(null);
        account.setCreditCard(null);
        return account;
    }

    @Override
    public CreatedAccountInfoDto createBankAccount(
            Customer.CustomerDto customerDto,
            Account.AccountDto accountDto) {
        try (Session session = SessionFactoryInstance.sessionFactory.openSession()) {
            try {
                session.beginTransaction();
                Customer customer = ApplicationContext.getCustomerRepository()
                        .findByNationalCode(
                                session, customerDto.nationalCode()
                        ).orElseGet(() -> ApplicationContext.getCustomerService()
                                .create(session, customerDto));
                Account account = create(session, accountDto);
                CreditCard creditCard = ApplicationContext.getCreditCardService().create(session);

                customer.getAccounts().add(account);
                account.setOwner(customer);
//            account.setCreditCard(creditCard);
                creditCard.setAccount(account);
                creditCard.setExpiryDate(account.getCreatedAt().plusYears(5));

                ApplicationContext.getCustomerService().multipleEntitySave(session, customer);
                multipleEntitySave(session, account);
                ApplicationContext.getCreditCardService().multipleEntitySave(session, creditCard);

                session.getTransaction().commit();
                return new CreatedAccountInfoDto(
                        customer.getId(), customer.getFirstName(), customer.getLastName(),
                        customer.getUsername(), customer.getPassword(),
                        customer.getCustomerCode(), customer.getNationalCode(),
                        customer.getPhoneNumber(),
                        account.getId(), account.getAccountNumber(), account.getAccountSheba(),
                        account.getBalance(), account.getAccountType(), account.getCreatedAt(),
                        creditCard.getId(), creditCard.getCardNumber(), creditCard.getCvv2(),
                        creditCard.getExpiryDate(), creditCard.getFirstPass(), creditCard.getSecondPass()
                );
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }
}
