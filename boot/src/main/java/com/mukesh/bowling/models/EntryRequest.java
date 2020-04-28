package com.mukesh.bowling.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EntryRequest {
    Integer noOfPlayer;
    Integer noOfSet;

    public Integer getNoOfPlayer() {
        return noOfPlayer;
    }

    public void setNoOfPlayer(Integer noOfPlayer) {
        this.noOfPlayer = noOfPlayer;
    }

    public Integer getNoOfSet() {
        return noOfSet;
    }

    public void setNoOfSet(Integer noOfSet) {
        this.noOfSet = noOfSet;
    }
}
