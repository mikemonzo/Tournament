package championship.model.base;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class Tournament<T extends ParticipantAbstract> {

    private List<T> participants;
    private SortedSet<Round<T>> rounds;

    public Tournament(){
        this.rounds = new TreeSet<>();
    }

    public Tournament(List<T> participants) {
        this();
        this.participants = participants;
    }

    public List<T> getParticipants() {
        return participants;
    }

    public void setParticipants(List<T> participants) {
        this.participants = participants;
    }

    public SortedSet<Round<T>> getRounds() {
        return rounds;
    }

    public void setRounds(SortedSet<Round<T>> rounds) {
        this.rounds = rounds;
    }

    private void viewRound(Round<T> round){
        System.out.println(String.format("Round Nº %d - %s",round.getNumber(), round.getTitle().toUpperCase()));
        System.out.println("=====================================");
        System.out.println();
        System.out.println("---- Matches ----");
        System.out.println();
        for (Match<T> match : round.getMatches()){
            System.out.print(String.format("J1: %s vs J2: %s", match.getParticipant1().getName(), match.getParticipant2().getName()));
            if (match.getWinner() != null){
                System.out.println(String.format(" Winner: %s",match.getWinner().getName()));
            }
            System.out.println();
        }
    }

    public void viewDataLastRound(){
        if (!rounds.isEmpty()){
            viewRound(rounds.last());
        } else {
            System.out.println("No rounds played yet.");
        }
    }

    public void viewDataAllRounds(){
        if (!rounds.isEmpty()){
            for (Round<T> round : rounds){
                viewRound(round);
            }
        } else {
            System.out.println("No rounds played yet.");
        }
    }

    @Override
    public String toString() {
        return "Tournament{" +
                "participants=" + participants +
                ", rounds=" + rounds +
                '}';
    }
}
