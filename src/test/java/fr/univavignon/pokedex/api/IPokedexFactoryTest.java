package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

public class IPokedexFactoryTest {

    private IPokedexFactory pokedexFactory;
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        // Création de mocks
        metadataProvider = mock(IPokemonMetadataProvider.class);
        pokemonFactory = mock(IPokemonFactory.class);
        pokedexFactory = mock(IPokedexFactory.class);

        // Configuration du comportement de la méthode createPokedex
        IPokedex mockPokedex = mock(IPokedex.class);
        when(pokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(mockPokedex);
    }

    @Test
    public void testCreatePokedex() {
        // Test de création d'un pokedex avec les mocks fournis
        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);

        assertNotNull(pokedex);
        verify(pokedexFactory).createPokedex(metadataProvider, pokemonFactory);
    }
}
