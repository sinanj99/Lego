/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Data.Bricks;
import Data.Order;
import Logic.Facade;
import Logic.ShopController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sinanjasar
 */
public class ShowOrderCommand extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("id"));
        Order order = Facade.getOrder(id);
        Bricks bricks = ShopController.calcBricks(id);
        request.getSession().setAttribute("order", order);
        request.getSession().setAttribute("bricks", bricks);
        response.sendRedirect("showorder.jsp");
    }

}
