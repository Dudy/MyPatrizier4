package de.podolak.games.mypatrizier4.model;

import java.util.List;

public class GameEngine {

    private final List<Player> players;
    private final List<AIPlayer> aiPlayers;
    private final List<City> cities;

    private int currentRound;

    public GameEngine(List<Player> players, List<AIPlayer> aiPlayers, List<City> cities) {
        this.currentRound = 1;
        this.players = players;
        this.aiPlayers = aiPlayers;
        this.cities = cities;
    }

    // Nächste Runde einleiten
    public void nextRound() {
        currentRound++;
        processProduction();
        updateMarkets();
        processTransport();
        processAIPlayers();
    }

    // Produktion verarbeiten
    private void processProduction() {
        for (City city : cities) {
            city.produceGoods();
        }
    }

    // Märkte aktualisieren
    private void updateMarkets() {
        // Preise anpassen
    }

    // Transportprozesse verarbeiten
    private void processTransport() {
        for (Player player : players) {
            if (player.getTransportProcess() != null) {
                player.getTransportProcess().decrementRemainingRounds();
                if (player.getTransportProcess().getRemainingRounds() <= 0) {
                    player.setLocation(player.getTransportProcess().getToCity());
                    player.setTransportProcess(null);
                }
            }
        }
    }

    // Aktionen der KI-Spieler
    private void processAIPlayers() {
        for (AIPlayer aiPlayer : aiPlayers) {
            // KI-Aktionen (noch zu implementieren)
        }
    }

    // Getter und Setter
    public int getCurrentRound() {
        return currentRound;
    }
}
