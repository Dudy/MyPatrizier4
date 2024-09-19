package de.podolak.games.mypatrizier4.repository;

import de.podolak.games.mypatrizier4.model.City;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CityRepository {

    private final Map<String, City> cities = new HashMap<>();

    public void addCity(City city) {
        cities.put(city.getName(), city);
    }

    public City getCity(String name) {
        return cities.get(name);
    }
}
