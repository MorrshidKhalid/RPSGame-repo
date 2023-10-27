package com.company;

public class RoundInfo {

    short RoundNumber = 0;
    RPS Player1Choice,
        ComputerChoice;
    Players roundWinner;



    // default constructor receives nothing.
    public RoundInfo() {}



    // Getters:
    public short getRoundNumber() {
        return RoundNumber;
    }

    public RPS getPlayer1Choice() {
        return Player1Choice;
    }

    public RPS getComputerChoice() {
        return ComputerChoice;
    }

    public Players getRoundWinner() {
        return roundWinner;
    }


    // Setters:
    public void setRoundNumber(short roundNumber) {
        RoundNumber = roundNumber;
    }

    public void setPlayer1Choice(RPS player1Choice) {
        Player1Choice = player1Choice;
    }

    public void setComputerChoice(RPS computerChoice) {
        ComputerChoice = computerChoice;
    }

    public void setRoundWinner(Players roundWinner) {
        this.roundWinner = roundWinner;
    }


}
