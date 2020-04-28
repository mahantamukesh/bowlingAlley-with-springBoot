package com.mukesh.bowling.validator;

import com.mukesh.bowling.models.EntryRequest;
import org.springframework.stereotype.Component;

@Component
public class GenericValidator {

    public void validate(EntryRequest req) throws Exception {

        if(req.getNoOfSet()!=null && (req.getNoOfSet()<1 || req.getNoOfSet()>10)){
            throw new Exception("Invalid no of Set");

        }
        if(req.getNoOfPlayer() !=null && (req.getNoOfPlayer()<2 || req.getNoOfPlayer()>20)){
            throw new Exception("Invalid number of Player");
        }

    }
}
