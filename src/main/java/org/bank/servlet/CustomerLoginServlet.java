package org.bank.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.bank.base.config.ApplicationContext;
import org.bank.entity.Customer;

import java.io.IOException;

@WebServlet("/customer/login")
public class CustomerLoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp
    ) throws ServletException, IOException {
        req.getRequestDispatcher("/customer-login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp
    ) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        try{
            resp.setStatus(200);
            Customer customer = ApplicationContext
                    .getCustomerService().login(username, password);
            req.setAttribute("message", "logged in successfully");
//            req.setAttribute("customer", customer);
//            req.getRequestDispatcher("/test.jsp").forward(req, resp);
        } catch (RuntimeException e) {
            resp.setStatus(400);
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("/customer-login.jsp").forward(req, resp);
        } catch (Exception e) {
            resp.setStatus(500);
            req.setAttribute("error", "An unexpected error occurred. Please try again.");
            req.getRequestDispatcher("//customer-login.jsp").forward(req, resp);
        }

    }
}
