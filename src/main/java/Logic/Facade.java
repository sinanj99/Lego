/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.IOrderMapper;
import Data.IUserMapper;
import Data.Order;
import Data.User;
import java.util.List;

/**
 *
 * @author sinanjasar
 */
public class Facade {

    private static final IUserMapper um = IUserMapper.instance();

    private static final IOrderMapper om = IOrderMapper.instance();

    public static User getUser(String username) {
        return um.getUser(username);
    }

    public static Order insertOrder(int user_id, int length, int height, int width) {
        return om.insertOrder(user_id, length, height, width);
    }

    public static void markShipped(int id, String datetime) {
        om.markShipped(id, datetime);
    }

    public static Order getOrder(int id) {
        return om.getOrder(id);
    }

    public static List<Order> getOrders() {
        return om.getOrders();
    }

    public static List<Order> getOrders(int id) {
        return om.getOrders(id);
    }

    public void insertUser(String username, String password) throws DuplicateException {
        um.insertUser(username, password, 0);
    }
}
