package s180009.repository;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import s180009.entity.Beer;

import java.util.Optional;

public class BeerBaseTest {

    @Test(expected = IllegalArgumentException.class)
    public void delete_objectNotExist_IllegalArgumentException() {
        BeerBase beerBase = new BeerBase();
        beerBase.delete("Nie ma takiego piwa");
    }

    @Test
    public void get_objectNotExist_emptyOptional() {
        BeerBase beerBase = new BeerBase();
        Optional<Beer> optionalBeer = beerBase.find("Nie ma takiego elementu");
        Assertions.assertThat(optionalBeer).isEmpty();
    }

    @Test
    public void get_objectExist_optionalObject() {
        BeerBase beerBase = new BeerBase();
        beerBase.save(Beer.builder().name("Specjal").percent(4.0f).build());
        Optional<Beer> beerOptional = beerBase.find("Specjal");
        Assertions.assertThat(beerOptional).isNotEmpty();
    }

    @Test(expected = IllegalArgumentException.class)
    public void add_objectAlreadyExist_IllegalArgumentException() {
        BeerBase beerBase = new BeerBase();
        beerBase.save(Beer.builder().name("Specjal").percent(4.0f).build());
        beerBase.save(Beer.builder().name("Specjal").percent(4.0f).build());
    }
}
