package com.sahil.GradeCalculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sahil.GradeCalculator.model.MarksInput;
import com.sahil.GradeCalculator.model.MarksResult;
import com.sahil.GradeCalculator.service.MarksService;

@Controller
public class MarksController {

    @Autowired
    private MarksService marksService;
    

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("marksInput", new MarksInput());
        return "index";
    }

    @PostMapping("/calculate")
    public String calculate(@ModelAttribute MarksInput marksInput, Model model) {
        MarksResult result = marksService.calculateMarks(marksInput);
        model.addAttribute("result", result);
        return "result";
    }
}

