package org.bank.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.bank.base.config.ApplicationContext;
import org.bank.entity.Customer;
import org.bank.entity.Employee;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("customer/cardToCard")
public class CardToCardServlet extends HttpServlet {

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
        Customer loggedinCustomer = null;
        if (session != null)
            loggedinCustomer = (Customer) session.getAttribute("customer");
        else {
            req.setAttribute("error", "session time out!");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
        try {
            String sourceCardNumber = req.getParameter("sourceCardNumber");
            String destinationCardNumber = req.getParameter("destinationCardNumber");
            Long amount = Long.parseLong(req.getParameter("amount"));
            String secondPass = req.getParameter("secondPass");
            String cvv2 = req.getParameter("cvv2");
            LocalDate expiryDate = LocalDate.parse(req.getParameter("expiryDate"));
            Long customerId = loggedinCustomer.getId();

            resp.setStatus(200);
            ApplicationContext.getCreditCardService().cardToCard(
                    customerId, sourceCardNumber, destinationCardNumber,
                    amount, secondPass, cvv2, expiryDate
            );
            req.setAttribute("message", "card to card was successful");
            req.getRequestDispatcher("/customer-panel.jsp").forward(req, resp);
        } catch (RuntimeException e) {
            resp.setStatus(400);
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("/card-to-card.jsp").forward(req, resp);
        } catch (Exception e) {
            resp.setStatus(500);
            req.setAttribute("error", "An unexpected error occurred. Please try again.");
            req.getRequestDispatcher("/card-to-card.jsp").forward(req, resp);
        }
    }
}
