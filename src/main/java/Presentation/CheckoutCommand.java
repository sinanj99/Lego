/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Data.Bricks;
import Data.Order;
import Data.ShoppingCart;
import Logic.ShopController;
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
public class CheckoutCommand extends Command {

    public CheckoutCommand() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ShoppingCart cart = (ShoppingCart)request.getSession().getAttribute("cart");
        List<Bricks> brickList = new ArrayList();
        for(Order order : cart.getOrders())
        {
         Bricks bricks = ShopController.calcBricks(order.getOrder_id());
         brickList.add(bricks);
         request.getSession().setAttribute("bricklist", brickList);
         response.sendRedirect("confirmation.jsp");
        }
    }
    
}
