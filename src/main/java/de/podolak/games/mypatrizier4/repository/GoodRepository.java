package de.podolak.games.mypatrizier4.repository;

import de.podolak.games.mypatrizier4.model.Good;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class GoodRepository {

    private final Map<String, Good> goods = new HashMap<>();

    public void addGood(Good good) {
        goods.put(good.getName(), good);
    }

    public Good getGood(String name) {
        return goods.get(name);
    }
}
