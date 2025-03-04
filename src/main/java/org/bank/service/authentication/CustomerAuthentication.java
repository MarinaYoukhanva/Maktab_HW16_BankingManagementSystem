package org.bank.service.authentication;

import lombok.Getter;
import lombok.Setter;
import org.bank.entity.Customer;

public class CustomerAuthentication {

    @Getter
    @Setter
    private static Customer loggedInCustomer;

    public static void logout(){
        loggedInCustomer = null;
    }

}
