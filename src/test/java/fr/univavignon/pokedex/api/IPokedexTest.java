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

    private IPokedex pokedex;
    private Pokemon bulbasaur;
    private Pokemon vaporeon;

    @Before
    public void setUp() throws PokedexException {
        // Création d'un mock pour IPokedex
        pokedex = mock(IPokedex.class);

        // Création de deux instances de Pokemon pour les tests
        bulbasaur = new Pokemon(
                0, // Index
                "Bulbizarre", // Nom
                126, // Attaque
                126, // Défense
                90, // Endurance
                613, // CP
                64, // HP
                4000, // Poussière d'étoile
                4, // Bonbons
                56.0 // IV
        );

        vaporeon = new Pokemon(
                133, // Index
                "Aquali", // Nom
                186, // Attaque
                168, // Défense
                260, // Endurance
                2729, // CP
                202, // HP
                5000, // Poussière d'étoile
                4, // Bonbons
                100.0 // IV
        );

        // Configuration du comportement des méthodes du mock
        when(pokedex.size()).thenReturn(2);
        when(pokedex.addPokemon(bulbasaur)).thenReturn(0);
        when(pokedex.addPokemon(vaporeon)).thenReturn(1);
        when(pokedex.getPokemon(0)).thenReturn(bulbasaur);
        when(pokedex.getPokemon(1)).thenReturn(vaporeon);
        when(pokedex.getPokemon(999)).thenThrow(new PokedexException("Invalid index"));

        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(bulbasaur);
        pokemons.add(vaporeon);

        when(pokedex.getPokemons()).thenReturn(Collections.unmodifiableList(pokemons));
        when(pokedex.getPokemons(any(Comparator.class))).thenReturn(Collections.unmodifiableList(pokemons));
    }

    @Test
    public void testSize() {
        // Vérifie que la taille du pokédex est correcte
        assertEquals(2, pokedex.size());
    }

    @Test
    public void testAddPokemon() {
        // Vérifie l'ajout des Pokémon dans le pokédex
        int bulbasaurIndex = pokedex.addPokemon(bulbasaur);
        int vaporeonIndex = pokedex.addPokemon(vaporeon);

        assertEquals(0, bulbasaurIndex);
        assertEquals(1, vaporeonIndex);
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        // Vérifie la récupération d'un Pokémon par son index
        Pokemon retrievedBulbasaur = pokedex.getPokemon(0);
        Pokemon retrievedVaporeon = pokedex.getPokemon(1);

        assertEquals(bulbasaur, retrievedBulbasaur);
        assertEquals(vaporeon, retrievedVaporeon);

        // Vérifie qu'une exception est levée pour un index invalide
        assertThrows(PokedexException.class, () -> pokedex.getPokemon(999));
    }

    @Test
    public void testGetPokemons() {
        // Vérifie la récupération de la liste des Pokémon
        List<Pokemon> pokemons = pokedex.getPokemons();
        assertEquals(2, pokemons.size());
        assertTrue(pokemons.contains(bulbasaur));
        assertTrue(pokemons.contains(vaporeon));
    }

    @Test
    public void testGetPokemonsWithComparator() {
        // Vérifie la récupération de la liste des Pokémon avec un comparateur
        List<Pokemon> sortedPokemons = pokedex.getPokemons(Comparator.comparing(Pokemon::getCp));
        assertEquals(2, sortedPokemons.size());
        assertTrue(sortedPokemons.contains(bulbasaur));
        assertTrue(sortedPokemons.contains(vaporeon));
    }

}
