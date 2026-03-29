
package model;

public abstract class AbstractQuestion {

    protected String questionText;
    protected String correctAnswer;
    protected int marks;

    public AbstractQuestion(String questionText, String correctAnswer, int marks) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.marks = marks;
    }

    public abstract void displayQuestion();
    public abstract boolean checkAnswer(String userAnswer);

    public int getMarks() {
        return marks;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }
}

