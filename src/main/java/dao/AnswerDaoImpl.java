package dao;

import domain.Answer;
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

public class AnswerDaoImpl implements AnswerDao {

    private final String fileName;

    public AnswerDaoImpl(String fileName) {
        this.fileName = fileName;
    }

    public List<Answer> getAll() {
        ClassLoader classLoader = getClass().getClassLoader();
        String file = Objects.requireNonNull(classLoader.getResource(fileName)).getFile();
        List<Answer> answerList = new ArrayList<>();

        try {
            Reader reader = Files.newBufferedReader(Paths.get(file));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                    .withFirstRecordAsHeader()
                    .withIgnoreHeaderCase()
                    .withTrim());

            for (CSVRecord csvRecord :
                    csvParser) {
                String answerString = csvRecord.get("Answer");
                String answerId = csvRecord.get("№");
                Answer answer = new Answer(answerId, answerString);
                answerList.add(answer);
            }
            return answerList;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
