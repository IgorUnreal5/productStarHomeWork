package homework.work012;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class ExaminationImpl implements Examination {
    private final Map<String, Score> scoresMap = new HashMap<>();
    private final Map<String, List<Score>> scoreHistoryMap = new HashMap<>();

    public ExaminationImpl(String dataFilePath) {
        loadScoresFromFile(dataFilePath);
    }

    private void loadScoresFromFile(String dataFilePath) {
        String line = null;
        try (BufferedReader br = new BufferedReader(new FileReader(dataFilePath))) {
            // Пробуем прочитать заголовок
            if ((line = br.readLine()) != null) {
                System.out.println("Файл успешно прочитан!");
            }

            while ((line = br.readLine()) != null) {
                //System.out.println("Чтение строки: " + line);
                String[] parts = line.split(",");
                if (parts.length < 3) {
                    System.out.println("Недостаточно данных в строке: " + line);
                    continue; // Пропускаем строки с недостаточным количеством данных
                }

                String name = parts[0].replace("\"", "").trim();
                String subject = parts[1].replace("\"", "").trim();
                int score = Integer.parseInt(parts[2].replace("\"", "").trim());

                addScore(new Score(name, subject, score));
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("Файл не найден: " + dataFilePath);
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + dataFilePath);
            String stackTrace = Arrays.toString(e.getStackTrace());
            System.out.println(stackTrace);
        } catch (NumberFormatException nfe) {
            System.out.println("Ошибка формата числа в строке: " + line);
            String stackTrace = Arrays.toString(nfe.getStackTrace());
            System.out.println(stackTrace);
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
            String stackTrace = Arrays.toString(e.getStackTrace());
            System.out.println(stackTrace);
        }
    }

    @Override
    public void addScore(Score score) {
        String key = score.name() + "_" + score.subject();

        // Сохраняем только последнюю сдачу
        scoresMap.put(key, score);

        // Сохраняем для истории сдач
        scoreHistoryMap.computeIfAbsent(score.name() + " - " + score.subject(), k -> new ArrayList<>()).add(score);
    }

    @Override
    public Score getScore(String name, String subject) {
        return scoresMap.get(name + "_" + subject);
    }

    @Override
    public double getAverageForSubject(String subjects) {
        return scoresMap.values().stream()
                .filter(score -> Objects.equals(subjects, score.subject()))
                .mapToInt(Score::score)
                .average()
                .orElse(0.0);
    }

    @Override
    public void printAverageForSubjects(String[] subjects) {
        Map<String, Double> averageScoreCache = new HashMap<>(); // Кеш для средней оценки
        for (String subject : subjects) {
            // Проверяем, есть ли средняя оценка в кеше
            if (averageScoreCache.containsKey(subject)) {
                System.out.println("Данные извлечены из кеша для предмета " + subject + ": " + averageScoreCache.get(subject));
            } else {
                // Если в кеше нет, вычисляем среднюю оценку
                OptionalDouble averageScore = scoresMap.values()
                        .stream()
                        .filter(score -> score.subject().equals(subject))
                        .mapToInt(Score::score)
                        .average();

                double result = averageScore.orElse(0.0);

                // Кешируем результат
                averageScoreCache.put(subject, result);
                System.out.println(subject + ": " + result);
                System.out.println("Сейчас в кеше: " + averageScoreCache);
            }
        }
    }

    @Override
    public Set<String> multipleSubmissionsStudentNames() {
        Set<String> studentsWithMultiple = new HashSet<>();
        for (Map.Entry<String, List<Score>> entry : scoreHistoryMap.entrySet()) {
            if (entry.getValue().size() > 1) {
                studentsWithMultiple.add(entry.getKey());
            }
        }
        return studentsWithMultiple;
    }

    @Override
    public void multipleSubmissionsStudentNames2() {
        Set<String> uniqueStudentSubjectPairs = new TreeSet<>(); // Используем Set для уникальных пар студент-предмет
        for (String student : multipleSubmissionsStudentNames()) {
            List<Score> scores = scoreHistoryMap.get(student);
            for (Score score : scores) {
                uniqueStudentSubjectPairs.add(score.name() + " - " + score.subject());
            }
        }
        for (String studentSubject : uniqueStudentSubjectPairs) {
            System.out.println(studentSubject);
        }
    }


    @Override
    public Set<String> lastFiveStudentsWithExcellentMarkOnAnySubject() {
        Set<String> excellentStudents = new TreeSet<>(Comparator.reverseOrder());
        for (Score score : scoresMap.values()) {
            if (score.score() == 5) {
                excellentStudents.add(score.name());
            }
        }
        // Ограничить до 5 последних
        return excellentStudents.stream().limit(5).collect(Collectors.toSet());
    }

    @Override
    public void lastFiveStudentsWithExcellentMarkOnAnySubject2() {
        Set<String> excellentStudents = new TreeSet<>(Comparator.reverseOrder());
        for (Score score : scoresMap.values()) {
            if (score.score() == 5) {
                excellentStudents.add(score.name() + " - " + score.subject());
            }
            // Ограничить до 5 последних
            if (excellentStudents.size() >= 5) {
                break;
            }
        }
        excellentStudents.forEach(System.out::println);
    }

    @Override
    public Collection<Score> getAllScores() {
        return scoresMap.values();
    }

    @Override
    public void printScores() {
        for (Map.Entry<String, Score> entry : scoresMap.entrySet()) {
            Score score = entry.getValue();
            System.out.println(score.name() + " - " + score.subject() + " - " + score.score());
        }
    }
}
