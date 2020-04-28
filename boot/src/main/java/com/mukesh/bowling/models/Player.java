package com.mukesh.bowling.models;

import java.util.List;

public class Player {
    String playerNumber;
    List<Trial> trials;
    Integer totalScore;
    public List<Trial> getTrials() {
        return trials;
    }

    public void setTrials(List<Trial> trials) {
        this.trials = trials;
    }

    public String getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(String playerNumber) {
        this.playerNumber = playerNumber;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }
}
