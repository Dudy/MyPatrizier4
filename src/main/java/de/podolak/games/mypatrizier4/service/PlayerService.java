package de.podolak.games.mypatrizier4.service;

import de.podolak.games.mypatrizier4.model.City;
import de.podolak.games.mypatrizier4.model.Good;
import de.podolak.games.mypatrizier4.model.Player;

public interface PlayerService {
    Player getPlayerByName(String playerName);
    void createPlayer(String playerName, City startingCity, long startingCapital);
    void updatePlayer(Player player);
    Good getGoodByName(String goodName);
}
