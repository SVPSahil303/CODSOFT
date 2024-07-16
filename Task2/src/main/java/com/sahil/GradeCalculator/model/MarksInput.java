package com.sahil.GradeCalculator.model;


import java.util.List;

public class MarksInput {
    private int numberOfSubjects;
    private List<Float> marks;

    // Getters and setters
    public int getNumberOfSubjects() {
        return numberOfSubjects;
    }

    public void setNumberOfSubjects(int numberOfSubjects) {
        this.numberOfSubjects = numberOfSubjects;
    }

    public List<Float> getMarks() {
        return marks;
    }

    public void setMarks(List<Float> marks) {
        this.marks = marks;
    }
}
