package championship.model.base;

public class Match<T extends ParticipantAbstract> {

    private T participant1;
    private T participant2;
    private T winner;
    private T loser;

    public Match() {
    }

    public Match(T participant1, T participant2) {
        this.participant1 = participant1;
        this.participant2 = participant2;
    }

    public Match(T participant1, T participant2, T winner, T loser) {
        this.participant1 = participant1;
        this.participant2 = participant2;
        this.winner = winner;
        this.loser = loser;
    }

    public T getParticipant1() {
        return participant1;
    }

    public void setParticipant1(T participant1) {
        this.participant1 = participant1;
    }

    public T getParticipant2() {
        return participant2;
    }

    public void setParticipant2(T participant2) {
        this.participant2 = participant2;
    }

    public T getWinner() {
        return winner;
    }

    public void setWinner(T winner) {
        this.winner = winner;
    }

    public T getLoser() {
        return loser;
    }

    public void setLoser(T loser) {
        this.loser = loser;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((participant1 == null) ? 0 : participant1.hashCode());
        result = prime * result + ((participant2 == null) ? 0 : participant2.hashCode());
        result = prime * result + ((winner == null) ? 0 : winner.hashCode());
        result = prime * result + ((loser == null) ? 0 : loser.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Match<?> other = (Match<?>) obj;
        if (participant1 == null) {
            if (other.participant1 != null)
                return false;
        } else if (!participant1.equals(other.participant1))
            return false;
        if (participant2 == null) {
            if (other.participant2 != null)
                return false;
        } else if (!participant2.equals(other.participant2))
            return false;
        if (winner == null) {
            if (other.winner != null)
                return false;
        } else if (!winner.equals(other.winner))
            return false;
        if (loser == null) {
            if (other.loser != null)
                return false;
        } else if (!loser.equals(other.loser))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Match [participant1=" + participant1 + ", participant2=" + participant2 + ", winner=" + winner + ", loser="
                + loser + "]";
    }
}
