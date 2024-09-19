package de.podolak.games.mypatrizier4.controller;

import de.podolak.games.mypatrizier4.model.Market;
import de.podolak.games.mypatrizier4.service.GameService;
import de.podolak.games.mypatrizier4.service.MarketService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/market")
public class MarketController {

    private final MarketService marketService;
    private final GameService gameService;

    public MarketController(MarketService marketService, GameService gameService) {
        this.marketService = marketService;
        this.gameService = gameService;
    }

    @GetMapping
    public Market getMarketInfo(@RequestParam String cityName) {
        return marketService.getMarketInfo(gameService.getCityByName(cityName));
    }

    @PostMapping("/buy")
    public void buyGoods(@RequestParam String playerName, @RequestParam String goodName, @RequestParam int quantity) {
        // Implementierung des Kaufprozesses
    }

    @PostMapping("/sell")
    public void sellGoods(@RequestParam String playerName, @RequestParam String goodName, @RequestParam int quantity) {
        // Implementierung des Verkaufsprozesses
    }
}
