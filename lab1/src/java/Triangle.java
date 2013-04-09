
public class Triangle implements Figure {

    Point P1, P2, P3;

    public Triangle(Point P1, Point P2, Point P3) {
    
        this.P1 = P1;
        this.P2 = P2;
        this.P3 = P3;
    }

     private static boolean OnLine(
            Point LinePoint1,
            Point LinePoint2,
            Point TestPoint) {
        double buf = (
                (LinePoint1.Y() - LinePoint2.Y())
                * TestPoint.X() + LinePoint1.X() *
                LinePoint2.Y() - LinePoint1.Y() *
                LinePoint2.X()) / (LinePoint1.X() - LinePoint2.X()
                );
        
        return (buf==TestPoint.Y());
    }
    private static boolean UpSide(
            Point LinePoint1,
            Point LinePoint2,
            Point TestPoint) {
        double buf = (
                (LinePoint1.Y() - LinePoint2.Y())
                * TestPoint.X() + LinePoint1.X() *
                LinePoint2.Y() - LinePoint1.Y() *
                LinePoint2.X()) / (LinePoint1.X() - LinePoint2.X()
                );
        
        return (buf<TestPoint.Y());
    }

    private static boolean SameSide(
            Point LinePoint1,
            Point LinePoint2,
            Point Point,
            Point TestPoint) {
      
               if(UpSide(LinePoint1, LinePoint2, Point) ==  UpSide(LinePoint1, LinePoint2, TestPoint)||OnLine(LinePoint1,LinePoint2,TestPoint))
                   return true;
               else
                   return false;
                           
               
    }

    @Override
    public boolean ContainsPoint(Point Point) {
       return (
               SameSide(P1, P2, P3, Point) && 
               SameSide(P1, P3, P2, Point) && 
               SameSide(P2, P3, P1, Point)
               );
          
    }

    
}
