package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizMaker {

    public static void main(String[] args) {

        // listening to keyboard input
        Scanner scanner = new Scanner(System.in);

        //creating File instance to reference text file in Java using Scanner
        System.out.println("Enter the fully qualified name of the file to read in for quiz questions");
        String path = scanner.nextLine();
        File inputFile = new File(path);

        try (Scanner quizFile = new Scanner(inputFile)) {

            // Read through the input file, and make a list of questions and answers.
            List<QuizQuestions> quizQuestions = new ArrayList<QuizQuestions>();
            while (quizFile.hasNextLine()) {
                String line = quizFile.nextLine();
                QuizQuestions newQuiz = new QuizQuestions(line);
                quizQuestions.add(newQuiz);
            }

            // Run Quiz
            // variables needed for final answer
            int numberOfQuestionsAsked = 0;
            int numberOfCorrectAnswers = 0;

            // for loop to loop through quiz
            for (QuizQuestions quizQuestion : quizQuestions) {
                // while there are quiz questions to loop through...
                while (true) {
                    // display question
                    System.out.println(quizQuestion.getQuestion());

                    // display answers
                    for (int i = 0; i < 4; i++) {
                        System.out.println((i + 1) + ") " + quizQuestion.getAnswers()[i]);
                    }

                    // get answer from user
                    System.out.print("\nYour answer: ");
                    String userAnswer = scanner.nextLine();

                    // calculate answer
                    // if user doesn't put empty or an non-number
                    if ((!userAnswer.isEmpty()) && (userAnswer.matches("[1-4]"))) {
                        if (quizQuestion.isCorrectAnswer(userAnswer)) {
                            System.out.println("RIGHT!\n");
                            numberOfCorrectAnswers += 1;
                        } else {
                            System.out.println("WRONG!\n");
                        }
                        break;
                    }
                    System.out.println("Invalid answer! Please try again.");
                }
                numberOfQuestionsAsked += 1;
            }
            System.out.println("You got " + numberOfCorrectAnswers + " answer(s) correct out of the " + numberOfQuestionsAsked + " questions asked.");
        } catch (FileNotFoundException e) {
            System.out.println("Your file doesn't exist");
        }
    }

}
