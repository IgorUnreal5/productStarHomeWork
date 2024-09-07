package homework.work006.circle;

/**
 * Заполните этот класс в соответсвии с заданием из лекции.
 */
public class Circle {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea()
    {
        if (this.radius < 0) {
            throw new IllegalArgumentException("Can't be < 0");
        }
        return Math.PI * Math.pow(this.radius, 2);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
            this.radius = radius;
    }
}
