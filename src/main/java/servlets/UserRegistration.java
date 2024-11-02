package servlets;

import java.io.IOException;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.servlet.RequestDispatcher;


import model.User;
import model.userRole;
import util.HibernateUtil;

@WebServlet("/signup")  // Make sure this matches the action in the form
public class UserRegistration extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Step 1: Retrieve form data from the request
        String username = request.getParameter("userName");
        String password = request.getParameter("password");
        String roleStr = request.getParameter("role");

        // Step 2: Convert role to the appropriate enum type
        userRole role;
        try {
            role = userRole.valueOf(roleStr.toUpperCase());
        } catch (IllegalArgumentException | NullPointerException e) {
            response.getWriter().write("Invalid role selected.");
            return;
        }

        // Step 3: Create a new User instance and populate fields
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);

        // Step 4: Save the user in the database
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            response.getWriter().write("User registered successfully!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/signin.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            response.getWriter().write("User registration failed.");
        } finally {
            session.close();
        }
    }
}
