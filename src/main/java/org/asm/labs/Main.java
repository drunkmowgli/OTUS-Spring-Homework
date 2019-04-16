package org.asm.labs;

import org.asm.labs.config.YamlFileProps;
import org.asm.labs.service.Exam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties(YamlFileProps.class)
public class Main {

    @Autowired
    private static ApplicationContext context;

    public static void main(String[] args) {
        context = SpringApplication.run(Main.class, args);
        Exam exam = context.getBean(Exam.class);
        exam.startExam();
    }

}
