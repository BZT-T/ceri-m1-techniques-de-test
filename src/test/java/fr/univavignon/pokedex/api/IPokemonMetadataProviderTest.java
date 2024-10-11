package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonMetadataProviderTest {

    @Before
    public void Init() {
        PokemonMetadata pokemonMetadata = new PokemonMetadata(1,"YouLouLou",20,50,150);
        IPokemonMetadataProvider myMock_PokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
        try {
            Mockito.when(myMock_PokemonMetadataProvider.getPokemonMetadata(1)).thenReturn(pokemonMetadata);
        } catch (PokedexException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test() {
        // Créer un mock de IPokedexFactory


    }
}
