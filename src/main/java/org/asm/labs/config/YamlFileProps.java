package org.asm.labs.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "files")
public class YamlFileProps {

    private String ruQuestions;

    private String enQuestions;

    private String answers;

    public String getRuQuestions() {
        return ruQuestions;
    }

    public String getEnQuestions() {
        return enQuestions;
    }

    public String getAnswers() {
        return answers;
    }


    public void setRuQuestions(String ruQuestions) {
        this.ruQuestions = ruQuestions;
    }

    public void setEnQuestions(String enQuestions) {
        this.enQuestions = enQuestions;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }
}
