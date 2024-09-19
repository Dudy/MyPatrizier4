package de.podolak.games.mypatrizier4.repository;

import de.podolak.games.mypatrizier4.model.Player;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PlayerRepository {

    private final Map<String, Player> players = new HashMap<>();

    public void addPlayer(Player player) {
        players.put(player.getName(), player);
    }

    public Player getPlayer(String name) {
        return players.get(name);
    }
}
