public class Rectangle {

    private double width;
    private double height;
    private int id;
    private static int idGen = 1;

    public Rectangle() {
        width = 1.0;
        height = 1.0;
        id = idGen;
        idGen++;
    }

    public Rectangle(double w, double h) {
        this();
        setWidth(w);
        setHeight(h);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double w) {
        if (w <= 0) {
            throw new IllegalArgumentException("Width must be > 0");
        }
        width = w;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double h) {
        if (h <= 0) {
            throw new IllegalArgumentException("Height must be > 0");
        }
        height = h;
    }

    public double area() {
        return width * height;
    }

    public double perimeter() {
        return 2 * (width + height);
    }

    public String toString() {
        return "Rectangle id=" + id +
                ", width=" + width +
                ", height=" + height;
    }
}
