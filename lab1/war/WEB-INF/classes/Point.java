public class Point {

    private double X, Y;

    public Point(double X, double Y) {
        this.X = X;
        this.Y = Y;
    }

    public void Set(double X, double Y) {
        this.X = X;
        this.Y = Y;
    }

    public double X() {
        return this.X;
    }

    public double Y() {
        return this.Y;
    }
}
