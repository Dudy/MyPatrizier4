package de.podolak.games.mypatrizier4.model;

public class TransportWagon {

    private final int capacity;

    private int currentLoad;

    public TransportWagon(int capacity) {
        this.capacity = capacity;
        this.currentLoad = 0;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCurrentLoad() {
        return currentLoad;
    }

    public void setCurrentLoad(int currentLoad) {
        this.currentLoad = currentLoad;
    }

    public void loadGoods(int quantity) {
        this.currentLoad += quantity;
    }

    public void unloadGoods(int quantity) {
        this.currentLoad -= quantity;
    }
}
