package com.mukesh.bowling.controller;

import com.mukesh.bowling.models.EntryRequest;
import com.mukesh.bowling.models.GenericResponse;
import com.mukesh.bowling.models.WinnerResponse;
import com.mukesh.bowling.service.BowlingService;
import com.mukesh.bowling.validator.GenericValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BowlingController {

    @Autowired@Qualifier("bowlingService")
    BowlingService bowlingService;

    @Autowired
    GenericValidator genericValidator;

    @RequestMapping(value = "/startthegame", method = RequestMethod.POST)
    ResponseEntity<GenericResponse<WinnerResponse>> getWinner (@RequestBody EntryRequest req) throws Exception {

        if(null!=req){
            try {
                genericValidator.validate(req );
            } catch (Exception e){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
        }
        WinnerResponse winnerResponse = bowlingService.manageWinner(req);
        GenericResponse<WinnerResponse> response = new GenericResponse<>();
        response.setStstus("Success");
        response.setData(winnerResponse);
        return ResponseEntity.ok(response);
    }
}
