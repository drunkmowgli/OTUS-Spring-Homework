package service;

import java.util.Map;

public class ExamServiceImpl implements ExamService {

    private final AnswerService answerService;

    public ExamServiceImpl(AnswerService answerService) {
        this.answerService = answerService;
    }

    public int countCorrectAnswer(Map<String, String> personAnswerMap) {

        int count = 0;

        for (Map.Entry<String, String> entry : personAnswerMap.entrySet()) {

            if (answerService.compareAnswer(entry.getKey(), entry.getValue())) {
                count++;
            }

        }

        return count;
    }

}
