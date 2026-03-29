```java id="mcq001"
package model;

import java.util.List;

public class MCQuestion extends AbstractQuestion {

    private List<String> options;

    public MCQuestion(String questionText, List<String> options, String correctAnswer, int marks) {
        super(questionText, correctAnswer, marks);
        this.options = options;
    }

    @Override
    public void displayQuestion() {
        System.out.println(questionText);
        char optionLabel = 'A';

        for (String option : options) {
            System.out.println(optionLabel + ". " + option);
            optionLabel++;
        }
    }

    @Override
    public boolean checkAnswer(String userAnswer) {
        return userAnswer.equalsIgnoreCase(correctAnswer);
    }
}
```
