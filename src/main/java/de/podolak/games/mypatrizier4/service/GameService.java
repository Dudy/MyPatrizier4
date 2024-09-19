package de.podolak.games.mypatrizier4.service;

import de.podolak.games.mypatrizier4.model.City;

public interface GameService {
    void nextRound();
    void initializeGame();
    void processAIPlayers();

    City getCityByName(String cityName);
}
