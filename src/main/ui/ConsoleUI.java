
package ui;

import service.QuizEngine;
import repository.ResultRepository;
import model.AbstractQuestion;

import java.util.List;
import java.util.Scanner;

public class ConsoleUI {

    private QuizEngine engine;
    private ResultRepository resultRepo;
    private Scanner scanner;

    public ConsoleUI(QuizEngine engine, ResultRepository resultRepo) {
        this.engine = engine;
        this.resultRepo = resultRepo;
        this.scanner = new Scanner(System.in);
    }

    public void startQuiz() {

        System.out.print("Enter your name: ");
        String username = scanner.nextLine();

        System.out.println("\nStarting Quiz...\n");

        List<AbstractQuestion> questions = engine.getQuestions();

        int score = 0;

        for (AbstractQuestion q : questions) {

            q.displayQuestion();

            System.out.print("Your Answer: ");
            String userAnswer = scanner.nextLine();

            if (engine.evaluateAnswer(q, userAnswer)) {
                System.out.println("Correct!\n");
                score += q.getMarks();
            } else {
                System.out.println(" Wrong! Correct Answer: " + q.getCorrectAnswer() + "\n");
            }
        }

        System.out.println("Quiz Finished!");
        System.out.println("Your Score: " + score);

        // Save result
        resultRepo.saveResult(username, score);

        System.out.println("Result saved successfully!");
    }
}

