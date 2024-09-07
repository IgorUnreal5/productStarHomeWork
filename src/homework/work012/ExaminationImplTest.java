package homework.work012;

class ExaminationImplTest {

    @org.junit.jupiter.api.Test
    void addScore() {
        String key = "Petr Petrov" + "_" + "Математика";
        System.out.println(key);
    }

    @org.junit.jupiter.api.Test
    void getScore() {
        String score = Integer.toString((int) (Math.random() * 10));
        System.out.println(score);
    }

    @org.junit.jupiter.api.Test
    void getAverageForSubject() {
        double[] scoresArray = new double[10]; // Создайте массив для 10 случайных значений
        for (int i = 0; i < scoresArray.length; i++) {
            String score = Integer.toString((int) (Math.random() * 10)); // Получаем случайное число
            scoresArray[i] = Double.parseDouble(score); // Преобразуем строку в double
            double sum = 0;
            for (double number : scoresArray) {
                sum += number;
            }
            double average = sum / scoresArray.length;
            System.out.println(average);
        }
    }
}