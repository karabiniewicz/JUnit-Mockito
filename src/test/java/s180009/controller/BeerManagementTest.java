package s180009.controller;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import s180009.entity.Beer;
import s180009.repository.BeerBase;

import java.util.Optional;

import static org.mockito.Mockito.*;

public class BeerManagementTest {

    @Test
    public void delete_objectNotExist_notFound() {
        BeerBase beerBase = mock(BeerBase.class);
        BeerManagement beerManagement = new BeerManagement(beerBase);
        doThrow(new IllegalArgumentException()).when(beerBase).delete("Specjal");

        String s = beerManagement.delete("Specjal");

        Assertions.assertThat(s).isEqualTo("not found");
    }

    @Test
    public void delete_objectExist_done() {
        BeerBase beerBase = mock(BeerBase.class);
        BeerManagement beerManagement = new BeerManagement(beerBase);
        doNothing().when(beerBase).delete("Specjal");

        String s = beerManagement.delete("Specjal");

        Assertions.assertThat(s).isEqualTo("done");
    }

    @Test
    public void get_objectNotExist_notFound() {
        BeerBase beerBase = mock(BeerBase.class);
        BeerManagement beerManagement = new BeerManagement(beerBase);
        when(beerBase.find("Specjal")).thenReturn(Optional.empty());

        String s = beerManagement.find("Specjal");

        Assertions.assertThat(s).isEqualTo("not found");
    }

    @Test
    public void get_objectExist_objectToString() {
        BeerBase beerBase = mock(BeerBase.class);
        BeerManagement beerManagement = new BeerManagement(beerBase);
        Beer beer = Beer.builder()
                .name("Specjal")
                .percent(4.0f)
                .build();
        when(beerBase.find("Specjal")).thenReturn(Optional.of(beer));

        String s = beerManagement.find("Specjal");

        Assertions.assertThat(s).isEqualTo(beer.toString());
    }

    @Test
    public void save_objectNotExist_done() {
        BeerBase beerBase = mock(BeerBase.class);
        BeerManagement beerManagement = new BeerManagement(beerBase);
        Beer beer = Beer.builder()
                .name("Specjal")
                .percent(4.0f)
                .build();
        doNothing().when(beerBase).save(beer);

        String s = beerManagement.save("Specjal", 4.0f);

        Assertions.assertThat(s).isEqualTo("done");
        verify(beerBase, times(1)).save(eq(beer));
    }

    @Test
    public void save_objectAlreadyExist_badRequest() {
        BeerBase beerBase = mock(BeerBase.class);
        BeerManagement beerManagement = new BeerManagement(beerBase);
        Beer beer = Beer.builder()
                .name("Specjal")
                .percent(4.0f)
                .build();
        doThrow(new IllegalArgumentException()).when(beerBase).save(beer);

        String s = beerManagement.save("Specjal", 4.0f);

        Assertions.assertThat(s).isEqualTo("bad request");
    }
}
