package config;

import dao.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoConfig {

    @Bean
    PersonDao personDao() {
        return new PersonDaoImpl();
    }

    @Bean
    QuestionDao questionDao(@Value("Questions.csv") String fileName) {
        return new QuestionDaoImpl(fileName);
    }

    @Bean
    AnswerDao answerDao(@Value("Answers.csv") String fileName) {
        return new AnswerDaoImpl(fileName);
    }
}
