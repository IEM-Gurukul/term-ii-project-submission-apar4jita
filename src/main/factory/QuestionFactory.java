
package factory;

import model.AbstractQuestion;
import model.MCQuestion;
import model.BooleanQuestion;

import java.util.Arrays;
import java.util.List;

public class QuestionFactory {

    public static AbstractQuestion createQuestion(String type, String questionText,
                                                  String options, String correctAnswer, int marks) {

        switch (type.toUpperCase()) {

            case "MCQ":
                List<String> optionList = Arrays.asList(options.split("\\|"));
                return new MCQuestion(questionText, optionList, correctAnswer, marks);

            case "BOOLEAN":
                return new BooleanQuestion(questionText, correctAnswer, marks);

            default:
                throw new IllegalArgumentException("Invalid Question Type: " + type);
        }
    }
}

