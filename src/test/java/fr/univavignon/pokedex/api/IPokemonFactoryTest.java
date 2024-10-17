package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class IPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;
    private PokemonMetadata pokemonMetadata;

    @Before
    public void setUp() throws PokedexException {
        // Création d'un mock pour IPokemonFactory
        pokemonFactory = mock(IPokemonFactory.class);
        IPokemonMetadataProvider pokemonMetaDataProvider = mock(IPokemonMetadataProvider.class);

        pokemonMetadata = new PokemonMetadata(0,"Bulbizarre",117,117,81);

        Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613,
                64, 4000, 4, 56.0);

        // Configuration du comportement du mock pour la méthode createPokemon
        when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(bulbizarre);
        when(pokemonFactory.createPokemon(-1, 613, 64, 4000, 4)).thenReturn(null);
        when(pokemonFactory.createPokemon(151, 613, 64, 4000, 4)).thenReturn(null);
        when(pokemonMetaDataProvider.getPokemonMetadata(0)).thenReturn(pokemonMetadata);
    }

    @Test
    public void testCreatePokemon() {
        // Vérifie la création d'un Pokémon Bulbizarre
        Pokemon createdBulbizarre = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertNotNull(createdBulbizarre);
        assertEquals(0, createdBulbizarre.getIndex());
        assertEquals("Bulbizarre", createdBulbizarre.getName());
        assertEquals(126, createdBulbizarre.getAttack());
        assertEquals(126, createdBulbizarre.getDefense());
        assertEquals(90, createdBulbizarre.getStamina());
        assertEquals(613, createdBulbizarre.getCp());
        assertEquals(64, createdBulbizarre.getHp());
        assertEquals(4000, createdBulbizarre.getDust());
        assertEquals(4, createdBulbizarre.getCandy());
        assertEquals(56.0, createdBulbizarre.getIv(), 0.0);

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
        Pokemon createdBulbizarre = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);

        assertTrue("La valeur d'attaque bonus est supérieure à 15", (createdBulbizarre.getAttack() -pokemonMetadata.getAttack()) <= 15);
        assertTrue("La valeur de défense bonus est supérieure à 15", (createdBulbizarre.getDefense() - pokemonMetadata.getDefense()) <= 15);
        assertTrue("La valeur d'endurance bonus est supérieure à 15", (createdBulbizarre.getStamina() - pokemonMetadata.getStamina()) <= 15);

        assertTrue("La valeur d'attaque bonus est inférieur à 0", (createdBulbizarre.getAttack() - pokemonMetadata.getAttack()) >= 0);
        assertTrue("La valeur de défense bonus est inférieur à 0", (createdBulbizarre.getDefense() - pokemonMetadata.getDefense()) >= 0);
        assertTrue("La valeur d'endurance bonus est inférieur à 0", (createdBulbizarre.getStamina() - pokemonMetadata.getStamina()) >= 0);
    }

    @Test
    public void testPokemonMetaDataCoherent() {
        //Vérifie que le calcul des bonus est cohérent entre l'IV du pokemon et la stat de base de l'espèce
        Pokemon createdBulbizarre = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);

        int valeurBonus = (int) Math.ceil((createdBulbizarre.getIv() / 100) * 15);

        assertEquals(createdBulbizarre.getAttack(), pokemonMetadata.getAttack() + valeurBonus);
        assertEquals(createdBulbizarre.getDefense(), pokemonMetadata.getDefense() + valeurBonus);
        assertEquals(createdBulbizarre.getStamina(), pokemonMetadata.getStamina() + valeurBonus);
    }

}
