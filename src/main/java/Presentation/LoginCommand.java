/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Data.User;
import Logic.Facade;
import Logic.LoginController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sinanjasar
 */
public class LoginCommand extends Command {

    public LoginCommand() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        User user = null;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(Facade.getUser(username));
        
            if(Facade.getUser(username).getUsername() == null
               || Facade.getUser(username).getUsername().isEmpty())
            {
                request.getSession().setAttribute("loginResult", "noUser");
//                request.getRequestDispatcher("login.jsp").forward(request, response);
                response.sendRedirect("login.jsp");
            }
            
            else if (LoginController.doesMatch(username, password)) {
                user = Facade.getUser(username);
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
//                request.getRequestDispatcher("/LegoProject/index.jsp").forward(request, response);
                response.sendRedirect("/LegoProject/index.jsp");
                
            } else if(!LoginController.doesMatch(username, password)){
                request.getSession().setAttribute("loginResult", "loginFailed");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        
    }

}
