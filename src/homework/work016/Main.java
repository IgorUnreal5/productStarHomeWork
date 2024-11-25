package homework.work016;

import java.util.Arrays;

public class Main {
    static int max_size = 2;
    static int size = 0;
    static int[] data = new int[max_size];

    public static void main(String[] args) {
        add(4);
        add(3);
        add(1);
        add(5);
        print(); // должно вывести 4,3,1,5
        sort();
        print(); // должно вывести 1,3,4,5
    }

    static void sort() {
        // Реализуем сортировку пузырьком
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (data[j] > data[j + 1]) {
                    // Меняем местами элементы
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    static void print() {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(" " + data[i]);
        }
        System.out.println(" ]");
    }

    static void add(int value) {
        if (size >= data.length) {
            max_size *= 2;
            int[] temp = Arrays.copyOf(data, size);
            data = new int[max_size];
            System.arraycopy(temp, 0, data, 0, temp.length);
        }
        data[size] = value;
        size++;
    }
}
