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
public class House {
    private Bricks bricks; 
    
    private int lengthFour;
    private int widthFour;

    private int lengthTwo;
    private int widthTwo;
    private int lengthOne;
    private int widthOne;

    public House(Bricks bricks, int lengthFour, int widthFour, int lengthTwo, int widthTwo, int lengthOne, int widthOne) {
        this.bricks = bricks;
        this.lengthFour = lengthFour;
        this.widthFour = widthFour;
        this.lengthTwo = lengthTwo;
        this.widthTwo = widthTwo;
        this.lengthOne = lengthOne;
        this.widthOne = widthOne;
    }

    public Bricks getBricks() {
        return bricks;
    }

    public int getLengthFour() {
        return lengthFour;
    }

    public int getWidthFour() {
        return widthFour;
    }

    public int getLengthTwo() {
        return lengthTwo;
    }

    public int getWidthTwo() {
        return widthTwo;
    }

    public int getLengthOne() {
        return lengthOne;
    }

    public int getWidthOne() {
        return widthOne;
    }
    
    
    
}
