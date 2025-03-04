package org.bank.service.fieldGenerator;

import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomStringUtils;
import org.bank.base.config.ApplicationContext;
import org.bank.entity.*;
import org.hibernate.Session;

import java.util.Random;

public class RandomGenerator {

    private final static Random random = new Random();

    public static String generateCustomerCode(Session session) {
        String generated;
        do
            generated = "11" + String.format("%08d", random.nextInt(100_000_000));
        while (ApplicationContext.getCustomerRepository().fieldIdCounter(
                session, Customer.class, Customer_.customerCode, generated) > 0);
        return generated;
    }

    public static String generateCustomerPassword(Session session) {
        return RandomStringUtils.random(10,true,true);
    }

    public static String generateAccountNumber(Session session) {
        String generated;
        do
            generated = "824" + RandomStringUtils.random(11, false, true);
        while (ApplicationContext.getAccountRepository().fieldIdCounter(
                session, Account.class, Account_.accountNumber, generated) > 0);
        return generated;
    }

    public static String generateAccountSheba(Session session) {
        String generated;
        do
            generated = "IR-" + RandomStringUtils.random(20, false, true);
        while (ApplicationContext.getAccountRepository().fieldIdCounter(
                session, Account.class, Account_.accountSheba, generated) > 0);
        return generated;
    }

    public static String generateCardNumber(Session session) {
        String generated;
        do
            generated = "6219" + RandomStringUtils.random(12, false, true);
        while (ApplicationContext.getAccountRepository().fieldIdCounter(
                session, CreditCard.class,CreditCard_.cardNumber, generated) > 0);
        return generated;
    }

    public static String generateCardCvv2(Session session) {
        return RandomStringUtils.random(3, false, true);
    }

    public static String generateCardFirstPass(Session session) {
        return RandomStringUtils.random(4, false, true);
    }

    public static String generateCardSecondPass(Session session) {
        return RandomStringUtils.random(6, false, true);
    }
}
