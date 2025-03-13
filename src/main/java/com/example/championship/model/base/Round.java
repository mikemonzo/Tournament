package com.example.championship.model.base;

import java.util.ArrayList;
import java.util.List;

public class Round<T extends ParticipantAbstract> implements Comparable<Round<T>> {

    private int number;
    private String title;
    private List<Match<T>> matches;
    private boolean isFinal;
    private boolean isFinished;
    private List<T> winners;

    public Round(int number, String title, List<Match<T>> matches, boolean isFinal) {
        this.number = number;
        this.title = title;
        this.matches = matches;
        this.isFinal = isFinal;
        this.winners = new ArrayList<>();
    }
    
    public int getNumber() {
        return this.number;
    }
    
    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public List<Match<T>> getMatches() {
        return this.matches;
    }
    
    public void setMatches(List<Match<T>> matches) {
        this.matches = matches;
    }
    
    public boolean isFinal() {
        return this.isFinal;
    }
    
    public void setFinal(boolean isFinal) {
        this.isFinal = isFinal;
    }

    public boolean finishRound() {
        this.isFinished = true;
        
        for (Match<T> match : matches) {
            this.isFinished &= (match.getWinner() != null);
        }
        if(this.isFinished) {
            extractWinners();
        }

        return this.isFinished;
    }

    public boolean isFinished() {
        return this.isFinished;
    }

    private void extractWinners() {
        for (Match<T> match : matches) {
            winners.add(match.getWinner());
        }
    }

    public List<T> getWinners() {
        if (this.isFinished) {
            return this.winners;
        }
        return null;
    }

    @Override
    public int compareTo(Round<T> o) {
        return Integer.compare(this.number, o.number);
    }
}
