package homework.work010;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RemoveFromArrayList {

    public static void getResult()
    {
        ArrayList<String> names = new ArrayList<>();
        names.add("John");
        names.add("Bob");
        names.add("Bob");
        System.out.println("Before: " + names);

        Set<String> set = new HashSet<>(names);
        System.out.println("After: " + set);
    }

    public static void main(String[] args) {
        getResult();
    }
}
