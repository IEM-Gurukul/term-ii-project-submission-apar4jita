
package model;

public class BooleanQuestion extends AbstractQuestion {

    public BooleanQuestion(String questionText, String correctAnswer, int marks) {
        super(questionText, correctAnswer, marks);
    }

    
    public void displayQuestion() {
        System.out.println(questionText);
        System.out.println("A. True");
        System.out.println("B. False");
    }

    
    public boolean checkAnswer(String userAnswer) {
        return userAnswer.equalsIgnoreCase(correctAnswer);
    }
}

