package org.asm.labs.service;

import org.asm.labs.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@ComponentScan(basePackages = "org.asm.labs")
public class Exam {

    private QuestionService questionService;
    private UserLocaleService userLocaleService;
    private MessageSource messageSource;


    @Autowired
    public Exam(QuestionService questionService, UserLocaleService userLocaleService, MessageSource messageSource) {
        this.questionService = questionService;
        this.userLocaleService = userLocaleService;
        this.messageSource = messageSource;
    }

    public void startExam() {

        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Please choose the language!\n" +
                "Выберите язык!\n" +
                "EN or RU");

        String userLocale = inputScanner.nextLine();
        Locale locale = userLocaleService.getUserLocale(userLocale);
        locale.setDefault(locale);
        List<Question> questionList = questionService.getAll(locale);
        Map<String, String> personAnswerMap = new HashMap<>();
        System.out.println(messageSource.getMessage("name", new String[]{}, locale));
        String name = inputScanner.nextLine();
        System.out.println(messageSource.getMessage("greeting", new String[]{name}, locale));
        for (Question question :
                questionList) {
            System.out.println(question.getQuestion());
            String personAnswer = inputScanner.nextLine();
            personAnswerMap.put(question.getId(), personAnswer);
        }

        int count = questionService.countCorrectAnswer(personAnswerMap);

        System.out.println(messageSource.getMessage("result", new Integer[]{count},
                Arrays.toString(new Integer[]{questionList.size()}), locale));


    }
}

