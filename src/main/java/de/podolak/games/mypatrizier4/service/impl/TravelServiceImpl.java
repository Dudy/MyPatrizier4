package de.podolak.games.mypatrizier4.service.impl;

import de.podolak.games.mypatrizier4.model.City;
import de.podolak.games.mypatrizier4.model.Player;
import de.podolak.games.mypatrizier4.model.TransportProcess;
import de.podolak.games.mypatrizier4.service.TravelService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TravelServiceImpl implements TravelService {

    private Map<String, Map<String, Integer>> travelTimes = new HashMap<>();

    public TravelServiceImpl() {
        // Initialisierung der Reisezeiten zwischen den Städten
        // Beispiel: travelTimes.get("Berlin").get("Hamburg") = 2;
    }

    @Override
    public void travel(Player player, City destination) {
        if (player.getTransportProcess() != null) {
            throw new IllegalStateException("Sie sind bereits auf Reisen.");
        }

        int travelTime = calculateTravelTime(player.getLocation(), destination);
        if (travelTime <= 0) {
            throw new IllegalArgumentException("Ungültige Reisezeit.");
        }

        TransportProcess transportProcess = new TransportProcess(player.getLocation(), destination, travelTime);
        player.setTransportProcess(transportProcess);
    }

    @Override
    public int calculateTravelTime(City from, City to) {
        return travelTimes.getOrDefault(from.getName(), new HashMap<>()).getOrDefault(to.getName(), -1);
    }
}
