package org.bank.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.bank.base.config.ApplicationContext;
import org.bank.entity.Account;

import java.io.IOException;
import java.util.List;

@WebServlet("/employee/viewAccounts")
public class ViewAccountsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp
    ) throws ServletException, IOException {
        String customerCode = req.getParameter("customerCode");
        try {
            resp.setStatus(200);
            List<Account> accounts = ApplicationContext
                    .getAccountService().viewCustomerAccounts(customerCode);
            req.setAttribute("accounts", accounts);
            req.setAttribute("message", "accounts of customer with code " + customerCode);
            req.getRequestDispatcher("/view-accounts.jsp").forward(req, resp);
        } catch (RuntimeException e) {
            resp.setStatus(400);
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("/employee-panel.jsp").forward(req, resp);
        } catch (Exception e) {
            resp.setStatus(500);
            req.setAttribute("error", "An unexpected error occurred. Please try again.");
            req.getRequestDispatcher("/employee-panel.jsp").forward(req, resp);
        }
    }

}

