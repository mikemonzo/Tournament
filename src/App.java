import championship.dummy.DummyData;
import championship.model.base.Round;
import championship.model.base.Tournament;
import championship.model.padel.PairPadel;
import championship.model.tenis.TenisPlayer;
import championship.service.RoundService;

public class App {
    public static void main(String[] args) throws Exception {
        playTenisTournament();
        playPadelTournament();
    }

    public static void playTenisTournament(){
        Tournament<TenisPlayer> tournament = new Tournament<>();
        tournament.setParticipants(DummyData.generateTenisPlayers(8));

        RoundService<TenisPlayer> roundService = new RoundService<>(tournament);
        Round<TenisPlayer> round = roundService.firstRound();
        DummyData.setDataRound(round);
        round.finishRound();

        System.out.println("TENIS TOURNAMENT");
        System.out.println("=====================================");
        tournament.viewDataLastRound();

        while(!round.isFinal()){
            round = roundService.nextRound();
            DummyData.setDataRound(round);
            round.finishRound();
        }
    }

    public static void playPadelTournament(){
        Tournament<PairPadel> tournament = new Tournament<>();
        tournament.setParticipants(DummyData.generatePairPadels(8));

        RoundService<PairPadel> roundService = new RoundService<>(tournament);
        Round<PairPadel> round = roundService.firstRound();
        DummyData.setDataRound(round);
        round.finishRound();

        System.out.println("Padel TOURNAMENT");
        System.out.println("=====================================");
        tournament.viewDataLastRound();

        while(!round.isFinal()){
            round = roundService.nextRound();
            DummyData.setDataRound(round);
            round.finishRound();
        }
    }
}
