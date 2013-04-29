/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;

/**
 * information about one shot. Can return to String html format
 *
 * @author fender
 */
public class Result {

    /**
     * Colors of shut
     */
    static final Color color1 = Color.YELLOW, color2 = Color.GREEN;
    /**
     * save x y
     */
    private double x, y, r;
    /**
     * if false, - miss :-(
     */
    private boolean miss;

    public Result(double r, double x, double y, boolean miss) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.miss = miss;
    }

    @Override
    public String toString() {
        return "<td>" + r + "</td><td>" + x + "</td><td>" + y + "</td><td>" + miss + "</td>";
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Color getColor() {
        return miss ? color1 : color2;
    }
}
