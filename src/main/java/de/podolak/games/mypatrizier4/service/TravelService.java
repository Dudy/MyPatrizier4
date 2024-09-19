package de.podolak.games.mypatrizier4.service;

import de.podolak.games.mypatrizier4.model.City;
import de.podolak.games.mypatrizier4.model.Player;

public interface TravelService {
    void travel(Player player, City destination);
    int calculateTravelTime(City from, City to);
}
