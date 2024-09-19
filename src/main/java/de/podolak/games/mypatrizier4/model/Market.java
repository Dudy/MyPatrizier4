package de.podolak.games.mypatrizier4.model;

import java.util.HashMap;
import java.util.Map;

public class Market {

    private final Map<Good, Integer> availableGoods = new HashMap<>();
    private final Map<Good, Long> prices = new HashMap<>();

    public void addGood(Good good, int quantity) {
        availableGoods.put(good, availableGoods.getOrDefault(good, 0) + quantity);
        adjustPrices(good);
    }

    public void adjustPrices(Good good) {
        int supply = availableGoods.getOrDefault(good, 0);
        double demand = 100.0d; // Feste Nachfrage
        double priceFactor = demand / (supply + 1);
        long newPrice = Math.round(good.getBasePrice() * priceFactor);
        prices.put(good, newPrice);
    }

    public Map<Good, Integer> getAvailableGoods() {
        return availableGoods;
    }

    public Map<Good, Long> getPrices() {
        return prices;
    }
}
