/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.Bricks;
import Data.Order;

/**
 *
 * @author sinanjasar
 */
public class ShopController {

    public static Bricks calcBricks(int id) {

        Order order = Facade.getOrder(id);
        
        int four = 0;
        int two = 0;
        int one = 0;

        int fourSideL = 0;
        int fourSideW = 0;
        int twoSideL = 0;
        int twoSideW = 0;
        int oneSideL = 0;
        int oneSideW = 0;

        int length = order.getLength();
        int width = order.getWidth();
        int height = order.getHeight();
        System.out.println("length: " + length);
        System.out.println("height: " + height);
        System.out.println("width: " + width);

        for (int i = 1; i <= height; i++) {

            if (i % 2 == 1) {
                width = width - 4;
                System.out.println("new width: " + width);
            } else {
                length = length - 4;
                System.out.println("new length: " +  length);
            }
            
            int _four = (length / 4) * 2 + (width / 4) * 2; System.out.println("all fours" + _four);
            fourSideL = length / 4;
            fourSideW = width / 4;
            int _two = ((length % 4) / 2) * 2 + ((width % 4) / 2) * 2; System.out.println("all twos " + _two);
            twoSideL = ((length % 4) / 2);
            twoSideW = ((width % 4) / 2);
            int _one = ((length % 4) % 2) * 2 + ((width % 4) % 2) * 2;
            oneSideL = ((length % 4) % 2);
            oneSideW = ((width % 4) % 2);

            four += _four;
            two += _two;
            one += _one;
        }
        Bricks bricks = new Bricks(four, two, one, fourSideL, fourSideW, twoSideL, twoSideW, oneSideL, oneSideW);
        return bricks;
    }

    public static void main(String[] args) {
        System.out.println(calcBricks(6).getFour());
    }
}
