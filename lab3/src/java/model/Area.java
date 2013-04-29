package model;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * General class of aplication
 *
 * @author fender
 */
public class Area {

    public static boolean shout(double r, double x, double y) {
        return lu(r, x, y) || ld(r, x, y) || ru(r, x, y) || rd(r, x, y);
    }

    private static boolean ru(double r, double x, double y) {
        return (x >= 0) & (y >= 0) & (Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(r/2, 2));
    }

    private static boolean ld(double r, double x, double y) {
        return (x <= 0) & (y <= 0) & (x >= -r/2) & (y >= -r / 2) & (r / 2 > y + x / 2);
    }

    private static boolean lu(double r, double x, double y) {
        return false;
    }

    private static boolean rd(double r, double x, double y) {
        return (x >= 0) && (y <= 0) & (x <= r / 2) & (y >= r);
    }
}
