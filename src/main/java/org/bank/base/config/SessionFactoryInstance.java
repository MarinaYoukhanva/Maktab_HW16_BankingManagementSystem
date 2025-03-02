package org.bank.base.config;

import org.bank.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryInstance {

    public static SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(CreditCard.class)
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
    }

}
