package org.bank.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.bank.base.config.ApplicationContext;
import org.bank.entity.CreditCard;
import org.bank.entity.Customer;

import java.io.IOException;
import java.util.List;

@WebServlet("/customer/changePass")
public class ChangePassServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp
    ) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        Customer loggedinCustomer = null;
        if (session != null)
            loggedinCustomer = (Customer) session.getAttribute("customer");
        else {
            req.setAttribute("error", "session time out!");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
        List<String> cardNumbers = ApplicationContext
                .getCreditCardService().findCustomerCards(loggedinCustomer.getId());
        req.setAttribute("cardNumbers", cardNumbers);
        req.getRequestDispatcher("/change-password.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req,
                         HttpServletResponse resp
    ) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        Customer loggedinCustomer = null;
        if (session != null)
            loggedinCustomer = (Customer) session.getAttribute("customer");
        else {
            req.setAttribute("error", "session time out!");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
        try{
            resp.setStatus(200);
            String cardNumber = req.getParameter("cardNum");
            String oldPass = req.getParameter("oldPass");
            String newPass = req.getParameter("newPass");
            String passType = req.getParameter("passType");
            if (passType.equals("firstPass")) {
                ApplicationContext.getCustomerService().changeFirstPassword(
                        loggedinCustomer.getId(), cardNumber, oldPass, newPass
                );
            }
            else if (passType.equals("secondPass")) {
                ApplicationContext.getCustomerService().changeSecondPassword(
                        loggedinCustomer.getId(), cardNumber, oldPass, newPass
                );
            }
            req.setAttribute("message", "password changed successfully");
            req.getRequestDispatcher("/customer-panel.jsp").forward(req, resp);
        }catch (RuntimeException e) {
            resp.setStatus(400);
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("/change-password.jsp").forward(req, resp);
        } catch (Exception e) {
            resp.setStatus(500);
            req.setAttribute("error", "An unexpected error occurred. Please try again.");
            req.getRequestDispatcher("/change-password.jsp").forward(req, resp);
        }

    }
}
