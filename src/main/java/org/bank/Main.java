package org.bank;

import org.apache.commons.lang3.RandomStringUtils;
import org.bank.base.config.ApplicationContext;
import org.bank.base.config.SessionFactoryInstance;
import org.bank.entity.Account;
import org.bank.entity.BankBranch;
import org.bank.entity.CreditCard;
import org.bank.entity.Customer;
import org.bank.entity.enums.AccountType;
import org.bank.repository.CreditCardRepository;
import org.bank.service.CreditCardService;
import org.bank.service.CustomerService;
import org.bank.service.fieldGenerator.RandomGenerator;
import org.hibernate.Session;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

//        ApplicationContext.getCustomerService()
//                .changeSecondPassword(2L,"6219821163410401","000000","000001");

//        System.out.println(ApplicationContext.getCustomerService().findById(2L));
//        ApplicationContext.getCustomerService().findById(2L)
//        try {
//            ApplicationContext.getCreditCardService().cardToCard(2L,
//                "6219038135923286","6219832412541856",
//                100L, "281139", "690", LocalDate.of(2030, 3, 4)
//        );
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

//
//        Customer customer = ApplicationContext.getAccountService().createBankAccount(
//                new Customer.CustomerDto("mari", "u", "123", "0937"),
//                new Account.AccountDto(AccountType.BOLAND_MODAT, 1L, 300L)
//        );

//        System.out.println(customer.getId());
//        System.out.println(ApplicationContext.getAccountService().findById(1L).get().getCreditCard());

//        CreditCardService creditCardService = ApplicationContext.getCreditCardService();
//        CreditCardRepository creditCardRepository = ApplicationContext.getCreditCardRepository();
//
//        CustomerService customerService = ApplicationContext.getCustomerService();
//        ApplicationContext.getEmployeeService();

//        customerService.findAll().forEach(System.out::println);
//        Customer customer = customerService.findById(1L).get();
//
//        try(Session session = SessionFactoryInstance.sessionFactory.openSession()){
//            ApplicationContext.getCreditCardRepository().findCustomerCards(session,1L)
//                    .forEach(System.out::println);
//        }
//            String a = RandomGenerator.generateAccountNumber(session);
//            System.out.println(a);


//            Customer customer = ApplicationContext.getCustomerRepository()
//                    .customerWithAccounts(session,"111");
//            System.out.println(customer);
//            System.out.println("--------------------------");
//            ApplicationContext.getAccountRepository().customerAccounts(session,"111")
//                    .forEach(System.out::println);
//
//            try {
//                ApplicationContext.getCreditCardService().singleEntitySave(
//                        new CreditCard("6219038135923286", "666",
//                                LocalDateTime.now(),
//                        "5511", "223322", null));
//            }catch (Exception e){
//                System.out.println(e.getMessage());
//            }

//            Long count = creditCardRepository.fieldIdCounter(
//                    session,
//                    CreditCard.class,
//                    CreditCard_.firstPass,
//                    "1111"
//            );
//            System.out.println(count);
//        }
    }
}
