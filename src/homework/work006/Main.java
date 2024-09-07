package homework.work006;

import homework.work006.circle.Circle;

public class Main {
    public static void main(String[] args) {
        TestCircle test = new TestCircle();
        test.test();

        Circle circle = new Circle(-2);
        System.out.println(circle.getArea());
    }
}