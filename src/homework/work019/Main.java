package work019;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ResultsProcessor processor = context.getBean(ResultsProcessor.class);
        String filePath = "src/homework/work019/results.csv";
        String filePath2 = "src/homework/work019/results2.csv"; //для теста неправильного формата файла
        processor.loadData(filePath);
        List<Result> topMen10km = processor.getTopResults("10 км", "М", 3);
        System.out.println(topMen10km);
    }
}