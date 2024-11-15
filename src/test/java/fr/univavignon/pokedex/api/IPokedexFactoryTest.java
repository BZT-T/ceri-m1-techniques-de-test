package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

public class IPokedexFactoryTest {

    private IPokedexFactory pokedexFactory;
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;
    private Pokedex pokedexResult;
    private Pokemon bulbizarre;
    private Pokemon aquali;

    @Before
    public void setUp() {
        // Création de mocks
        metadataProvider = mock(IPokemonMetadataProvider.class);
        pokemonFactory = mock(IPokemonFactory.class);

        pokedexFactory = new PokedexFactory();
        pokedexResult = new Pokedex(metadataProvider, pokemonFactory);

        // Création de deux instances de Pokemon pour les tests
        bulbizarre = new Pokemon(0, "Bulbizarre", 126,126,90, 613,64, 4000,
                4, 56.0);

        aquali = new Pokemon(133,"Aquali",186,168, 260,2729,202, 5000,
                4,100.0);

        try {
            when(metadataProvider.getPokemonMetadata(133)).thenReturn(new PokemonMetadata(133, "Aquali", 186, 168, 260));
        } catch (PokedexException e) {
            throw new RuntimeException(e);
        }

        when(pokemonFactory.createPokemon(133,20,12, 12,99)).thenReturn(aquali);

    }

    @Test
    public void testCreatePokedex() {
        // Test de création d'un pokedex avec les mocks fournis
        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);

        assertNotNull(pokedex);
    }

    //On vérifie que le pokedex a le même comportement que le pokédex attendu

    @Test
    public void testCreatePokedexSameAsPokedexResult_AddPokemon_And_Result() {

        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);

        assertEquals(pokedex.addPokemon(bulbizarre), pokedexResult.addPokemon(bulbizarre));
        assertEquals(pokedex.addPokemon(aquali), pokedexResult.addPokemon(aquali));
        assertEquals(pokedex.size(), pokedexResult.size());

        try {
            assertEquals(pokedex.getPokemon(1), pokedexResult.getPokemon(1));
        } catch (PokedexException e) {
            throw new RuntimeException(e);
        }
        assertEquals(pokedex.getPokemons(), pokedexResult.getPokemons());

        try {
            assertEquals(pokedex.getPokemonMetadata(1), pokedexResult.getPokemonMetadata(1));
        } catch (PokedexException e) {
            throw new RuntimeException(e);
        }

        Pokemon bulbi1 = pokedex.createPokemon(133,20,12, 12,99);
        Pokemon bulbi2 = pokedexResult.createPokemon(133,20,12, 12,99);

        Assertions.assertEquals(bulbi1.getName(), bulbi2.getName());
        Assertions.assertEquals(bulbi1.getCp(), bulbi2.getCp());
        Assertions.assertEquals(bulbi1.getHp(), bulbi2.getHp());
        Assertions.assertEquals(bulbi1.getDust(), bulbi2.getDust());
        Assertions.assertEquals(bulbi1.getCandy(), bulbi2.getCandy());
    }
}
