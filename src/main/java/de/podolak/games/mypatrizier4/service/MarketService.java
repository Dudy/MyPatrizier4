package de.podolak.games.mypatrizier4.service;

import de.podolak.games.mypatrizier4.model.City;
import de.podolak.games.mypatrizier4.model.Good;
import de.podolak.games.mypatrizier4.model.Market;
import de.podolak.games.mypatrizier4.model.Player;

public interface MarketService {
    void buyGoods(Player player, Good good, int quantity);
    void sellGoods(Player player, Good good, int quantity);
    Market getMarketInfo(City city);
}
