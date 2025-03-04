package org.bank.base.config;

import org.bank.entity.*;
import org.bank.repository.*;
import org.bank.repository.impl.*;
import org.bank.service.*;
import org.bank.service.impl.*;

public class ApplicationContext {

    private static final Class<CreditCard> creditCardClass;
    private static final CreditCardRepository CREDIT_CARD_REPOSITORY;
    private static final CreditCardService CREDIT_CARD_SERVICE;

    private static final Class<Customer> customerClass;
    private static final CustomerRepository CUSTOMER_REPOSITORY;
    private static final CustomerService CUSTOMER_SERVICE;

    private static final Class<Employee> employeeClass;
    private static final EmployeeRepository EMPLOYEE_REPOSITORY;
    private static final EmployeeService EMPLOYEE_SERVICE;

    private static final Class<Account> accountClass;
    private static final AccountRepository ACCOUNT_REPOSITORY;
    private static final AccountService ACCOUNT_SERVICE;

    private static final Class<BankBranch> bankBranchClass;
    private static final BankBranchRepository BANK_BRANCH_REPOSITORY;
    private static final BankBranchService BANK_BRANCH_SERVICE;

    static {
        creditCardClass = CreditCard.class;
        CREDIT_CARD_REPOSITORY = new CreditCardRepositoryImpl(creditCardClass);
        CREDIT_CARD_SERVICE = new CreditCardServiceImpl(CREDIT_CARD_REPOSITORY);

        customerClass = Customer.class;
        CUSTOMER_REPOSITORY = new CustomerRepositoryImpl(customerClass);
        CUSTOMER_SERVICE = new CustomerServiceImpl(CUSTOMER_REPOSITORY);

        employeeClass = Employee.class;
        EMPLOYEE_REPOSITORY = new EmployeeRepositoryImpl(employeeClass);
        EMPLOYEE_SERVICE = new EmployeeServiceImpl(EMPLOYEE_REPOSITORY);

        accountClass = Account.class;
        ACCOUNT_REPOSITORY = new AccountRepositoryImpl(accountClass);
        ACCOUNT_SERVICE = new AccountServiceImpl(ACCOUNT_REPOSITORY);

        bankBranchClass = BankBranch.class;
        BANK_BRANCH_REPOSITORY = new BankBranchRepositoryImpl(bankBranchClass);
        BANK_BRANCH_SERVICE = new BankBranchServiceImpl(BANK_BRANCH_REPOSITORY);
    }
    public static CreditCardService getCreditCardService() {return CREDIT_CARD_SERVICE; }
    public static CreditCardRepository getCreditCardRepository() {return CREDIT_CARD_REPOSITORY; }

    public static CustomerService getCustomerService() {return CUSTOMER_SERVICE; }
    public static CustomerRepository getCustomerRepository() {return CUSTOMER_REPOSITORY; }

    public static EmployeeService getEmployeeService() {return EMPLOYEE_SERVICE; }
    public static EmployeeRepository getEmployeeRepository() {return EMPLOYEE_REPOSITORY; }

    public static AccountService getAccountService() {return ACCOUNT_SERVICE; }
    public static AccountRepository getAccountRepository() {return ACCOUNT_REPOSITORY; }

    public static BankBranchService getBankBranchService() {return BANK_BRANCH_SERVICE; }
    public static BankBranchRepository getBankBranchRepository() {return BANK_BRANCH_REPOSITORY;}
}
