package com.sahil.GuessGame.service;

import org.springframework.stereotype.Service;

import com.sahil.GuessGame.model.Game;

@Service
public class GameService {
    private Game game;

    public Game StartNewGame(){
        this.game=new Game();
        return game;
    }

    public Game getGame(){
        return game;
    }

    public String makeGuess(int guess){
        while(game.getAttempts()<10){
            game.increamentAttempts();
            if(guess==game.getRandomNumber()){
                game.setGuessed(true);
                if(game.getBestScore()>game.getAttempts()){
                    game.setBestScore(game.getAttempts()-1);
                }
                return "Congratulations! You guessed the correct number.";
            }else if(guess>game.getRandomNumber()){
                return "Too High!!!!!";
            }else{
                return "Too Low!!!!!!";
            }
        }
        game.setLost(true);
        return "You Lost";
    }
}
