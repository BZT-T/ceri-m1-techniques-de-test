package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class IPokedexTest {

    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;
    private IPokedex pokedex;
    private Pokemon bulbizarre;
    private Pokemon aquali;

    @Before
    public void setUp() throws PokedexException {
        // Création des mocks
        metadataProvider = mock(IPokemonMetadataProvider.class);
        pokemonFactory = mock(IPokemonFactory.class);

        pokedex = new Pokedex(metadataProvider,pokemonFactory);

        // Création de deux instances de Pokemon pour les tests
        bulbizarre = new Pokemon(0, "Bulbizarre", 126,126,90, 613,64, 4000,
                4, 56.0);

        aquali = new Pokemon(133,"Aquali",186,168, 260,2729,202, 5000,
                4,100.0);

        // Configuration du comportement des méthodes du mock
        try {
            when(metadataProvider.getPokemonMetadata(0)).thenReturn(new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
            when(metadataProvider.getPokemonMetadata(133)).thenReturn(new PokemonMetadata(133, "Aquali", 186, 168, 260));
        } catch (PokedexException e) {
            throw new RuntimeException(e);
        }


        pokedex.addPokemon(bulbizarre);
        pokedex.addPokemon(aquali);

        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(bulbizarre);
        pokemons.add(aquali);
    }

    @Test
    public void testSize() {
        // Vérifie que la taille du pokédex est correcte
        assertEquals(2, pokedex.size());
    }

    @Test
    public void testAddPokemon() {
        // Vérifie l'ajout des Pokémon dans le pokédex
        Pokedex pokedex2 = new Pokedex(metadataProvider,pokemonFactory);
        int bulbizarreIndex = pokedex2.addPokemon(bulbizarre);
        int aqualiIndex = pokedex2.addPokemon(aquali);

        assertEquals(0, bulbizarreIndex);
        assertEquals(1, aqualiIndex);
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        // Vérifie la récupération d'un Pokémon par son index
        Pokemon retrievedBulbizarre = pokedex.getPokemon(0);
        Pokemon retrievedAquali = pokedex.getPokemon(1);

        assertEquals(bulbizarre, retrievedBulbizarre);
        assertEquals(aquali, retrievedAquali);

        // Vérifie qu'une exception est levée pour un index invalide
        assertThrows(PokedexException.class, () -> pokedex.getPokemon(151));
        assertThrows(PokedexException.class, () -> pokedex.getPokemon(-1));
    }

    @Test
    public void testGetPokemons() {
        // Vérifie la récupération de la liste des Pokémon
        List<Pokemon> pokemons = pokedex.getPokemons();
        assertEquals(2, pokemons.size());
        assertTrue(pokemons.contains(bulbizarre));
        assertTrue(pokemons.contains(aquali));
    }

    @Test
    public void testGetPokemonsWithComparator() {
        // Vérifie la récupération de la liste des Pokémon avec un comparateur
        List<Pokemon> sortedPokemons = pokedex.getPokemons(Comparator.comparing(Pokemon::getCp));
        assertEquals(2, sortedPokemons.size());
        assertTrue(sortedPokemons.contains(bulbizarre));
        assertTrue(sortedPokemons.contains(aquali));
    }
}
