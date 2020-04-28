package com.mukesh.bowling.service;

import com.mukesh.bowling.models.EntryRequest;
import com.mukesh.bowling.models.Player;
import com.mukesh.bowling.models.Trial;
import com.mukesh.bowling.models.WinnerResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Component("bowlingService")
public class BowlingServiceImpl implements BowlingService {

    @Override
    public WinnerResponse manageWinner(EntryRequest entryRequest) {
        int numberOfPlayer = entryRequest.getNoOfPlayer();
        int numberOfSet = entryRequest.getNoOfSet();
        WinnerResponse winnerResponse = new WinnerResponse();
        List<Player> players = new ArrayList<>();

        for(int i=1;i<numberOfPlayer+1;i++){
            List<Trial> trials = new ArrayList<>();
            Player player = new Player();
            for(int set=1;set<numberOfSet+1;set++){
                Trial trial = calculateScore(set);
                trials.add(trial);
            }

            player.setPlayerNumber("Player "+i);
            player.setTrials(trials);
            player.setTotalScore(calculateTotalScore(player));
            players.add(player);
        }
        winnerResponse.setScoreDetails(players);
        decideWinner(winnerResponse);
        winnerResponse.setMessage("Winner Decided !!");
        return winnerResponse;

    }

    private void decideWinner(WinnerResponse winnerResponse){
        Integer maxTotalScore = 0;

        for(Player player: winnerResponse.getScoreDetails()){
            if(player.getTotalScore() >maxTotalScore){
                maxTotalScore = player.getTotalScore();
                winnerResponse.setWinner(player.getPlayerNumber());
                winnerResponse.setTopScore(player.getTotalScore());
            }
        }

    }
    private Integer calculateTotalScore(Player player){
        Integer totalScore = 0;
        for(Trial trial : player.getTrials()){
            totalScore = totalScore +trial.getStrike1Score() + trial.getStrike2Score() + trial.getBonus();
        }
        return totalScore;

    }

    private Trial calculateScore(int set){
        Trial trial = new Trial();
        int strike2 = 0;
        int strike1 = 0;

        //Strike1
        strike1 = ThreadLocalRandom.current().nextInt(0, 10 + 1);
        if(strike1 == 10){
            strike2 = ThreadLocalRandom.current().nextInt(0, 10 + 1);

        }else {
            strike2 = ThreadLocalRandom.current().nextInt(0, 10-strike1+1);
        }

        //
        if(strike1 == 10 && strike2 == 10){
            trial.setBonus(20);
        }else {
            if(strike1 == 10 || strike2 == 10){
                trial.setBonus(10);
            } else if(strike1+strike2==10){
                trial.setBonus(5);
            } else {
                trial.setBonus(0);
            }
        }

        trial.setStrike1(1);
        trial.setStrike1Score(strike1);
        trial.setStrike2(2);
        trial.setStrike2Score(strike2);

        return trial;
    }
}
