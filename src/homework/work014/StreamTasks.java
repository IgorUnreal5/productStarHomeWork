package work014;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamTasks {
    public static List<String> removeDuplicates(List<String> list) {
        return list.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    public static long countStringsStartingWith(List<String> list, char startingLetter) {
        return list.stream()
                .filter(s -> !s.isEmpty() && s.charAt(0) == startingLetter)
                .count();
    }

    public static Optional<Integer> findSecondLargest(List<Integer> list) {
        return list.stream()
                .sorted((a, b) -> Integer.compare(b, a)) // Сортируем по убыванию
                .distinct() // Убираем дубликаты
                .skip(1) // Пропускаем первый элемент (наибольший)
                .findFirst(); // Находим первый элемент (второй по величине)
    }

    public static void main(String[] args) {
        // Пример использования функции removeDuplicates
        List<String> stringList = List.of("apple", "banana", "apple", "orange", "banana");
        System.out.println(removeDuplicates(stringList));

        // Пример использования функции countStringsStartingWith
        List<String> list = List.of("apple", "banana", "apricot", "orange", "avocado");
        System.out.println(countStringsStartingWith(list, 'a'));

        // Пример использования функции findSecondLargest
        List<Integer> intList = List.of(10, 20, 4, 4, 30, 20, 15, 40);
        System.out.println(findSecondLargest(intList).orElse(null));
    }
}
