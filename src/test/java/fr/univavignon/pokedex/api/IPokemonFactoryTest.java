package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;
    private PokemonMetadata pokemonMetadata;

    @Before
    public void setUp() {
        // Création d'un PokemonFactory
        pokemonFactory = new PokemonFactory();

        pokemonMetadata = new PokemonMetadata(0,"Bulbizarre",126,126,90);
    }

    @Test
    public void testCreatePokemon() {
        // Vérifie la création d'un Pokémon Bulbizarre
        Pokemon createdBulbizarre = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertNotNull(createdBulbizarre);
        assertEquals(0, createdBulbizarre.getIndex());
        assertEquals("Bulbizarre", createdBulbizarre.getName());
        assertEquals(613, createdBulbizarre.getCp());
        assertEquals(64, createdBulbizarre.getHp());
        assertEquals(4000, createdBulbizarre.getDust());
        assertEquals(4, createdBulbizarre.getCandy());
    }

    @Test
    public void testCreatePokemonNull() {
        // Vérifie la création d'un Pokémon Bulbizarre
        Pokemon pokemonNull = pokemonFactory.createPokemon(-1, 613, 64, 4000, 4);
        assertNull(pokemonNull);
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

        assertTrue("La valeur d'attaque bonus est supérieure à 15", (createdBulbizarre.getAttack() - pokemonMetadata.getAttack()) <= 15);
        assertTrue("La valeur de défense bonus est supérieure à 15", (createdBulbizarre.getDefense() - pokemonMetadata.getDefense()) <= 15);
        assertTrue("La valeur d'endurance bonus est supérieure à 15", (createdBulbizarre.getStamina() - pokemonMetadata.getStamina()) <= 15);

        assertTrue("La valeur d'attaque bonus est inférieur à 0", (createdBulbizarre.getAttack() - pokemonMetadata.getAttack()) >= 0);
        assertTrue("La valeur de défense bonus est inférieur à 0", (createdBulbizarre.getDefense() - pokemonMetadata.getDefense()) >= 0);
        assertTrue("La valeur d'endurance bonus est inférieur à 0", (createdBulbizarre.getStamina() - pokemonMetadata.getStamina()) >= 0);

        assertTrue("La valeur de l'IV doit être entre 0 et 1", createdBulbizarre.getIv() >= 0 && createdBulbizarre.getIv() <= 1);

    }

    @Test
    public void testPokemonMetaDataCoherent() {
        //Vérifie que le calcul des bonus est cohérent entre l'IV du pokemon et la stat de base de l'espèce
        Pokemon createdBulbizarre = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);

        // Calculate actual stats for the individual Pokémon
        int attack = createdBulbizarre.getAttack() - pokemonMetadata.getAttack();
        int defense = createdBulbizarre.getDefense() - pokemonMetadata.getDefense();
        int stamina = createdBulbizarre.getStamina() - pokemonMetadata.getStamina();

        // Calculate IV as a percentage (average of individual stats)
        double iv = (attack + defense + stamina) / 45.0;

        assertEquals(iv, createdBulbizarre.getIv(),0);

    }

}
