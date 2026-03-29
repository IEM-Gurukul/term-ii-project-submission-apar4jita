
package app;

import service.QuizEngine;
import ui.ConsoleUI;
import repository.QuestionRepository;
import repository.ResultRepository;
import exception.ResourceLoadException;
import java.util.List;
import model.AbstractQuestion;

public class QuizApplication {
    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("     Welcome to QuizMaster Pro");
        System.out.println("======================================");

        try {
            QuestionRepository questionRepo = new QuestionRepository();

            List<AbstractQuestion> questions = questionRepo.loadQuestions(
                new java.io.File("src/resources/questions.txt").getAbsolutePath()
            );

            if (questions.isEmpty()) {
                System.out.println("No questions found. Exiting...");
                return;
            }

            QuizEngine engine = new QuizEngine(questions);
            ResultRepository resultRepo = new ResultRepository();
            ConsoleUI ui = new ConsoleUI(engine, resultRepo);
            ui.startQuiz();

        } catch (ResourceLoadException e) {
            System.out.println("Error loading resources: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error occurred: " + e.getMessage());
        }

        System.out.println("======================================");
        System.out.println("       Thank you for using QuizMaster Pro");
        System.out.println("======================================");
    }
}

