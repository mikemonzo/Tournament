package championship.model.padel;

import championship.model.base.ParticipantAbstract;

public class PairPadel extends ParticipantAbstract {

    private String player1Name, player2Name;

    public PairPadel() {
        super();
    }

    public PairPadel(String name) {
        super(name);
    }

    public PairPadel(String name, String player1Name, String player2Name) {
        super(name);
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    @Override
    public String getName() {
        return "%s (%s, %s)".formatted(super.getName(), player1Name, player2Name);
    }

    public String getPlayer1Name() {
        return player1Name;
    }

    public void setPlayer1Name(String player1Name) {
        this.player1Name = player1Name;
    }

    public String getPlayer2Name() {
        return player2Name;
    }

    public void setPlayer2Name(String player2Name) {
        this.player2Name = player2Name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((player1Name == null) ? 0 : player1Name.hashCode());
        result = prime * result + ((player2Name == null) ? 0 : player2Name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        PairPadel other = (PairPadel) obj;
        if (player1Name == null) {
            if (other.player1Name != null)
                return false;
        } else if (!player1Name.equals(other.player1Name))
            return false;
        if (player2Name == null) {
            if (other.player2Name != null)
                return false;
        } else if (!player2Name.equals(other.player2Name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PairPadel [player1Name=" + player1Name + ", player2Name=" + player2Name + "]";
    }

}
