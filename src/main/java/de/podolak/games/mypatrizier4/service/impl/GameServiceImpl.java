package de.podolak.games.mypatrizier4.service.impl;

import de.podolak.games.mypatrizier4.model.City;
import de.podolak.games.mypatrizier4.model.GameEngine;
import de.podolak.games.mypatrizier4.repository.CityRepository;
import de.podolak.games.mypatrizier4.repository.GameRepository;
import de.podolak.games.mypatrizier4.repository.PlayerRepository;
import de.podolak.games.mypatrizier4.service.GameService;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final CityRepository cityRepository;
    private final PlayerRepository playerRepository;
    private final GameEngine gameEngine;

    public GameServiceImpl(GameRepository gameRepository,
                           CityRepository cityRepository,
                           PlayerRepository playerRepository,
                           GameEngine gameEngine) {
        this.gameRepository = gameRepository;
        this.cityRepository = cityRepository;
        this.playerRepository = playerRepository;
        this.gameEngine = gameEngine;
    }

    @Override
    public void nextRound() {
        gameEngine.nextRound();
    }

    @Override
    public void initializeGame() {
        // Städte, Waren und Spieler initialisieren
    }

    @Override
    public void processAIPlayers() {
        // KI-Spieler verarbeiten
    }

    @Override
    public City getCityByName(String cityName) {
        City city = cityRepository.getCity(cityName);
        if (city == null) {
            throw new IllegalArgumentException("Stadt nicht gefunden: " + cityName);
        }
        return city;
    }
}
