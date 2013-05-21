/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.imageio.ImageIO;

import model.Area;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author root
 */
@ManagedBean(name = "bean")
@SessionScoped
public class BeanArea implements Serializable {

    private double x = 0, y = 0, r = 1;
    private boolean imageBaseDraw = false;
    private String result, resultJS;
    private StreamedContent image;
    private BufferedImage bi = new BufferedImage(256, 256, BufferedImage.TYPE_INT_RGB);
    private Graphics2D g2 = bi.createGraphics();
    /**
     * Result - its information about one shot
     */
    private ArrayList<Result> results = new ArrayList<Result>();

    public void add() {

        results.add(
                new Result(r, x, y, // new Result object
                Area.shout(r, x, y)// shot
                ));
        //add to result
        result = results.get(results.size() - 1).toString();

    }

    public void clear() {
        makeImage(g2,bi);
        results.clear();
    }

    //setters and getters
    public void setX(double value) {
        this.x = value;
    }

    public void setY(double value) {
        this.y = value;
    }

    public void setR(double value) {
        this.r = value;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    /**
     *
     * @return last result in html
     */
    public String getResult() {
        return this.result;
    }

    public String getResults() {
        String tmp = "";
        resultJS = "";
        for (int i = results.size() - 1; i >= 0; i--) {
            tmp += "<tr>" + results.get(i).toString() + "</tr>";
            //  resultJS += "drawPoint(" + r + "," + results.get(i).getX() + "," + results.get(i).getY() + "," + results.get(i).getColor() + ");\n";
            // resultJS+="alert(hu);";
        }
        return tmp;
    }

    /**
     * generate jscode
     *
     * @return
     */
    public String getPointsJS() {
        return resultJS;
    }

    public int getLenth() {
        return results.size();
    }

    public StreamedContent getImage() {
        try {

            if (!this.imageBaseDraw) {
                makeImage(g2, bi);
                imageBaseDraw = true;
            }

            makePoints(g2, bi);

            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(bi, "png", os);
            image = new DefaultStreamedContent(new ByteArrayInputStream(os.toByteArray()),
                    "image/png");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }

    private void makePoints(Graphics2D g2, BufferedImage bi) {

        if (results.size() > 0) {
            Result i = results.get(results.size() - 1);
            g2.setColor(i.getColor());
            g2.fillOval((int) (i.getX() * bi.getHeight() * 0.4 / r + bi.getHeight() / 2),
                    (int) (bi.getHeight()/2-i.getY() * bi.getHeight() * 0.4 / r),
                  5, 5);
        }

    }

    private void makeImage(Graphics2D g2, BufferedImage bi) {
        //Graphic Text  

       
        g2.setColor(Color.BLUE);
        //rd
        g2.fillRect(bi.getHeight() / 2, bi.getHeight() / 2, (int) ((int) bi.getHeight() * 0.4), (int) ((int) bi.getHeight() * 0.4));
        //ru
        g2.fillOval(bi.getHeight() / 2 - (int) ((int) bi.getHeight() * 0.4),
                bi.getHeight() / 2 - (int) ((int) bi.getHeight() * 0.4),
                (int) ((int) bi.getHeight() * 0.8),
                (int) ((int) bi.getHeight() * 0.8));


        //lu
        g2.setColor(Color.BLACK);
        g2.fillRect(bi.getHeight() / 2 - (int) ((int) bi.getHeight() * 0.4),
                bi.getHeight() / 2 - (int) ((int) bi.getHeight() * 0.4),
                (int) ((int) bi.getHeight() * 0.4),
                (int) ((int) bi.getHeight() * 0.8));

        //ld
        g2.setColor(Color.BLUE);
        g2.fillPolygon(
                new int[]{(int) ((int) bi.getHeight() * 0.3), //x
            (int) ((int) bi.getHeight() / 2),
            (int) ((int) bi.getHeight() / 2)},
                new int[]{(int) ((int) bi.getHeight() / 2), //y
            (int) ((int) bi.getHeight() / 2),
            (int) ((int) bi.getHeight() / 1.5)},
                3);


        //LINES
        g2.setColor(Color.red);
        //g2.drawString("This is a text", 0, 10);  
        //oy
        g2.drawLine(bi.getHeight() / 2, 0, bi.getHeight() / 2, bi.getHeight());
        //ox
        g2.drawLine(0, bi.getHeight() / 2, bi.getWidth(), bi.getHeight() / 2);

        //r
        g2.drawString("R", (int) bi.getHeight() / 2 + 10, (int) ((int) bi.getHeight() * 0.1)); //ru y 
        g2.drawString("-R", (int) ((int) bi.getHeight() * 0.1), (int) bi.getHeight() / 2); //rd x 
        g2.drawString("-R", (int) bi.getHeight() / 2 + 10, (int) ((int) bi.getHeight() * 0.9));//ld y 
        g2.drawString("R", (int) ((int) bi.getHeight() * 0.9), (int) bi.getHeight() / 2);  //lu x

        //r/2
        g2.drawString("R/2", (int) bi.getHeight() / 2 + 10, (int) ((int) bi.getHeight() * 0.3)); //ru y 
        g2.drawString("-R/2", (int) ((int) bi.getHeight() * 0.3), (int) bi.getHeight() / 2); //rd x 
        g2.drawString("-R/2", (int) bi.getHeight() / 2 + 10, (int) ((int) bi.getHeight() * 0.7));//ld y 
        g2.drawString("R/2", (int) ((int) bi.getHeight() * 0.7), (int) bi.getHeight() / 2);  //lu x

 
    }
}
