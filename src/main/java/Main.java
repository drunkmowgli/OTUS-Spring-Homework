import domain.Question;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        QuestionService questionService = context.getBean(QuestionService.class);
        List<Question> questionList = questionService.getAll();
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Привет, хочешь сыграть со мной в игру?");
        Map<String, String> personAnswerMap = new HashMap<>();
        if (inputScanner.nextLine().equalsIgnoreCase("Да")) {
            ExamService examService = context.getBean(ExamService.class);
            System.out.println("Назови свое имя");
            String name = inputScanner.nextLine();
            PersonService personService = context.getBean(PersonService.class);
            System.out.println("Игра начинается... " + personService.getByName(name).getName());
            for (Question question :
                    questionList) {
                System.out.println(question.getQuestion());
                String personAnswer = inputScanner.nextLine();
                personAnswerMap.put(question.getId(), personAnswer);
            }

            int count = examService.countCorrectAnswer(personAnswerMap);

            System.out.println(String.format("Твой результат %s/%s", count, questionList.size()));

        } else {
            System.out.println("Game Over");
        }

    }
}
