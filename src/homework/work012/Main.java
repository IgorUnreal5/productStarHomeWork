package homework.work012;

public class Main {
    public static void main(String[] args) {
        Examination examination = new ExaminationImpl(System.getProperty("user.dir") + "\\src\\homework\\work012\\data.csv");

        String[] subjects = {"Математика", "Физика", "История"};

        System.out.println("\nСредняя оценка по предметам:");
        examination.printAverageForSubjects(subjects);

        System.out.println("--------------------------------------------");
        System.out.println("Список студентов с несколькими сдачами:");
        examination.multipleSubmissionsStudentNames2();

        System.out.println("\nСтуденты с отличными оценками (последние 5):");
        examination.lastFiveStudentsWithExcellentMarkOnAnySubject2();

        System.out.println("\nСредняя оценка по Математике:");
        System.out.println(examination.getAverageForSubject("Математика"));

        System.out.println("\nВсе оценки студентов:");
        examination.printScores();
    }
}
