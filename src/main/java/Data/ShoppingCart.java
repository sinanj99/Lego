/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sinanjasar
 */
public class ShoppingCart {
    List<Order> orders = new ArrayList();

    public List<Order> getOrders() {
        return orders;
    }    
}
