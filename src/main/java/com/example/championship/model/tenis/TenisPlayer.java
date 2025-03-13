package com.example.championship.model.tenis;

import com.example.championship.model.base.ParticipantAbstract;

public class TenisPlayer extends ParticipantAbstract{

    private int ranking;

    public TenisPlayer() {
        super();
        ranking = 0;
    }

    public TenisPlayer(String name) {
        super(name);
        ranking = 0;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ranking;
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
        TenisPlayer other = (TenisPlayer) obj;
        if (ranking != other.ranking)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "TenisPlayer [ranking=" + ranking + "]";
    }

}
