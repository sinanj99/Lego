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
public class Bricks {
    private int four;
    private int two;
    private int one;
    private int fourSideL, fourSideW, twoSideL, twoSideW, oneSideL, oneSideW;

    public Bricks(int four, int two, int one, int fourSideL, int fourSideW, int twoSideL, int twoSideW, int oneSideL, int oneSideW) {
        this.four = four;
        this.two = two;
        this.one = one;
        this.fourSideL = fourSideL;
        this.fourSideW = fourSideW;
        this.twoSideL = twoSideL;
        this.twoSideW = twoSideW;
        this.oneSideL = oneSideL;
        this.oneSideW = oneSideW;
    }

    public int getFour() {
        return four;
    }

    public int getTwo() {
        return two;
    }

    public int getOne() {
        return one;
    }

    public int getFourSideL() {
        return fourSideL;
    }

    public int getFourSideW() {
        return fourSideW;
    }

    public int getTwoSideL() {
        return twoSideL;
    }

    public int getTwoSideW() {
        return twoSideW;
    }

    public int getOneSideL() {
        return oneSideL;
    }

    public int getOneSideW() {
        return oneSideW;
    }
    
}