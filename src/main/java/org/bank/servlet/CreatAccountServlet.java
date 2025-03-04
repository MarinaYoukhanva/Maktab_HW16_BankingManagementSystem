package org.bank.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.bank.base.config.ApplicationContext;
import org.bank.entity.Account;
import org.bank.entity.Customer;
import org.bank.entity.Employee;
import org.bank.entity.dto.CreatedAccountInfoDto;
import org.bank.entity.enums.AccountType;

import java.io.IOException;

@WebServlet("/employee/createAccount")
public class CreatAccountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp
    ) throws ServletException, IOException {
        req.getRequestDispatcher("/create-new-account.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp
    ) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        Employee loggedinEmployee = null;
        if (session != null)
            loggedinEmployee = (Employee) session.getAttribute("employee");
        else {
            req.setAttribute("error", "session time out!");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
        try {
            String firstName = req.getParameter("firstname");
            String lastName = req.getParameter("lastname");
            String nationalCode = req.getParameter("nationalCode");
            String phoneNumber = req.getParameter("phoneNumber");
            AccountType accountType = AccountType.valueOf(req.getParameter("accountType"));
            Long bankBranchId = loggedinEmployee.getBankBranch().getId();
            Long balance = Long.valueOf(req.getParameter("balance"));

            Customer.CustomerDto customerDto = new Customer.CustomerDto(
                    firstName, lastName, nationalCode, phoneNumber);
            Account.AccountDto accountDto = new Account.AccountDto(
                    accountType, bankBranchId, balance);

            resp.setStatus(200);
            CreatedAccountInfoDto created = ApplicationContext.getAccountService().createBankAccount(
                    customerDto, accountDto);
            req.setAttribute("created", created);
            req.setAttribute("message", "new account created successfully");
            req.getRequestDispatcher("/created-account.jsp").forward(req, resp);
        } catch (RuntimeException e) {
            resp.setStatus(400);
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("/create-new-account.jsp").forward(req, resp);
        } catch (Exception e) {
            resp.setStatus(500);
            req.setAttribute("error", "An unexpected error occurred. Please try again.");
            req.getRequestDispatcher("/create-new-account.jsp").forward(req, resp);
        }


    }
}
