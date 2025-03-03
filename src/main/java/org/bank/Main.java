package org.bank;

import org.bank.base.config.ApplicationContext;
import org.bank.base.config.SessionFactoryInstance;
import org.bank.entity.CreditCard;
import org.bank.entity.CreditCard_;
import org.bank.entity.Customer;
import org.bank.repository.CreditCardRepository;
import org.bank.service.CreditCardService;
import org.hibernate.Session;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        CreditCardService creditCardService = ApplicationContext.getCreditCardService();
        CreditCardRepository creditCardRepository = ApplicationContext.getCreditCardRepository();

        ApplicationContext.getCustomerService();
        ApplicationContext.getEmployeeService();

        try(Session session = SessionFactoryInstance.sessionFactory.openSession()){

            try {
                creditCardService.save(new CreditCard("12345678", "666",
                        LocalDate.of(2024,1,12),
                        "5511", "2222"));
            }catch (Exception e){
                System.out.println(e.getMessage());
            }

//            Long count = creditCardRepository.fieldIdCounter(
//                    session,
//                    CreditCard.class,
//                    CreditCard_.firstPass,
//                    "1111"
//            );
//            System.out.println(count);
        }
    }
}
