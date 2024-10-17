package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.matchers.Null;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class IPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;
    private IPokemonMetadataProvider pokemonMetaDataProvider;
    private PokemonMetadata pokemonMetadata;
    private Pokemon bulbasaur;

    @Before
    public void setUp() throws PokedexException {
        // Création d'un mock pour IPokemonFactory
        pokemonFactory = mock(IPokemonFactory.class);
        pokemonMetaDataProvider = mock(IPokemonMetadataProvider.class);

        pokemonMetadata = new PokemonMetadata(0,"Bulbizarre",117,117,81);

        bulbasaur = new Pokemon(0,"Bulbizarre", 126, 126, 90, 613,
                64, 4000,4,56.0);

        // Configuration du comportement du mock pour la méthode createPokemon
        when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(bulbasaur);
        when(pokemonFactory.createPokemon(-1, 613, 64, 4000, 4)).thenReturn(null);
        when(pokemonFactory.createPokemon(151, 613, 64, 4000, 4)).thenReturn(null);
        when(pokemonMetaDataProvider.getPokemonMetadata(0)).thenReturn(pokemonMetadata);
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

    @Test
    public void testCreatePokemonWithInvalidIndexTooLow() {
        // Essaie de créer un Pokémon avec un index invalide (trop bas)
        assertNull(pokemonFactory.createPokemon(-1, 613, 64, 4000, 4));
    }

    @Test
    public void testCreatePokemonWithInvalidIndexTooHigh() {
        // Essaie de créer un Pokémon avec un index invalide (trop haut)
        assertNull(pokemonFactory.createPokemon(151, 613, 64, 4000, 4));
    }

    @Test
    public void testPokemonMetaDataBetween0And15() {
        Pokemon createdBulbasaur = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);

        assertTrue("La valeur d'attaque bonus est supérieure à 15", (createdBulbasaur.getAttack() -pokemonMetadata.getAttack()) <= 15);
        assertTrue("La valeur de défense bonus est supérieure à 15", (createdBulbasaur.getDefense() - pokemonMetadata.getDefense()) <= 15);
        assertTrue("La valeur d'endurance bonus est supérieure à 15", (createdBulbasaur.getStamina() - pokemonMetadata.getStamina()) <= 15);

        assertTrue("La valeur d'attaque bonus est inférieur à 0", (createdBulbasaur.getAttack() - pokemonMetadata.getAttack()) >= 0);
        assertTrue("La valeur de défense bonus est inférieur à 0", (createdBulbasaur.getDefense() - pokemonMetadata.getDefense()) >= 0);
        assertTrue("La valeur d'endurance bonus est inférieur à 0", (createdBulbasaur.getStamina() - pokemonMetadata.getStamina()) >= 0);
    }

    @Test
    public void testPokemonMetaDataCoherent() {
        //Vérifie que le calcul des bonus est cohérent entre l'IV du pokemon et la stat de base de l'espèce
        Pokemon createdBulbasaur = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);

        int valeurBonus = (int) Math.ceil((createdBulbasaur.getIv() / 100) * 15);

        assertEquals(createdBulbasaur.getAttack(), pokemonMetadata.getAttack() + valeurBonus);
        assertEquals(createdBulbasaur.getDefense(), pokemonMetadata.getDefense() + valeurBonus);
        assertEquals(createdBulbasaur.getStamina(), pokemonMetadata.getStamina() + valeurBonus);
    }

}
