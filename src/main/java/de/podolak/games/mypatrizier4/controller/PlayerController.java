package de.podolak.games.mypatrizier4.controller;

import de.podolak.games.mypatrizier4.model.Player;
import de.podolak.games.mypatrizier4.service.PlayerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/player")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/status")
    public Player getPlayerStatus(@RequestParam String playerName) {
        return playerService.getPlayerByName(playerName);
    }
}
