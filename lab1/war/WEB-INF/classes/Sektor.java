
public class Sektor implements Figure {

    public Point Center;
    public double Radius;
    public double FirstAngle, SecondAngle;

    public Sektor(
            Point Center,
            double Radius,
            double FirstAngle,
            double SecondAngle) {
        this.Center = Center;
        this.Radius = Radius;
        this.FirstAngle = FirstAngle;
        this.SecondAngle = SecondAngle;
    }

    @Override
    public boolean ContainsPoint(Point Point) {
      return ((Point.X()==Center.X()&&Point.Y()==Center.Y())||(Inside(Point)  &&
              ((Point.X() - Center.X()) * (Point.X() - Center.X()) + 
              (Point.Y() - Center.Y()) * (Point.Y() - Center.Y()) <=
              Radius * Radius))
              );
      
    }

    public boolean Inside(Point Point) {

        double Angle =
                Math.atan2(Point.Y() - 
                this.Center.Y(), Point.X() -
                this.Center.X());

    return (Math.abs(Angle) >= Math.abs(FirstAngle) && Math.abs(Angle) <= Math.abs(SecondAngle));

    }
}
