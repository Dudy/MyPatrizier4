package de.podolak.games.mypatrizier4.service.impl;

import de.podolak.games.mypatrizier4.model.*;
import de.podolak.games.mypatrizier4.service.MarketService;
import org.springframework.stereotype.Service;

@Service
public class MarketServiceImpl implements MarketService {

    @Override
    public void buyGoods(Player player, Good good, int quantity) {
        City city = player.getLocation();
        Market market = city.getMarket();

        // Verfügbare Menge prüfen
        int availableQuantity = market.getAvailableGoods().getOrDefault(good, 0);
        if (availableQuantity < quantity) {
            throw new IllegalArgumentException("Nicht genügend Waren auf dem Markt verfügbar.");
        }

        // Preis berechnen
        long pricePerUnit = market.getPrices().get(good);
        long totalPrice = pricePerUnit * quantity;

        // Kapital des Spielers prüfen
        if (player.getCapital() < totalPrice) {
            throw new IllegalArgumentException("Nicht genügend Kapital.");
        }

        // Kapazität des Transportwagens prüfen
        int newLoad = player.getTransportWagon().getCurrentLoad() + quantity;
        if (newLoad > player.getTransportWagon().getCapacity()) {
            throw new IllegalArgumentException("Nicht genügend Kapazität im Transportwagen.");
        }

        // Transaktion durchführen
        player.setCapital(player.getCapital() - totalPrice);
        player.getInventory().put(good, player.getInventory().getOrDefault(good, 0) + quantity);
        player.getTransportWagon().setCurrentLoad(newLoad);
        market.getAvailableGoods().put(good, availableQuantity - quantity);

        // Preise anpassen
        market.adjustPrices(good);
    }

    @Override
    public void sellGoods(Player player, Good good, int quantity) {
        City city = player.getLocation();
        Market market = city.getMarket();

        // Besitzmenge prüfen
        int playerQuantity = player.getInventory().getOrDefault(good, 0);
        if (playerQuantity < quantity) {
            throw new IllegalArgumentException("Sie besitzen nicht genügend Waren.");
        }

        // Preis berechnen
        long pricePerUnit = market.getPrices().get(good);
        long totalPrice = pricePerUnit * quantity;

        // Transaktion durchführen
        player.setCapital(player.getCapital() + totalPrice);
        player.getInventory().put(good, playerQuantity - quantity);
        int newLoad = player.getTransportWagon().getCurrentLoad() - quantity;
        player.getTransportWagon().setCurrentLoad(newLoad);
        market.getAvailableGoods().put(good, market.getAvailableGoods().getOrDefault(good, 0) + quantity);

        // Preise anpassen
        market.adjustPrices(good);
    }

    @Override
    public Market getMarketInfo(City city) {
        return city.getMarket();
    }
}
