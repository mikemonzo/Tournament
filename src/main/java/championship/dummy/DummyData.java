package championship.dummy;

import java.util.ArrayList;
import java.util.List;

import com.github.javafaker.Faker;

import championship.model.base.ParticipantAbstract;
import championship.model.base.Round;
import championship.model.padel.PairPadel;
import championship.model.tenis.TenisPlayer;

public class DummyData {

    public static List<TenisPlayer> generateTenisPlayers(int numPlayers) {
        List<TenisPlayer> result = new ArrayList<>();
        Faker faker = new Faker();
        for (int i = 0; i < numPlayers; i++) {
            result.add(new TenisPlayer(faker.name().fullName()));
        }
        return result;
    }

    public static List<PairPadel> generatePairPadels(int numPlayers) {
        List<PairPadel> result = new ArrayList<>();
        Faker faker = new Faker();
        for (int i = 0; i < numPlayers; i++) {
            result.add(new PairPadel(faker.team().name(),faker.name().fullName(), faker.name().fullName()));
        }
        return result;
    }

    public static <T extends ParticipantAbstract> void setDataRound(Round<T> round){
        UtilsMatches.simulateRound(round.getMatches());
    }
}
