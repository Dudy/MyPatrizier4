package de.podolak.games.mypatrizier4.controller;

import de.podolak.games.mypatrizier4.service.GameService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/nextRound")
    public void nextRound() {
        gameService.nextRound();
    }
}
