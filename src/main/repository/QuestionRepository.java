```java id="repo001"
package repository;

import factory.QuestionFactory;
import model.AbstractQuestion;
import exception.ResourceLoadException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class QuestionRepository {

    public List<AbstractQuestion> loadQuestions(String filePath) throws ResourceLoadException {

        List<AbstractQuestion> questions = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

            while ((line = br.readLine()) != null) {

                // Format: type,question,options,answer,marks
                String[] parts = line.split(",");

                String type = parts[0];
                String questionText = parts[1];
                String options = parts[2];
                String answer = parts[3];
                int marks = Integer.parseInt(parts[4]);

                AbstractQuestion question =
                        QuestionFactory.createQuestion(type, questionText, options, answer, marks);

                questions.add(question);
            }

        } catch (Exception e) {
            throw new ResourceLoadException("Failed to load questions file.");
        }

        return questions;
    }
}
```
