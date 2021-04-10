package s180009.controller;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import s180009.entity.Beer;
import s180009.repository.BeerRepository;

import java.util.Optional;

import static org.mockito.Mockito.*;

public class BeerControllerTest {

    @Test
    public void delete_objectNotExist_notFound() {
        BeerRepository beerRepository = mock(BeerRepository.class);
        BeerController beerController = new BeerController(beerRepository);
        doThrow( new IllegalArgumentException()).when(beerRepository).delete("Specjal");

        String s = beerController.delete("Specjal");

        Assertions.assertThat(s).isEqualTo("not found");
    }

    @Test
    public void delete_objectExist_done() {
        BeerRepository beerRepository = mock(BeerRepository.class);
        BeerController beerController = new BeerController(beerRepository);
        doNothing().when(beerRepository).delete("Specjal");

        String s = beerController.delete("Specjal");

        Assertions.assertThat(s).isEqualTo("done");
    }

    @Test
    public void get_objectNotExist_notFound() {
        BeerRepository beerRepository = mock(BeerRepository.class);
        BeerController beerController = new BeerController(beerRepository);
        when(beerRepository.get("Specjal")).thenReturn(Optional.empty());

        String s = beerController.find("Specjal");

        Assertions.assertThat(s).isEqualTo("not found");
    }

    @Test
    public void get_objectExist_objectToString() {
        BeerRepository beerRepository = mock(BeerRepository.class);
        BeerController beerController = new BeerController(beerRepository);
        Beer beer = Beer.builder()
                .name("Specjal")
                .price(5)
                .build();
        when(beerRepository.get("Specjal")).thenReturn(Optional.of(beer));

        String s = beerController.find("Specjal");

        Assertions.assertThat(s).isEqualTo(beer.toString());
    }

    @Test
    public void save_objectNotExist_done() {
        BeerRepository beerRepository = mock(BeerRepository.class);
        BeerController beerController = new BeerController(beerRepository);
        Beer beer = Beer.builder()
                .name("Specjal")
                .price(5)
                .build();
        doNothing().when(beerRepository).save(beer);

        String s = beerController.save("Specjal", 5);

        Assertions.assertThat(s).isEqualTo("done");
        verify(beerRepository, times(1)).save(eq(beer));
    }

    @Test
    public void save_objectAlreadyExist_badRequest() {
        BeerRepository beerRepository = mock(BeerRepository.class);
        BeerController beerController = new BeerController(beerRepository);
        Beer beer = Beer.builder()
                .name("Specjal")
                .price(5)
                .build();
        doThrow(new IllegalArgumentException()).when(beerRepository).save(beer);

        String s = beerController.save("Specjal", 5);

        Assertions.assertThat(s).isEqualTo("bad request");
    }
}
