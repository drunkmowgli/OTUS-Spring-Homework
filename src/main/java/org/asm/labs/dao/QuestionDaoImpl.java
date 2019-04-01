package org.asm.labs.dao;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.asm.labs.domain.Question;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

@PropertySource("classpath:application.properties")
@Repository("questionDao")
public class QuestionDaoImpl implements QuestionDao {

    private final String fileNameEN;

    private final String fileNameRU;

    public QuestionDaoImpl(@Value("${EN.questions.filename}") String fileNameEN,
                           @Value("${RU.questions.filename}") String fileNameRU) {
        this.fileNameEN = fileNameEN;
        this.fileNameRU = fileNameRU;
    }

    public List<Question> getAll(Locale locale) {
        String fileName;
        if (locale.getDefault().equals(Locale.ENGLISH)) {
            System.out.println(locale.getDefault());
            fileName = fileNameEN;
        } else {
            fileName = fileNameRU;
        }
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
