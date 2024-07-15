package com.sahil.GuessGame.model;

import org.springframework.stereotype.Component;

@Component
public class Game {
    private int randomNumber;
    private int attempts;
    private int bestScore;
    private final int maxAttempts=10;
    private boolean isguessed;
    private boolean isLost;

    public Game(){
        this.randomNumber=(int)(Math.random()*100)+1;
        this.attempts=1;
        this.bestScore=0;
        this.isLost=false;
        this.isguessed=false;
    }

    public int getRandomNumber(){
        return randomNumber;
    }

    public int getAttempts(){
        return attempts;
    }

    public void increamentAttempts(){
        this.attempts++;
    }

    public boolean isguessed(){
        return isguessed;
    }

    public boolean isLost(){
        return isLost;
    }

    public void setGuessed(boolean guessed){
        isguessed=guessed;
    }

    public void setLost(boolean lost){
        isLost=lost;
    }

    public int getMaxAttempts(){
        return maxAttempts;
    }

    public int getBestScore() {
        return bestScore;
    }

    public void setBestScore(int bestScore) {
        this.bestScore = bestScore;
    }
}
