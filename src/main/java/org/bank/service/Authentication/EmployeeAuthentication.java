package org.bank.service.Authentication;

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
