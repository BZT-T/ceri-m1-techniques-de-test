package fr.univavignon.pokedex.api;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class IPokedexFactoryTest {

    @Test
    public void test() {
        // Créer un mock de IPokedexFactory
        IPokedexFactory myMock_PokedexFactory = mock(IPokedexFactory.class);
        IPokemonMetadataProvider myMock_PokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
        IPokemonFactory myMock_PokemonFactory = mock(IPokemonFactory.class);
        IPokedex myMock_Pokedex = mock(IPokedex.class);

        myMock_Pokedex = myMock_PokedexFactory.createPokedex(myMock_PokemonMetadataProvider, myMock_PokemonFactory);

    }
}
