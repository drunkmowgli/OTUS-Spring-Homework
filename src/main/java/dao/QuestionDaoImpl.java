package dao;

import domain.Question;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class QuestionDaoImpl implements QuestionDao {

    private final String fileName;

    public QuestionDaoImpl(String fileName) {
        this.fileName = fileName;
    }

    public List<Question> getAll() {
        ClassLoader classLoader = getClass().getClassLoader();
        String file = Objects.requireNonNull(classLoader.getResource(fileName)).getFile();
        List<Question> questionList = new ArrayList<>();
        try {
            Reader reader = Files.newBufferedReader(Paths.get(file));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                    .withFirstRecordAsHeader()
                    .withIgnoreHeaderCase()
                    .withTrim());

            for (CSVRecord csvRecord :
                    csvParser) {
                String questionString = csvRecord.get("Question");
                String questionId = csvRecord.get("№");
                Question question = new Question(questionId, questionString);
                questionList.add(question);
            }
            return questionList;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
