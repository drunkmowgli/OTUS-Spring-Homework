package domain;

/***
 * The <code>Question</code> class contains several useful class field
 * and methods. This class describes question.
 *
 * @author Yuriy Maslov
 */
public class Question {

    private final String question;

    /**
     * Constructs an empty <tt>Question</tt> with the question.
     *
     * @param question the name
     */
    public Question(String question) {
        this.question = question;
    }

    /**
     * Returns the value to which the specified the question.
     *
     * @return the question
     */
    public String getQuestion() {
        return question;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                '}';
    }
}
