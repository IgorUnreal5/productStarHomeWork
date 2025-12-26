package work013;

import java.util.*;

public class ResultsBoard {
    private final TreeMap<Float, TreeSet<String>> scoreMap;

    // Конструктор инициализирует TreeMap
    public ResultsBoard() {
        this.scoreMap = new TreeMap<>();
    }

    // Способ добавления учащегося с его баллом
    public void addStudent(String name, Float score) {
        // Получите или создайте TreeSet, связанный с партитурой.
        TreeSet<String> students = scoreMap.getOrDefault(score, new TreeSet<>());
        students.add(name);
        scoreMap.put(score, students);
    }

    // Метод получения трех лучших учеников по баллам в порядке убывания.
    public List<Map.Entry<String, Float>> top3() {
        List<Map.Entry<String, Float>> topStudents = new ArrayList<>();

        // Перебрать карту в обратном порядке (сначала самый высокий балл)
        Iterator<Map.Entry<Float, TreeSet<String>>> iterator = scoreMap.descendingMap().entrySet().iterator();
        int count = 0;

        while (iterator.hasNext() && count < 3) {
            Map.Entry<Float, TreeSet<String>> entry = iterator.next();
            Float score = entry.getKey();
            TreeSet<String> students = entry.getValue();

            // Добавьте студентов в список. TreeSet естественным образом выполняет итерацию в порядке возрастания.
            for (String student : students) {
                if (count < 3) {
                    topStudents.add(new AbstractMap.SimpleEntry<>(student, score));
                    count++;
                } else {
                    break;
                }
            }
        }

        return topStudents;
    }

    public static void main(String[] args) {
        ResultsBoard board = new ResultsBoard();
        board.addStudent("Алиса", 88.5f);
        board.addStudent("Борис", 92.0f);
        board.addStudent("Константин", 85.5f);
        board.addStudent("Диана", 95.0f);
        board.addStudent("Ева", 92.0f);

        List<Map.Entry<String, Float>> topStudents = board.top3();

        System.out.println("Топ 3 студента:");
        for (Map.Entry<String, Float> entry : topStudents) {
            System.out.printf("%s - %.2f%n", entry.getKey(), entry.getValue());
        }
    }
}
