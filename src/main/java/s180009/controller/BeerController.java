package s180009.controller;

import s180009.entity.Beer;
import s180009.repository.BeerRepository;

import java.util.Optional;

public class BeerController {

    private BeerRepository beerRepository;

    public BeerController(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    public String delete(String name) {
        try {
            beerRepository.delete(name);
            return "done";
        } catch (IllegalArgumentException e) {
            return "not found";
        }
    }

    public String get(String name) {
        Optional<Beer> beerOptional = beerRepository.get(name);
        if (beerOptional.isPresent()) {
            return beerOptional.get().toString();
        }
        else {
            return "not found";
        }
    }

    public String save(Beer beer) {
        try {
            beerRepository.add(beer);
            return "done";
        } catch (IllegalArgumentException e) {
            return "bad request";
        }
    }
}
