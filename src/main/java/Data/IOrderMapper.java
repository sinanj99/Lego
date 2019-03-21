/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.List;

/**
 *
 * @author sinanjasar
 */
public abstract class IOrderMapper {
    
    public static IOrderMapper instance() {
        return OrderMapper.getInstance();
    }
    /**
     * Inserts Order to dB and returns the order.
     * @param user_id
     * @param length
     * @param height
     * @param width
     * @return  
     */
    
    public abstract Order insertOrder(int user_id, int length, int height, int width);
    /**
     * Marks order with given as shipped
     * @param id
     * @param datetime
     */
    public abstract void markShipped(int id, String datetime);
    
    /**
     * Returns an order object from the dB specified by the parameter 'id'.
     * @param id
     * @return 
     */
    public abstract Order getOrder(int id);
    
    /**
     * Returns a list of all order objects in dB.
     * @return 
     */
    public abstract List<Order> getOrders();
    
    /**
     * Returns a list of all orders in dB with specified id.
     * @param id
     * @return 
     */
    public abstract List<Order> getOrders(int id);
    
    
}
