package work008;
import java.util.HashMap;

public class Stringularity {
    public static void main(String[] args) {
        HashMap<String, String> countResult = getStringStringHashMap();
        countResult.forEach((k, v) -> System.out.println("В слове '" + k + "' количество символов 'е' = " + v));


        String number = "+79999999999";
        String regex = "^[+][1-9]{1,4}[0-9]{10,13}$";
        boolean check = number.matches(regex);
        if (check) {
            System.out.println(number);
        }
        String b = "100 AbВгёЁ";
        String regex2 = "[A-Za-z\\hА-ЯЁа-яё]+";
        String stringCheck = b.replaceAll(regex2, "");
        System.out.println(stringCheck);
    }

    private static HashMap<String, String> getStringStringHashMap() {
        String a = "Домашнее задание. В тексте, который вы видите на этом изображении, посчитайте количество букв 'е' в каждом слове. Напишите регулярное выражение для проверки телефона в международном формате. С помощью регулярного выражения напишите функцию удаления всех букв и пробелов из текста.";
        String[] explodedText = a.split(" ");
        HashMap<String, String> countResult = new HashMap<>(explodedText.length);
        int count = 0;
        for (String word : explodedText) {
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == 'е') {
                    count++;
                }
            }
            countResult.put(word, String.valueOf(count));
            count = 0;
        }
        return countResult;
    }
}
