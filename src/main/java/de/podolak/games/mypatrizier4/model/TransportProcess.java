package de.podolak.games.mypatrizier4.model;

public class TransportProcess {

    private final City fromCity;
    private final City toCity;

    private int remainingRounds;

    public TransportProcess(City fromCity, City toCity, int remainingRounds) {
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.remainingRounds = remainingRounds;
    }

    public City getFromCity() {
        return fromCity;
    }

    public City getToCity() {
        return toCity;
    }

    public int getRemainingRounds() {
        return remainingRounds;
    }

    public void decrementRemainingRounds() {
        this.remainingRounds--;
    }
}

