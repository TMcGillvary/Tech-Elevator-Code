package com.techelevator;

public class QuizQuestions {

    // instance variables
    private String question;
    private String[] answersArray;
    private String correctAnswer;

    // constructor
    public QuizQuestions(String line) {

        // make a new array to store the split string
        String[] quizArray = line.split("\\|");
        // quizArray will always be 5 length

        // questions is always in index 0
        this.question = quizArray[0];

        // answers will need to go in a separate string array from the question
        this.answersArray = new String[4];
        // string length for answers is always 4 due to 4 answers

        // starting loop at index 1 because index 0 is the question
        for (int i = 1; i < 5; i++) {
            String answer = quizArray[i];
            // add in the correct answer without the asterisk, otherwise add like normal
            if (answer.endsWith("*")) {
                answer = answer.substring(0, answer.length() - 1); // remove asterisk
                this.correctAnswer = Integer.toString(i); // convert int i back to string to assign to variable
            }
            answersArray[i - 1] = answer; // add to array in correct index positions
        }
    }


    // getters & setters
    public String getQuestion() {
        return this.question;
    }

    public String[] getAnswers() {
        return this.answersArray;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswers(String[] answers) {
        this.answersArray = answers;
    }

    // helper Methods
    public boolean isCorrectAnswer(String selectedAnswer) {
        return this.correctAnswer.equals(selectedAnswer);
    }

}
