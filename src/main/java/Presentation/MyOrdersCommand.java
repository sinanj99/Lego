/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Data.Order;
import Data.User;
import Logic.Facade;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sinanjasar
 */
public class MyOrdersCommand extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Order> orders = new ArrayList();
        User user = (User) request.getSession().getAttribute("user");
        int id = user.getUser_id();
        if(Facade.getOrders(id) != null)
        {
        for (Order o : Facade.getOrders(id)) {
            orders.add(o);
        }
        }
        
        if (orders.get(0).getOrder_id() == 0 || orders.isEmpty() ) {
            request.getSession().setAttribute("result", "noorders");
            request.getRequestDispatcher("myorders.jsp").forward(request, response);
        } else {
            request.getSession().setAttribute("orders", orders);
            response.sendRedirect("myorders.jsp");
        }
    }

}
