import javax.swing.*;

public class cardObj {
    private String question, answer;
    cardObj(String q, String a){
        question = q;
        answer = a;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String q) {
        q = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String a) {
        a = answer;
    }
}
