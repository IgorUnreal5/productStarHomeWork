package homework.work010;

import java.util.HashMap;
import java.util.Map;

public class FromIntegerStringToStringIntegerHashMap {
    public static HashMap<Integer, String> getFromIntegerString()
    {
        HashMap<Integer, String> fromIntegerString = new HashMap<>();
        fromIntegerString.put(1, "one");
        fromIntegerString.put(2, "two");
        return fromIntegerString;
    }


    public static void getToStringInteger(HashMap<Integer, String> getFromIntegerString)
    {
        HashMap<String, Integer> toStringInteger = new HashMap<>();

        System.out.println("fromIntegerString: " + getFromIntegerString);

        for (Map.Entry<Integer, String> entry : getFromIntegerString.entrySet()) {
            toStringInteger.put(entry.getValue(), entry.getKey());
        }
        System.out.println("toStringInteger: " + toStringInteger);
    }

    public static void main(String[] args) {
        HashMap<Integer, String> fromIntegerString = getFromIntegerString();
        getToStringInteger(fromIntegerString);
    }
}
