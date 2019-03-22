/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Data.Order;
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
public class OrdersCommand extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Order> orders = new ArrayList();

        for (Order o : Facade.getOrders()) {
            orders.add(o);
        }
        if (orders == null || orders.isEmpty() || orders.get(0).getOrder_id() == 0) {
            request.getSession().setAttribute("result", "noorders");
            request.getRequestDispatcher("myorders.jsp").forward(request, response);
        } else {
            request.getSession().setAttribute("orders", orders);
            response.sendRedirect("orders.jsp");
        }
    }

}
