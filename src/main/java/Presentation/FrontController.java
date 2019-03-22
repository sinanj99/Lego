/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Logic.DuplicateException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sinanjasar
 */
@WebServlet(name = "FrontController", urlPatterns = {"/FrontController/*"})
public class FrontController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Command c = Command.from(request);

            c.execute(request, response);

        } catch (IOException e1) {
            
        } catch (ServletException e2) {

        } catch (DuplicateException e3) {
            System.out.println(e3.getMessage());
            request.getSession().setAttribute("registerResult", "duplicate");
            response.sendRedirect("/LegoProject/register.jsp");
        } catch(CommandException e4)
        {
            request.getSession().setAttribute("error", e4.getMessage());
            response.sendRedirect("error.jsp");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
