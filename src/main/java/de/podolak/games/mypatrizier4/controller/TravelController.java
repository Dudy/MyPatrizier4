package de.podolak.games.mypatrizier4.controller;

import de.podolak.games.mypatrizier4.service.PlayerService;
import de.podolak.games.mypatrizier4.service.TravelService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/travel")
public class TravelController {

    private final TravelService travelService;
    private final PlayerService playerService;

    public TravelController(TravelService travelService, PlayerService playerService) {
        this.travelService = travelService;
        this.playerService = playerService;
    }

    @PostMapping
    public void travel(@RequestParam String playerName, @RequestParam String destinationCity) {
        // Implementierung der Reiselogik
    }
}
