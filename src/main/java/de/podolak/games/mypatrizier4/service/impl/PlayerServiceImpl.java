package de.podolak.games.mypatrizier4.service.impl;

import de.podolak.games.mypatrizier4.model.City;
import de.podolak.games.mypatrizier4.model.Good;
import de.podolak.games.mypatrizier4.model.Player;
import de.podolak.games.mypatrizier4.model.TransportWagon;
import de.podolak.games.mypatrizier4.repository.CityRepository;
import de.podolak.games.mypatrizier4.repository.GoodRepository;
import de.podolak.games.mypatrizier4.repository.PlayerRepository;
import de.podolak.games.mypatrizier4.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final CityRepository cityRepository;
    private final GoodRepository goodRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository,
                             CityRepository cityRepository,
                             GoodRepository goodRepository) {
        this.playerRepository = playerRepository;
        this.cityRepository = cityRepository;
        this.goodRepository = goodRepository;
    }

    @Override
    public Player getPlayerByName(String playerName) {
        Player player = playerRepository.getPlayer(playerName);
        if (player == null) {
            throw new IllegalArgumentException("Spieler nicht gefunden: " + playerName);
        }
        return player;
    }

    @Override
    public void createPlayer(String playerName, City startingCity, long startingCapital) {
        if (playerRepository.getPlayer(playerName) != null) {
            throw new IllegalArgumentException("Spielername bereits vergeben: " + playerName);
        }

        TransportWagon transportWagon = new TransportWagon(100); // Beispielkapazität
        Player player = new Player(playerName, startingCity, startingCapital, transportWagon);
        playerRepository.addPlayer(player);
    }

    @Override
    public void updatePlayer(Player player) {
        playerRepository.addPlayer(player); // Überschreibt den vorhandenen Spieler
    }

    @Override
    public Good getGoodByName(String goodName) {
        Good good = goodRepository.getGood(goodName);
        if (good == null) {
            throw new IllegalArgumentException("Ware nicht gefunden: " + goodName);
        }
        return good;
    }
}
