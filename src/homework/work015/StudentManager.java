package homework.work015;

import java.util.*;
import java.util.stream.Collectors;

public class StudentManager {
    private final List<Student> students = new ArrayList<>();

    // Добавление студента
    public void addStudent(String firstName, String lastName, String city, String course, int age) {
        Student student = new Student(firstName, lastName, city, course, age);
        students.add(student);
    }

    // Обновление студента по ID
    public void updateStudent(UUID id, String firstName, String lastName, String city, String course, Integer age) {
        Optional<Student> studentOpt = students.stream().filter(s -> s.getId().equals(id)).findFirst();
        if (studentOpt.isPresent()) {
            Student student = studentOpt.get();
            student.setFirstName(firstName != null ? firstName : student.getFirstName());
            student.setLastName(lastName != null ? lastName : student.getLastName());
            student.setCity(city != null ? city : student.getCity());
            student.setCourse(course != null ? course : student.getCourse());
            student.setAge(age != null ? age : student.getAge());
        } else {
            System.out.println("Студент с таким ID не найден.");
        }
    }

    // Удаление студента по ID
    public void deleteStudent(UUID id) {
        boolean removed = students.removeIf(student -> student.getId().equals(id));
        if (!removed) {
            System.out.println("Студент с таким ID не найден.");
        }
    }

    // Поиск по фамилии
    public List<Student> searchByLastName(String lastName) {
        if (lastName.isEmpty()) {
            return students;
        }
        return students.stream()
                .filter(student -> student.getLastName().equalsIgnoreCase(lastName))
                .collect(Collectors.toList());
    }

    // Поиск по диапазону фамилий
    public List<Student> searchByLastNameRange(String startLastName, String endLastName) {
        return students.stream()
                .filter(student -> student.getLastName().compareToIgnoreCase(startLastName) >= 0 &&
                        student.getLastName().compareToIgnoreCase(endLastName) <= 0)
                .collect(Collectors.toList());
    }

    // Получение всех студентов
    public List<Student> getAllStudents() {
        return students;
    }

    // Подсчет статистики по городам
    public Map<String, Long> getCityStatistics() {
        return students.stream()
                .collect(Collectors.groupingBy(Student::getCity, Collectors.counting()));
    }

    // Подсчет статистики по курсам
    public Map<String, Long> getCourseStatistics() {
        return students.stream()
                .collect(Collectors.groupingBy(Student::getCourse, Collectors.counting()));
    }

    // Вывод статистики по городам
    public void printCityStatistics() {
        Map<String, Long> statistics = getCityStatistics();
        statistics.forEach((city, count) -> System.out.println(city + " - " + count));
    }

    // Вывод статистики по курсам
    public void printCourseStatistics() {
        Map<String, Long> statistics = getCourseStatistics();
        statistics.forEach((course, count) -> System.out.println(course + " - " + count));
    }
}