package com.mukesh.bowling.models;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class WinnerResponse {
    String winner;
    Integer topScore;
    String message;
    List<Player> scoreDetails;

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public Integer getTopScore() {
        return topScore;
    }

    public void setTopScore(Integer topScore) {
        this.topScore = topScore;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Player> getScoreDetails() {
        return scoreDetails;
    }

    public void setScoreDetails(List<Player> scoreDetails) {
        this.scoreDetails = scoreDetails;
    }
}
