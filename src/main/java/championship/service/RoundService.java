package championship.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import championship.model.base.Match;
import championship.model.base.ParticipantAbstract;
import championship.model.base.Round;
import championship.model.base.Tournament;

public class RoundService<T extends ParticipantAbstract> {
    
    private int roundsPlayed;
    private Tournament<T> tournament;
    private List<T> participants;
    private List<T> participantsDirectNextRound;
    
    public RoundService(){
        this.roundsPlayed = 0;
    }

    public RoundService(Tournament<T> tournament){
        this();
        this.tournament = tournament;
        this.participants = tournament.getParticipants();
        this.participantsDirectNextRound = new ArrayList<>();
    }
    
    public List<Match<T>> generateRound(List<T> participants) {
        
        List<T> copyList = new ArrayList<>(participants);
        Collections.shuffle(copyList);

        List<Match<T>> result = new ArrayList<>();
        for(int i = 0; i < copyList.size(); i+=2){
            result.add(new Match<>(copyList.get(i), copyList.get(i+1)));
        }
        return result;
    }

    private String getNameRound(int numRound, int numParticipants){
        return switch(numParticipants){
            case 2 -> "Final";
            case 4 -> "Semifinal";
            case 8 -> "Quarterfinals";
            case 16 -> "Round of 16";
            default -> "Round " + numRound;
        };
    }

    public Round<T> firstRound(){

        participantsDirectNextRound.clear();
        List<T> copyList = new ArrayList<>(participants);

        Random random = new Random();
        if (participants.size() % 2 != 0){
            int pos = random.nextInt(participants.size());
            T selected = copyList.remove(pos);
            participantsDirectNextRound.add(selected);
            
        }

        List<Match<T>> matches = generateRound(copyList);
        roundsPlayed++;
        Round<T> round = new Round<>(roundsPlayed, getNameRound(roundsPlayed, participants.size()), matches, false);
        tournament.getRounds().add(round);
        return round;
    }

    public Round<T> nextRound(){

        Round<T> roundLast = tournament.getRounds().last();
        if (roundLast.isFinal() || !roundLast.isFinished()){
            return null;
        }

        List<T> participants = roundLast.getWinners();
        participants.addAll(participantsDirectNextRound);
        participantsDirectNextRound.clear();

        Random random = new Random();
        if (participants.size() % 2 != 0){
            int pos = random.nextInt(participants.size());
            T selected = participants.remove(pos);
            participantsDirectNextRound.add(selected);
            
        }
        List<Match<T>> matches = generateRound(participants);
        roundsPlayed++;
        boolean isFinal = participants.size() == 2 && participantsDirectNextRound.isEmpty();
        
        Round<T> round = new Round<>(roundsPlayed, getNameRound(roundsPlayed, participants.size()), matches, isFinal);
        tournament.getRounds().add(round);
        return round;
    }

}
