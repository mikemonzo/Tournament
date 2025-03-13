package championship.dummy;

import java.util.ArrayList;
import java.util.List;

import championship.model.padel.PairPadel;
import championship.model.tenis.TenisPlayer;
import com.github.javafaker.Faker;

public class DummyData {

    static List<TenisPlayer> generateTenisPlayers(int numPlayers) {
        List<TenisPlayer> result = new ArrayList<>();
        Faker faker = new Faker();
        for (int i = 0; i < numPlayers; i++) {
            result.add(new TenisPlayer(faker.name().fullName()));
        }
        return result;
    }

    static List<PairPadel> generatePairPadels(int numPlayers) {
        List<PairPadel> result = new ArrayList<>();
        Faker faker = new Faker();
        for (int i = 0; i < numPlayers; i++) {
            result.add(new PairPadel(faker.team().name(),faker.name().fullName(), faker.name().fullName()));
        }
        return result;
    }
}
