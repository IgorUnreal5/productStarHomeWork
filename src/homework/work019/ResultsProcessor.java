package work019;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ResultsProcessor {
    private final List<Result> results = new ArrayList<>();

    /**
     * Загружает данные из CSV-файла.
     * @param filePath путь к файлу
     * @throws IOException если файл не найден или ошибка чтения
     */
    public void loadData(String filePath) throws IOException {
        results.clear(); // Очищаем предыдущие данные
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    try {
                        String name = parts[0].trim();
                        String gender = parts[1].trim();
                        String distance = parts[2].trim();
                        String time = parts[3].trim();
                        // Проверяем формат времени при создании
                        new Result(name, gender, distance, time).getTimeInSeconds(); // Вызов для валидации
                        results.add(new Result(name, gender, distance, time));
                    } catch (IllegalArgumentException e) {
                        // Пропускаем некорректные строки, можно добавить лог
                        System.err.println("Skipping invalid line: " + line + " Reason: " + e.getMessage());
                    }
                } else {
                    // Пропускаем некорректные строки
                    System.err.println("Skipping invalid line (wrong fields count): " + line);
                }
            }
        }
    }

    /**
     * Возвращает топ-N лучших результатов по дистанции и полу.
     * @param distance дистанция ("5 км" или "10 км")
     * @param gender пол ("М" или "Ж")
     * @param n количество результатов
     * @return список топ-N результатов, отсортированных по времени (от лучшего)
     */
    public List<Result> getTopResults(String distance, String gender, int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("N must be positive");
        }
        return results.stream()
                .filter(r -> r.distance().equals(distance) && r.gender().equals(gender))
                .sorted(Comparator.comparingInt(Result::getTimeInSeconds))
                .limit(n)
                .collect(Collectors.toList());
    }

    // Для тестов: getter для результатов
    public List<Result> getAllResults() {
        return new ArrayList<>(results);
    }
}