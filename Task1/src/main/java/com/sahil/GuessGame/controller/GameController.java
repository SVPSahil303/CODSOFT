package com.sahil.GuessGame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sahil.GuessGame.model.Game;
import com.sahil.GuessGame.service.GameService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class GameController {
   
    @Autowired
    private GameService gameService;

    @GetMapping("/")
    public String index(Model model){
        Game game = gameService.StartNewGame();
        model.addAttribute("game", game);
        return "index";
    }

    @PostMapping("/guess")
    public String postMethodName(@RequestParam int guess,Model model) {
        String message=gameService.makeGuess(guess);
        Game game = gameService.getGame();
        model.addAttribute("message", message);
        model.addAttribute("game", game);
        return "index";
    }
    
}
