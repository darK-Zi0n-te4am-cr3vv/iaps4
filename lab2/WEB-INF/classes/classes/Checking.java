package classes;

public class Checking 
{
    public static boolean LastState = false;
    private static Sektor MySektor;
    private static Quadrangle MyQuadrangle;
    private static Triangle MyTriangle;

    private static double rad = 1, x, y;

    public static void CheckThrow(double Rad, double X, double Y)
    {
        rad = Rad;
        x = X;
        y = Y;
    
        for(Figure fig: InitFigures())
        {
            if(fig.ContainsPoint(new Point(x,y)))
            {
                LastState = true;
                return;
            }
        }
        
        LastState = false;
    }
    
    private static Figure[] InitFigures()
    {
        MySektor = new Sektor(new Point(0,0),rad*0.5,0,Math.PI*0.5);
        MyQuadrangle = new Quadrangle(new Point(0,0),new Point(0,rad),
                new Point(-rad/2,rad),new Point(-rad/2,0));
        MyTriangle = new Triangle(new Point(0,0),new Point(-rad/2,0),new Point(0,-rad/2));
        Figure[] MyFigure = {MySektor,MyQuadrangle,MyTriangle};
        return MyFigure;
    }
}