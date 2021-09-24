package com.techelevator;

public class HomeworkAssignment {

    // set variables
    private int earnedMarks;
    private int possibleMarks;
    private String submitterName;

    // constructor
    public HomeworkAssignment(int possibleMarks, String submitterName) {
        this.submitterName = submitterName;
        this.possibleMarks = possibleMarks;
    }

    // getters & setters

    public int getEarnedMarks() {
        return this.earnedMarks;
    }

    public void setEarnedMarks(int earnedMarks) {
        this.earnedMarks = earnedMarks;
    }

    public int getPossibleMarks() {
        return this.possibleMarks;
    }

    public String getSubmitterName() {
        return this.submitterName;
    }

    public String getLetterGrade() {

        double decimalPercent = (double) earnedMarks / possibleMarks;
        int finalGrade = (int) (decimalPercent * 100);
        if (finalGrade >= 90) {
            return "A";
        } else if (finalGrade >= 80) {
            return "B";
        } else if (finalGrade >= 70) {
            return "C";
        } else if (finalGrade >= 60) {
            return "D";
        }
        return "F";
    }


}
