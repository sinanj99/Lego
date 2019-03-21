/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author sinanjasar
 */
public class Order {
    private int height;
    private int width;
    private int length;
    private String shipped;
    private int order_id;
    private int user_id;

    public Order(int order_id, int user_id, int height, int width, int length, String shipped) {
        this.height = height;
        this.width = width;
        this.length = length;
        this.shipped = shipped;
        this.user_id = user_id;
        this.order_id = order_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public int getUser_id() {
        return user_id;
    }


    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getShipped() {
        return shipped;
    }

    public void setShipped(String shipped) {
        this.shipped = shipped;
    }

    @Override
    public String toString() {
        return "Order{" + "height=" + height + ", width=" + width + ", length=" + length + ", shipped=" + shipped + ", order_id=" + order_id + ", user_id=" + user_id + '}';
    }
    
    
}
