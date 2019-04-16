package org.asm.labs;

import org.asm.labs.config.YamlProperties;
import org.asm.labs.service.Exam;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties(YamlProperties.class)
public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Main.class, args);
        Exam exam = applicationContext.getBean(Exam.class);
        exam.startExam();
    }

}
