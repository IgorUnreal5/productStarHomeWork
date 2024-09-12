package homework.work015;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class MenuHandler {
    private static final StudentManager studentManager = new StudentManager();
    private static final Scanner scanner = new Scanner(System.in);

    public void startMenu() {
        while (true) {
            printMainMenu();
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    addStudent();
                    break;
                case "2":
                    updateStudent();
                    break;
                case "3":
                    deleteStudent();
                    break;
                case "4":
                    studentManager.printCityStatistics();
                    break;
                case "5":
                    studentManager.printCourseStatistics();
                    break;
                case "6":
                    searchStudent();
                    break;
                case "7":
                    printAllStudents();
                    break;
                case "8":
                    System.out.println("Выход из программы.");
                    return;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, выберите действие от 1 до 8.");
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("Выберите действие:\n1 - Добавить студента\n2 - Обновить студента\n3 - Удалить студента\n4 - Статистика по городам\n5 - Статистика по курсам\n6 - Поиск по фамилии\n7 - Вывести всех студентов\n8 - Выход");
    }

    private static void addStudent() {
        System.out.println("Введите имя:");
        String firstName = scanner.nextLine();
        System.out.println("Введите фамилию:");
        String lastName = scanner.nextLine();
        System.out.println("Введите город:");
        String city = scanner.nextLine();
        System.out.println("Введите курс:");
        String course = scanner.nextLine();
        System.out.println("Введите возраст:");
        int age = Integer.parseInt(scanner.nextLine());

        studentManager.addStudent(firstName, lastName, city, course, age);
        System.out.println("Студент добавлен.");
    }

    private static void updateStudent() {
        System.out.println("Введите ID студента для обновления:");
        UUID id = enterUUID();

        if (id == null) {
            System.out.println("Некорректный формат ID. Обновление отменено.");
            return;
        }

        System.out.println("Введите новое имя (оставьте пустым для сохранения текущего значения):");
        String firstName = scanner.nextLine();
        System.out.println("Введите новую фамилию (оставьте пустым для сохранения текущего значения):");
        String lastName = scanner.nextLine();
        System.out.println("Введите новый город (оставьте пустым для сохранения текущего значения):");
        String city = scanner.nextLine();
        System.out.println("Введите новый курс (оставьте пустым для сохранения текущего значения):");
        String course = scanner.nextLine();
        int age = enterAge();

        studentManager.updateStudent(id, firstName.isEmpty() ? null : firstName,
                lastName.isEmpty() ? null : lastName,
                city.isEmpty() ? null : city,
                course.isEmpty() ? null : course,
                age == -1 ? null : age);
        System.out.println("Студент обновлен.");
    }

    private static void deleteStudent() {
        System.out.println("Введите ID студента для удаления:");
        UUID id = enterUUID();

        if (id == null) {
            System.out.println("Некорректный формат ID. Удаление отменено.");
            return;
        }

        studentManager.deleteStudent(id);
        System.out.println("Студент удален.");
    }

    private static void searchStudent() {
        System.out.println("Введите фамилию для поиска или диапазон фамилий через запятую:");
        String input = scanner.nextLine();

        if (input.isEmpty()) {
            System.out.println("Пустой ввод. Введите хотя бы один символ для поиска.");
            return;
        }

        if (input.contains(",")) {
            String[] names = input.split(",");
            if (names.length != 2) {
                System.out.println("Некорректный ввод. Пожалуйста, введите два значения через запятую.");
                return;
            }
            List<Student> foundStudents = studentManager.searchByLastNameRange(names[0].trim(), names[1].trim());
            if (foundStudents.isEmpty()) {
                System.out.println("Студенты не найдены.");
            } else {
                foundStudents.forEach(System.out::println);
            }
        } else {
            List<Student> foundStudents = studentManager.searchByLastName(input);
            if (foundStudents.isEmpty()) {
                System.out.println("Студенты не найдены.");
            } else {
                foundStudents.forEach(System.out::println);
            }
        }
    }

    private static void printAllStudents() {
        studentManager.getAllStudents().forEach(System.out::println);
    }

    private static UUID enterUUID() {
        try {
            return UUID.fromString(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    private static int enterAge() {
        while (true) {
            try {
                System.out.println("Введите возраст (оставьте пустым для сохранения текущего значения):");
                String input = scanner.nextLine();
                if (input.isEmpty()) {
                    return -1; // возвращаем -1 для сохранения текущего значения
                }
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Некорректный формат возраста. Пожалуйста, введите целое число.");
            }
        }
    }
}