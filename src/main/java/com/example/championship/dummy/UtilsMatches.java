package com.example.championship.dummy;

import java.util.List;
import java.util.Random;

import com.example.championship.model.base.Match;
import com.example.championship.model.base.ParticipantAbstract;
import com.example.championship.model.base.Round;

public interface UtilsMatches {

    public static <T extends ParticipantAbstract> Match<T> simulateMatch(Match<T> match) {
        Random random = new Random();
        
        int score1 = random.nextInt(2);

        if(score1 == 0) {
            match.setWinner(match.getParticipant1());
            match.setLoser(match.getParticipant2());
        } else {
            match.setWinner(match.getParticipant2());
            match.setLoser(match.getParticipant1());
        }

        return match;
    }

    public static <T extends ParticipantAbstract> List<Match<T>> simulateRound(List<Match<T>> matches) {
        for (Match<T> match : matches) {
            simulateMatch(match);
        }
        return matches;
    }

    public static <T extends ParticipantAbstract> void setDataRound(Round<T> round){
        UtilsMatches.simulateRound(round.getMatches());
        
    }
}
