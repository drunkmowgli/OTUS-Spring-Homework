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

    public List<Question> getAll() {
        ClassLoader classLoader = getClass().getClassLoader();
        String file = Objects.requireNonNull(classLoader.getResource("QA.csv")).getFile();
        try {
            Reader reader = Files.newBufferedReader(Paths.get(file));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
            .withFirstRecordAsHeader()
            .withIgnoreHeaderCase()
            .withTrim());

            for (CSVRecord csvRecord:
                 csvParser) {
                String questionString = csvRecord.get("Question");
                List<Question> questionList = new ArrayList<>();
                Question question = new Question(questionString);
                questionList.add(question);
                return questionList;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
