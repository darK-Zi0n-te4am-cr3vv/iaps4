


public class Quadrangle implements Figure {

    Point P1, P2, P3, P4;

    public Quadrangle(Point P1, Point P2, Point P3, Point P4) {
        this.P1 = P1;
        this.P2 = P2;
        this.P3 = P3;
        this.P4 = P4;
    }

    @Override
    public boolean ContainsPoint(Point Point) {
        Triangle Triangle_1 = new Triangle(P1, P2, P3);
        Triangle Triangle_2 = new Triangle(P2, P3, P4);
        Triangle Triangle_3 = new Triangle(P3, P4, P1);
        return (
                Triangle_1.ContainsPoint(Point) || 
                Triangle_2.ContainsPoint(Point) ||
                Triangle_3.ContainsPoint(Point)
                );
        
    }
}
