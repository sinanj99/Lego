/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Logic.Facade;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sinanjasar
 */
public class ShipCommand extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.valueOf(request.getParameter("id"));
            
            if(Facade.getOrder(id).getShipped() != null)
            {
                request.getSession().setAttribute("result", "shipped");
                response.sendRedirect("ship.jsp");
            }
            else
            {
            String datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
            Facade.markShipped(id, datetime);
            request.getSession().setAttribute("result", "success");
            response.sendRedirect("ship.jsp");
            }
        } catch(NumberFormatException e)
        {
            System.out.println(e.getMessage());
            request.getSession().setAttribute("result", "fail");
            response.sendRedirect("ship.jsp");
        }
    }
    
}
