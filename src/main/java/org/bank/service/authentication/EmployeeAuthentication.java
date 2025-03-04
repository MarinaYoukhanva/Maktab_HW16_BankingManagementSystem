package org.bank.service.authentication;

import lombok.Getter;
import lombok.Setter;
import org.bank.entity.Employee;

public class EmployeeAuthentication {

    @Setter
    @Getter
    private static Employee loggedInEmployee;

    public static void logout(){
        loggedInEmployee = null;
    }

}
