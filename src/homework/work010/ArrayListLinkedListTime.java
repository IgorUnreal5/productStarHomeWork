package homework.work010;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayListLinkedListTime {

    public static long getTimeWorkArrayList(int count, int count2)
    {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int point = (int) (Math.random() * 100);
            list.add(point);
        }
        long startTime = System.nanoTime();
        for (int i = 0; i < count2; i++) {
            list.get((int) (Math.random() * count2));
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static long getTimeWorkLinkedList(int count, int count2)
    {
        LinkedList<Integer> link = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            int point = (int) (Math.random() * 100);
            link.add(point);
        }
        long startTime = System.nanoTime();
        for (int i = 0; i < count2; i++) {
            link.get((int) (Math.random() * count2));
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    /*
    * метод get ArrayList отрабатывает быстрее того же метода LinkedList, потому что выборка по индексу, а не по связаям
    * */
    public static void main(String[] args) {
        int count = 1000000;
        int count2 = 1000;

        System.out.println("Время выборки по индексу ArrayList: " + getTimeWorkArrayList(count, count2));
        System.out.println("Время выборки по индексу LinkedList: " + getTimeWorkLinkedList(count, count2));
    }
}
