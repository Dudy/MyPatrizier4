package de.podolak.games.mypatrizier4.model;

public class Good {

    private final String name;
    private final double basePrice;

    public Good(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    public String getName() {
        return name;
    }

    public double getBasePrice() {
        return basePrice;
    }
}
