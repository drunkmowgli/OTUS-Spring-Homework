import org.asm.labs.domain.Question;
import org.asm.labs.service.QuestionService;
import org.asm.labs.service.UserLocaleService;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
@ComponentScan(basePackages = "org.asm.labs")
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Main.class);
        context.refresh();
        QuestionService questionService = context.getBean(QuestionService.class);
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Please, choose the language!\n" +
                "Выберите язык!\n" +
                "EN or RU");
        UserLocaleService userLocaleService = context.getBean(UserLocaleService.class);
        String userLocale = inputScanner.nextLine();
        Locale locale = userLocaleService.getUserLocale(userLocale);
        locale.setDefault(locale);
        List<Question> questionList = questionService.getAll(locale);
        Map<String, String> personAnswerMap = new HashMap<>();
        MessageSource messageSource = context.getBean(MessageSource.class);
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

//        System.out.println(String.format("Твой результат %s/%s", count, questionList.size()));
        System.out.println(messageSource.getMessage("result", new Integer[]{count}, Arrays.toString(new Integer[]{questionList.size()}), locale));

    }

}
