package s180009.controller;

import s180009.entity.Beer;
import s180009.repository.BeerBase;

import java.util.Optional;

public class BeerManagement {

    private BeerBase beerBase;

    public BeerManagement(BeerBase beerBase) {
        this.beerBase = beerBase;
    }

    public String delete(String name) {
        try {
            beerBase.delete(name);
            return "done";
        } catch (IllegalArgumentException e) {
            return "not found";
        }
    }

    public String find(String name) {
        Optional<Beer> beerOptional = beerBase.find(name);
        if (beerOptional.isPresent()) {
            return beerOptional.get().toString();
        } else {
            return "not found";
        }
    }

    public String save(String name, float percent) {
        try {
            beerBase.save(Beer.builder().name(name).percent(percent).build());
            return "done";
        } catch (IllegalArgumentException e) {
            return "bad request";
        }
    }
}
