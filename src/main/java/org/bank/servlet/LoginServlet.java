package org.bank.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.bank.base.config.ApplicationContext;
import org.bank.entity.Customer;
import org.bank.entity.Employee;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp
    ) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp
    ) throws ServletException, IOException {
        String userType = req.getParameter("userType");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        try {
            resp.setStatus(200);
            if (userType.equals("customer")) {
                Customer customer = ApplicationContext
                        .getCustomerService().login(username, password);
                req.setAttribute("customer", customer);
                req.getRequestDispatcher("/test.jsp").forward(req, resp);
                req.setAttribute("message", "logged in successfully");

            } else if (userType.equals("employee")) {
                Employee employee = ApplicationContext
                        .getEmployeeService().login(username, password);
                req.setAttribute("employee", employee);
                req.setAttribute("message", "logged in successfully");
                req.getRequestDispatcher("/employee-panel.jsp").forward(req, resp);

            } else {
                resp.setStatus(400);
                throw new Exception("Invalid userType!");
            }

        } catch (RuntimeException e) {
            resp.setStatus(400);
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        } catch (Exception e) {
            resp.setStatus(500);
            req.setAttribute("error", "An unexpected error occurred. Please try again.");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }

    }
}
