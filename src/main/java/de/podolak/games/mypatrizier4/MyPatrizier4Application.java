package de.podolak.games.mypatrizier4;

import de.podolak.games.mypatrizier4.model.City;
import de.podolak.games.mypatrizier4.model.Good;
import de.podolak.games.mypatrizier4.model.Market;
import de.podolak.games.mypatrizier4.repository.CityRepository;
import de.podolak.games.mypatrizier4.repository.GoodRepository;
import de.podolak.games.mypatrizier4.repository.PlayerRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class MyPatrizier4Application {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private GoodRepository goodRepository;

    public static void main(String[] args) {
        SpringApplication.run(MyPatrizier4Application.class, args);
    }

    @PostConstruct
    public void init() {
        // Waren erstellen
        Good getreide = new Good("Getreide", 10);
        Good eisen = new Good("Eisen", 20);
        Good tuch = new Good("Tuch", 30);
        Good wein = new Good("Wein", 40);
        Good gewuerze = new Good("Gewürze", 50);

        // Waren zum Repository hinzufügen
        goodRepository.addGood(getreide);
        goodRepository.addGood(eisen);
        goodRepository.addGood(tuch);
        goodRepository.addGood(wein);
        goodRepository.addGood(gewuerze);

        // Städte erstellen und initialisieren
        createCities(getreide, eisen, tuch, wein, gewuerze);
    }

    private void createCities(Good getreide, Good eisen, Good tuch, Good wein, Good gewuerze) {
        // Beispielhafte Produktionsraten
        Map<Good, Integer> berlinProduction = new HashMap<>();
        berlinProduction.put(getreide, 1); // Gute Produktion
        berlinProduction.put(eisen, 1);    // Schlechte Produktion

        Market berlinMarket = new Market();
        City berlin = new City("Berlin", berlinMarket, berlinProduction);
        cityRepository.addCity(berlin);

        // Wiederholen für die anderen Städte...
        // Hamburg, München, Köln, Frankfurt am Main
    }
}
