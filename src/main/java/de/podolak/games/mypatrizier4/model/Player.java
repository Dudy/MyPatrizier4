package de.podolak.games.mypatrizier4.model;

import java.util.HashMap;
import java.util.Map;

public class Player {

    private final String name;
    private final Map<Good, Integer> inventory = new HashMap<>();
    private final TransportWagon transportWagon;

    private City location;
    private long capital;
    private TransportProcess transportProcess;

    public Player(String name, City location, long capital, TransportWagon transportWagon) {
        this.name = name;
        this.location = location;
        this.capital = capital;
        this.transportWagon = transportWagon;
    }

    public String getName() {
        return name;
    }

    public Map<Good, Integer> getInventory() {
        return inventory;
    }

    public TransportWagon getTransportWagon() {
        return transportWagon;
    }

    public City getLocation() {
        return location;
    }

    public void setLocation(City location) {
        this.location = location;
    }

    public long getCapital() {
        return capital;
    }

    public void setCapital(long capital) {
        this.capital = capital;
    }

    public TransportProcess getTransportProcess() {
        return transportProcess;
    }

    public void setTransportProcess(TransportProcess transportProcess) {
        this.transportProcess = transportProcess;
    }
}
