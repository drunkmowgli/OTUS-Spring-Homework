package config;

import dao.AnswerDao;
import dao.PersonDao;
import dao.QuestionDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import service.*;

@Configuration
@Import(DaoConfig.class)
public class ServiceConfig {

    @Bean
    PersonService personService(PersonDao personDao) {
        return new PersonServiceImpl(personDao);
    }

    @Bean
    AnswerService answerService(AnswerDao answerDao) {
        return new AnswerServiceImpl(answerDao);
    }

    @Bean
    QuestionService questionService(QuestionDao questionDao, AnswerService answerService) {
        return new QuestionServiceImpl(questionDao, answerService);
    }
}
