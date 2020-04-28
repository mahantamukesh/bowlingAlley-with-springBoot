package com.mukesh.bowling.service;


import com.mukesh.bowling.models.EntryRequest;
import com.mukesh.bowling.models.WinnerResponse;
import org.springframework.stereotype.Service;

@Service("bowlingService")
public interface BowlingService {
    public WinnerResponse manageWinner(EntryRequest players);
}
