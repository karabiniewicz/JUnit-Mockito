package s180009.repository;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import s180009.entity.Beer;

import java.util.Optional;

public class RepositoryTest {

    @Test(expected = IllegalArgumentException.class)
    public void delete_objectNotExist_IllegalArgumentException() {
        BeerRepository beerRepository = new BeerRepository();
        beerRepository.delete("Nie ma takiego piwa");
    }

    @Test
    public void get_objectNotExist_emptyOptional() {
        BeerRepository beerRepository = new BeerRepository();
        Optional<Beer> optionalBeer = beerRepository.get("Nie ma takiego elementu");
        Assertions.assertThat(optionalBeer).isEmpty();
    }

    @Test
    public void get_objectExist_optionalObject() {
        BeerRepository beerRepository = new BeerRepository();
        beerRepository.save(Beer.builder().name("Specjal").price(4).build());
        Optional<Beer> beerOptional = beerRepository.get("Specjal");
        Assertions.assertThat(beerOptional).isNotEmpty();
    }

    @Test(expected = IllegalArgumentException.class)
    public void add_objectAlreadyExist_IllegalArgumentException() {
        BeerRepository beerRepository = new BeerRepository();
        beerRepository.save(Beer.builder().name("Specjal").price(4).build());
        beerRepository.save(Beer.builder().name("Specjal").price(6).build());
    }


}
