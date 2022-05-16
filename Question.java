public class Question {

    String question;
    String[] options;
    int answer;

    public Question(){}

    public Question(String question, String[] options, int answerInd) {
        this.question = question;
        this.options = options;
        this.answer = answerInd;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

}
