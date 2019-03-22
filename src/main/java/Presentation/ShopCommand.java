/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Data.Bricks;
import Data.Order;
import Data.User;
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
public class ShopCommand extends Command {

    public ShopCommand() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
        int height = Integer.valueOf(request.getParameter("height"));
        int length = Integer.valueOf(request.getParameter("length"));
        int width = Integer.valueOf(request.getParameter("width"));
        User user = (User) request.getSession().getAttribute("user");
        int id = user.getUser_id();
        Order o = Facade.insertOrder(id, length, height, width);
        Bricks bricks = ShopController.calcBricks(id);
        request.getSession().setAttribute("order", o);
        request.getSession().setAttribute("bricks", bricks);
        
//        ShoppingCart sc = new ShoppingCart();
//        List<Order> cart = sc.getOrders();
        
//        if(request.getSession().getAttribute("cart") == null)
//        {
//            request.getSession().setAttribute("cart", cart);
//            cart.add(o);
//        }
//        else
//        {
//            cart.add(o);
//            request.getSession().setAttribute("cart", cart);
//        }

        response.sendRedirect("confirmation.jsp");
        }
        catch(NumberFormatException e)
        {
            System.out.println(e.getMessage());
            request.getSession().setAttribute("result", "fail");
            response.sendRedirect("shop.jsp");
        }
    }
    
}
