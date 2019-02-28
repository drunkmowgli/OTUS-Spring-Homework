import domain.Answer;
import domain.Question;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.AnswerService;
import service.PersonService;
import service.QuesstionService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        QuesstionService questionService = context.getBean(QuesstionService.class);
        List<Question> questionList = questionService.getAll();
        AnswerService answerService = context.getBean(AnswerService.class);
        List<Answer> answerList = answerService.getAll();
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Привет, хочешь сыграть со мной в игру?");
        if (inputScanner.nextLine().equalsIgnoreCase("Да")) {
            System.out.println("Назови свое имя");
            String name = inputScanner.nextLine();
            PersonService personService = context.getBean(PersonService.class);
            System.out.println("Игра начинается... " + personService.getByName(name).getName());
            int count = 0;
            for (Question question :
                    questionList) {
                System.out.println(question.getQuestion());
                String personAnswer = inputScanner.nextLine();
                Answer correctAnswer = answerList.get(Integer.parseInt(question.getId()));

                if (answerService.compareAnswer(personAnswer, correctAnswer)) {
                    count = count + 1;
                }

            }

            System.out.println(String.format("Твой результат %s/%s", count, questionList.size()));

        } else {
            System.out.println("Game Over");
        }

    }
}
