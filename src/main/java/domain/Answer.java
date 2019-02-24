package domain;

/***
 * The <code>Answer</code> class contains several useful class field
 * and methods. This class describe answer.
 *
 * @author Yuriy Maslov
 */
public class Answer {

    private final String answer;

    /**
     * Constructs an empty <tt>Answer</tt> with the answer.
     *
     * @param answer the name
     */
    public Answer(String answer) {
        this.answer = answer;
    }

    /**
     * Returns the value to which the specified answer.
     *
     * @return the answer
     */
    public String getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answer='" + answer + '\'' +
                '}';
    }
}
