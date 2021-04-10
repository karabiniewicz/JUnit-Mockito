package s180009.repository;

import s180009.entity.Beer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class BeerRepository {

    private final Collection<Beer> collection = new ArrayList<>();

    public void delete(String name) {
        Beer beer = collection.stream()
                .filter(element -> element.getName().equals(name))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
        collection.remove(beer);
    }

    public void save(Beer beer) {
        Optional<Beer> any = collection.stream()
                .filter(element -> element.getName().equals(beer.getName()))
                .findAny();
        if (any.isEmpty()) {
            collection.add(beer);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Optional<Beer> get(String name) {
        return collection.stream()
                .filter(element -> element.getName().equals(name))
                .findAny();
    }
}

