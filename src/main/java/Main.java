import domain.Question;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.PersonService;
import service.QuesstionService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        QuesstionService questionService = context.getBean(QuesstionService.class);
        List<Question> questionList = questionService.getAll();
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Привет, хочешь сыграть со мной в игру?");
        if (inputScanner.nextLine().equalsIgnoreCase("Да")) {
            System.out.println("Назови свое имя");
            String name = inputScanner.nextLine();
            PersonService personService = context.getBean(PersonService.class);
            System.out.println("Игра начинается... " + personService.getByName(name).getName());

            for (Question question :
                    questionList) {
                System.out.println(question.getQuestion());
                inputScanner.nextLine();
            }

        } else {
            System.out.println("Game Over");
        }

    }
}
