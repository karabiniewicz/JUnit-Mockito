package s180009.repository;

import s180009.entity.Beer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BeerRepository {

    private final List<Beer> beers = new ArrayList<>();

    public void delete(String name) {
        Beer beer = beers.stream()
                .filter(element -> element.getName().equals(name))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
        beers.remove(beer);
    }

    public void add(Beer beer) {
        Optional<Beer> any = beers.stream()
                .filter(element -> element.getName().equals(beer.getName()))
                .findAny();
        if (any.isEmpty()) {
            beers.add(beer);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Optional<Beer> get(String name) {
        return beers.stream()
                .filter(element -> element.getName().equals(name))
                .findAny();
    }
}

