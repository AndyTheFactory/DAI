package coreservlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/** Servlet that reads a customer ID and displays
 *  information on the account balance of the customer
 *  who has that ID.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on servlets, JSP, Struts, JSF, Ajax, GWT, 
 *  Spring, Hibernate/JPA, and Java programming</a>.
 */

public class ShowBalance extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    BankCustomer currentCustomer =
      BankCustomerLookup.getCustomer(request.getParameter("id"));
    request.setAttribute("customer", currentCustomer);
    String address;
    if (currentCustomer == null) {
      address = "/WEB-INF/bank-account/UnknownCustomer.jsp";
    } else if (currentCustomer.getBalance() < 0) {
      address = "/WEB-INF/bank-account/NegativeBalance.jsp";
    } else if (currentCustomer.getBalance() < 10000) {
      address = "/WEB-INF/bank-account/NormalBalance.jsp";
    } else {
      address = "/WEB-INF/bank-account/HighBalance.jsp";
    }
    RequestDispatcher dispatcher =
      request.getRequestDispatcher(address);
    dispatcher.forward(request, response);
  }
}
