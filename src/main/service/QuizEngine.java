
package service;

import model.AbstractQuestion;

import java.util.List;

public class QuizEngine {

    private List<AbstractQuestion> questions;

    public QuizEngine(List<AbstractQuestion> questions) {
        this.questions = questions;
    }

    public List<AbstractQuestion> getQuestions() {
        return questions;
    }

    public boolean evaluateAnswer(AbstractQuestion question, String userAnswer) {
        return question.checkAnswer(userAnswer);
    }

    public int calculateTotalMarks() {
        int total = 0;
        for (AbstractQuestion q : questions) {
            total += q.getMarks();
        }
        return total;
    }
}

