package homework.work003;

import java.util.concurrent.ThreadLocalRandom;

public class SuperCycle {
    public static void main(String[] args) {
        int randNumber = ThreadLocalRandom.current().nextInt(0, 51);

        System.out.println("Рандомное число: " + randNumber);
        for (int i = 0; i < randNumber; i++) {
            if (i > 0) {
                if (i % 3 == 0 && i % 5 != 0) {
                    System.out.print("fizz ");
                } else if (i % 5 == 0 && i % 3 != 0) {
                    System.out.print("buzz ");
                } else if (i % 5 == 0) {
                    System.out.print("fizzbuzz ");
                } else {
                    System.out.print(i + " ");
                }
            } else {
                System.out.print(i + " ");
            }
        }
    }
}
