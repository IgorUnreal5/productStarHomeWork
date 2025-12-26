package work012;

import java.util.Collection;
import java.util.Set;

//Добавил методов для нормального вывода их в Main
public interface Examination {
    void addScore(Score score);

    Score getScore(String name, String subject);

    double getAverageForSubject(String subject);

    void printAverageForSubjects(String[] subjects);

    Set<String> multipleSubmissionsStudentNames();

    void multipleSubmissionsStudentNames2();

    Set<String> lastFiveStudentsWithExcellentMarkOnAnySubject();

    void lastFiveStudentsWithExcellentMarkOnAnySubject2();

    Collection<Score> getAllScores();

    void printScores();
}
