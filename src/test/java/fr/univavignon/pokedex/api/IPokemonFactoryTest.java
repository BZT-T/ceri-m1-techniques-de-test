package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class IPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;
    private Pokemon bulbasaur;

    @Before
    public void setUp() {
        // Création d'un mock pour IPokemonFactory
        pokemonFactory = mock(IPokemonFactory.class);

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

        // Configuration du comportement du mock pour la méthode createPokemon
        when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(bulbasaur);
    }

    @Test
    public void testCreatePokemon() {
        // Vérifie la création d'un Pokémon Bulbizarre
        Pokemon createdBulbasaur = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertNotNull(createdBulbasaur);
        assertEquals(0, createdBulbasaur.getIndex());
        assertEquals("Bulbizarre", createdBulbasaur.getName());
        assertEquals(126, createdBulbasaur.getAttack());
        assertEquals(126, createdBulbasaur.getDefense());
        assertEquals(90, createdBulbasaur.getStamina());
        assertEquals(613, createdBulbasaur.getCp());
        assertEquals(64, createdBulbasaur.getHp());
        assertEquals(4000, createdBulbasaur.getDust());
        assertEquals(4, createdBulbasaur.getCandy());
        assertEquals(56.0, createdBulbasaur.getIv(), 0.0);

    }

    /*@Test(expected = IllegalArgumentException.class)
    public void testCreatePokemonWithInvalidIndexTooLow() {
        // Essaie de créer un Pokémon avec un index invalide (trop bas)
        pokemonFactory.createPokemon(-1, 613, 64, 4000, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreatePokemonWithInvalidIndexTooHigh() {
        // Essaie de créer un Pokémon avec un index invalide (trop haut)
        pokemonFactory.createPokemon(151, 613, 64, 4000, 4);
    }*/
}
