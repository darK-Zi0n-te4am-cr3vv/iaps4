
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class GraphPanel extends JPanel implements Runnable {

    private static int W, H, Z = 100;
    private static double rad = 1, x, y;
    private static int stage = 0, delay = 100;
    int initsize = 2,size=initsize;
    Thread runner;

    public GraphPanel() {
        super();

        setBackground(Color.gray);
        if (runner == null);
        {
            runner = new Thread(this);
            runner.start();

        }
    }

    @Override
    public void run() {
        while (true) {
            repaint();
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
            }
        }
    }

    private static int Convert_X(double x) {
        return (int) (W * 0.5 + x * Z);
    }

    private static int Convert_Y(double y) {
        return (int) (H * 0.5 - y * Z);
    }

    public static double ReConvert_X(int x) {
        return (double) ((x - W * 0.5) / Z);
    }

    public static double ReConvert_Y(int y) {
        return (double) ((H * 0.5 - y) / Z);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        W = getSize().width;
        H = getSize().height;

        PrintPolygons(g);
        PrintSector(g);
        PrintPlot(g);

        if (Checking.LastState) {
            g.setColor(Color.green);
        } else {
            g.setColor(Color.red);
        }

        if (stage < 4) {
            
            stage++;
            size+=initsize;
        } else {
            
            size-=initsize;
            stage++;

        }

        g.drawOval(Convert_X(x) - size/2 , Convert_Y(y) - size/2 ,size , size);
        if(stage==3)
        {
            delay = 200;
        }
            
        if (stage == 7) {
            stage = 0;
            size = initsize;
            delay=100;
        }
    }

    private void PrintPlot(Graphics g) {
        g.setColor(Color.black);

        g.drawLine(0, H / 2, W, H / 2);
        g.drawLine(W / 2, 0, W / 2, H);

        for (int i = 1; i <= H / Z / 2; i++) {
            g.drawLine(
                    W / 2 - 2,
                    Convert_Y(0) + Z * i,
                    W / 2 + 2,
                    Convert_Y(0) + Z * i);
            g.drawLine(
                    W / 2 - 2, 
                    Convert_Y(0) - Z * i,
                    W / 2 + 2, 
                    Convert_Y(0) - Z * i);
        }

        for (int i = 1; i <= W / Z / 2; i++) {
            g.drawLine(Convert_X(0) + Z * i,
                    H / 2 - 2,
                    Convert_X(0) + Z * i,
                    H / 2 + 2);
            g.drawLine(Convert_X(0) - Z * i,
                    H / 2 - 2,
                    Convert_X(0) - Z * i,
                    H / 2 + 2);
        }
    }

    private void PrintPolygons(Graphics g) {
        g.setColor(Color.blue);

        int xPoints[] = {Convert_X(0),
            Convert_X(0),
            Convert_X(-rad )-1,
            Convert_X(-rad )-1};
        int yPoints[] = {Convert_Y(0),
            Convert_Y(-rad * 0.5)+1,
            Convert_Y(-rad* 0.5)+1,
            Convert_Y(0)};
        int xPointsT[] = {Convert_X(0),
            Convert_X(-rad )-1,
            Convert_X(0)};
        int yPointsT[] = {Convert_Y(0),
            Convert_Y(0),
            Convert_Y(rad )-1};

        g.fillPolygon(xPoints, yPoints, 4);
        g.fillPolygon(xPointsT, yPointsT, 3);
    }

    private void PrintSector(Graphics g) {
        g.fillArc(Convert_X(-rad*0.5),
                Convert_Y(rad*0.5),
                (int) (Z * rad ),
                (int) (Z * rad ), 0, 90);
    }

    public static boolean SetRad(double Radius) {
        if (Radius != 0) {
            rad = Radius;
            return true;
        }

        return false;
    }

    public static void SetX(double X) {
        x = X;
    }

    public static void SetY(double Y) {
        y = Y;
    }

    public static boolean SetZ(int z) {
        if (z != 0) {
            Z = z;
            return true;
        }

        return false;
    }
}
