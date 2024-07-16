package com.sahil.GradeCalculator.service;

import org.springframework.stereotype.Service;

import com.sahil.GradeCalculator.model.MarksInput;
import com.sahil.GradeCalculator.model.MarksResult;

@Service
public class MarksService {

    public MarksResult calculateMarks(MarksInput input) {
        float totalMarks = 0;
        for (Float mark : input.getMarks()) {
            totalMarks += mark;
        }
        float average = totalMarks / input.getNumberOfSubjects();

        String grade;
        if (average > 90) {
            grade = "O Grade!";
        } else if (average > 80) {
            grade = "E Grade!";
        } else if (average > 70) {
            grade = "A Grade!";
        } else if (average > 60) {
            grade = "B Grade!";
        } else if (average > 50) {
            grade = "C Grade!";
        } else if (average > 40) {
            grade = "D Grade!";
        } else {
            grade = "F Grade!";
        }

        MarksResult result = new MarksResult();
        result.setTotalMarks(totalMarks);
        result.setAverage(average);
        result.setGrade(grade);

        return result;
    }
}

