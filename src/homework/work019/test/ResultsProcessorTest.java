package work019.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import work019.Result;
import work019.ResultsProcessor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ResultsProcessorTest {

    private ResultsProcessor processor;
    private String testFilePath;

    @BeforeEach
    void setUp() throws IOException {
        processor = new ResultsProcessor();
        // Создаем временный CSV-файл для тестов
        Path tempFile = Files.createTempFile("test_results", ".csv");
        testFilePath = tempFile.toString();
        String content = """
                Иван Иванов, М, 10 км, 55:20
                Мария Петрова, Ж, 5 км, 28:45
                Александр Сидоров, М, 5 км, 22:15
                Анна Кузнецова, Ж, 10 км, 60:00
                """;
        Files.writeString(tempFile, content);
    }

    @Test
    void testLoadData_Success() throws IOException {
        processor.loadData(testFilePath);
        List<Result> loaded = processor.getAllResults();
        assertEquals(4, loaded.size());
        assertEquals("Иван Иванов", loaded.getFirst().name());
        assertEquals(55 * 60 + 20, loaded.getFirst().getTimeInSeconds());
    }

    @Test
    void testLoadData_EmptyFile() throws IOException {
        Path emptyFile = Files.createTempFile("empty", ".csv");
        processor.loadData(emptyFile.toString());
        assertTrue(processor.getAllResults().isEmpty());
    }

    @Test
    void testLoadData_InvalidData() throws IOException {
        Path invalidFile = Files.createTempFile("invalid", ".csv");
        Files.writeString(invalidFile, "Invalid line\nName, M, 10 км, invalid:time");
        processor.loadData(invalidFile.toString());
        assertEquals(0, processor.getAllResults().size()); // Пропускаем invalid
    }

    @Test
    void testGetTopResults_Men10km() throws IOException {
        processor.loadData(testFilePath);
        List<Result> top = processor.getTopResults("10 км", "М", 1);
        assertEquals(1, top.size());
        assertEquals("Иван Иванов", top.getFirst().name());
    }

    @Test
    void testGetTopResults_Women5km() throws IOException {
        processor.loadData(testFilePath);
        List<Result> top = processor.getTopResults("5 км", "Ж", 3);
        assertEquals(1, top.size()); // Только одна
        assertEquals("Мария Петрова", top.getFirst().name());
    }

    @Test
    void testGetTopResults_Sorting() throws IOException {
        // Добавим больше данных для проверки сортировки
        Path sortFile = Files.createTempFile("sort", ".csv");
        Files.writeString(sortFile, """
                Runner1, М, 5 км, 25:00
                Runner2, М, 5 км, 20:00
                Runner3, М, 5 км, 22:00
                """);
        processor.loadData(sortFile.toString());
        List<Result> top = processor.getTopResults("5 км", "М", 3);
        assertEquals(3, top.size());
        assertEquals("Runner2", top.get(0).name()); // 20:00
        assertEquals("Runner3", top.get(1).name()); // 22:00
        assertEquals("Runner1", top.get(2).name()); // 25:00
    }

    @Test
    void testGetTopResults_NoMatches() throws IOException {
        processor.loadData(testFilePath);
        List<Result> top = processor.getTopResults("42 км", "М", 5);
        assertTrue(top.isEmpty());
    }

    @Test
    void testGetTopResults_InvalidN() {
        assertThrows(IllegalArgumentException.class, () -> processor.getTopResults("5 км", "М", 0));
    }
}