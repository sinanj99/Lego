/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Data.User;
import Logic.DuplicateException;
import Logic.RegisterController;
import Logic.Facade;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sinanjasar
 */
public class RegisterCommand extends Command {

    public RegisterCommand() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DuplicateException {
        Facade f = new Facade();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null) {
//            request.getRequestDispatcher("/CupCakesProject/index.jsp").forward(request, response);
            response.sendRedirect("/CupCakesProject/index.jsp");
        } else {
            
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if (!RegisterController.validatePassword(password)) {
                session.setAttribute("registerResult", "invalidPassword");
//                request.getRequestDispatcher("/LegoProject/register.jsp").forward(request, response);
                response.sendRedirect("/LegoProject/register.jsp");
                
            } else if (!RegisterController.validateUsername(username)) {
                session.setAttribute("registerResult", "invalidUsername");
//                request.getRequestDispatcher("/LegoProject/register.jsp").forward(request, response);
                response.sendRedirect("/LegoProject/register.jsp");
            } else {
                
                    f.insertUser(username, password);
//                    request.getRequestDispatcher("/LegoProject/login.jsp").forward(request, response);
                    response.sendRedirect("/LegoProject/login.jsp");
            }
        }
    }
}

