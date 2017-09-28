package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Sean Jeske
 */
@WebServlet(name = "LogingServlet", urlPatterns = {"/LogingServlet"})
public class LoginServlet extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
        String userName = request.getParameter("username");
        String Password = request.getParameter("password");
        if(userName == null || userName.isEmpty()
                || Password == null || Password.isEmpty()){
             request.setAttribute("errormessage", "You must enter a username and password.");
             getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").
                forward(request, response);
             return;
        }
         String username = request.getParameter("username");
        String password = request.getParameter("password");
            UserServices UserServices = new UserServices();
            UserServices.setUsername(username);
            UserServices.setPassword(password);
   
        if(UserServices.getUsername().equals("") || UserServices.getPassword().equals("")){
            request.setAttribute("errormessage", "Username or password is incorrect.");
        request.setAttribute("username", UserServices.getUsername());
             request.setAttribute("password",  UserServices.getPassword());
              getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").
                forward(request, response);
              
        } else if (UserServices.getUsername().equalsIgnoreCase("sean") || UserServices.getUsername().equalsIgnoreCase("adam") 
                && UserServices.getPassword().equalsIgnoreCase("password")){
        request.setAttribute("username", userName);
         getServletContext().getRequestDispatcher("/WEB-INF/mainPage.jsp").
                forward(request, response);
    }
    }
}