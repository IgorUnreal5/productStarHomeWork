package homework.work011;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Double> getRollingAverage(ArrayList<Integer> arr, int k) {
        List<Double> result = new ArrayList<>();
        int n = arr.size();
        // Проверка на валидность входных данных
        if (k <= 0 || k > n) {
            throw new IllegalArgumentException("Parameter k must be in the range 1 to n.");
        }
        // Вычисление среднего значения для каждого подмассива длиной k
        for (int i = 0; i <= n - k; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += arr.get(j);
            }
            double average = (double) sum / k;
            result.add(average);
        }
        return result;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(5);
        int k = 2;
        List<Double> averages = getRollingAverage(arr, k);
        System.out.println(averages); // Вывод: [1.5, 2.5, 4.0]
    }
}
