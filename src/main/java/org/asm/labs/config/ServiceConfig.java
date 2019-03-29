package org.asm.labs.config;

import org.asm.labs.dao.AnswerDao;
import org.asm.labs.dao.PersonDao;
import org.asm.labs.dao.QuestionDao;
import org.asm.labs.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public AnswerService answerService(AnswerDao answerDao) {
        return new AnswerServiceImpl(answerDao);
    }

    @Bean
    public QuestionService questionService(QuestionDao questionDao, AnswerService answerService) {
        return new QuestionServiceImpl(questionDao, answerService);
    }

    @Bean
    public PersonService personService(PersonDao personDao) {
        return new PersonServiceImpl(personDao);
    }

    @Bean
    public UserLocaleService userLocaleService() {
        return new UserLocaleServiceImpl();
    }
}
