package org.asm.labs.dao;

import org.asm.labs.config.YamlProperties;
import org.asm.labs.domain.Answer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.yml")
@EnableConfigurationProperties(YamlProperties.class)
public class AnswerDaoImplTest {

    @Autowired
    YamlProperties yamlProperties;

    @Autowired
    AnswerDao answerDao;

    @Test
    public void getAll() {
        List<Answer> answerList = answerDao.getAll();
        assertEquals(2, answerList.size());
        assertEquals("0", answerList.get(0).getId());
        assertEquals("988", answerList.get(0).getAnswer());
    }
}