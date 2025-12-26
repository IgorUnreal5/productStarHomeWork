package work009;

import java.util.Arrays;

public class SortingArray {
    //Создаём массив
    public static int[] getInputArray () {
        int[] inputArray = new int[10000];

        for (int i = 0; i < 10000; i++) {
            inputArray[i] = (int) (Math.random() * 1000);
        }
        return inputArray;
    }


    //Вывод массива
    public static String getOutArray(int[] inputArray) {
        StringBuilder output = new StringBuilder();
        for (int j : inputArray) {
            output.append(j).append(" ");
        }
        return output.toString();
    }

    //Вывод результата с методом
    public static void getResult(long elapsedTime, String method, String inputArray) {
        System.out.println("======= Array =========");
        System.out.println(inputArray + "\nВремя выполнения сортировки методом " + method + ": " + elapsedTime + " миллисекунд.");
        System.out.println("=======================");
    }


    //метод  Array.sort
    public static void outArray(int[] inputArray) {
        String method  = "Arrays.sort";
        String textArrayOut = getOutArray(inputArray);
        int[] sortedArray = new int[inputArray.length];
        System.arraycopy(inputArray, 0, sortedArray, 0, inputArray.length);
        long startTime = System.nanoTime();
        Arrays.sort(sortedArray);
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        getResult(elapsedTime, method, textArrayOut);
    }


    //метод BubbleSort
    public static void BubbleSort(int[] inputArray) {
        String method  = "BubbleSort";
        String textArrayOut = getOutArray(inputArray);
        int[] sortedArray = new int[inputArray.length];
        System.arraycopy(inputArray, 0, sortedArray, 0, inputArray.length);

        long startTime = System.nanoTime();
        for (int i = 0; i < sortedArray.length - 1; i++) {
            for (int j = 0; j < sortedArray.length - i - 1; j++) {
                if (sortedArray[j] > sortedArray[j + 1]) {
                    int temp = sortedArray[j];
                    sortedArray[j] = sortedArray[j + 1];
                    sortedArray[j + 1] = temp;
                }
            }
        }
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        getResult(elapsedTime, method, textArrayOut);
    }


    //метод insertionSort
    public static void insertionSort(int[] inputArray) {
        String method  = "insertionSort";
        String textArrayOut = getOutArray(inputArray);
        int[] sortedArray = new int[inputArray.length];
        System.arraycopy(inputArray, 0, sortedArray, 0, inputArray.length);
        long startTime = System.nanoTime();
        int j;
        for (int i = 1; i < sortedArray.length; i++) {
            int swap = sortedArray[i];
            for (j = i; j > 0 && swap < sortedArray[j - 1]; j--) {
                sortedArray[j] = sortedArray[j - 1];
            }
            sortedArray[j] = swap;
        }
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        getResult(elapsedTime, method, textArrayOut);
    }

    public static void main(String[] args) {
        int[] inputArray = getInputArray();
        outArray(inputArray);
        BubbleSort(inputArray);
        insertionSort(inputArray);
    }
}
