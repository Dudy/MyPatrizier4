package de.podolak.games.mypatrizier4.model;

import java.util.Map;

public class City {

    private final String name;
    private final Market market;
    private final Map<Good, Integer> productionRates; // Produktionsrate pro Ware

    public City(String name, Market market, Map<Good, Integer> productionRates) {
        this.name = name;
        this.market = market;
        this.productionRates = productionRates;
    }

    public String getName() {
        return name;
    }

    public Market getMarket() {
        return market;
    }

    public Map<Good, Integer> getProductionRates() {
        return productionRates;
    }

    public void produceGoods() {
        productionRates.forEach(market::addGood);
    }
}
