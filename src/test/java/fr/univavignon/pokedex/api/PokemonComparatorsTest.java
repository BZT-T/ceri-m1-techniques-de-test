package fr.univavignon.pokedex.api;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class PokemonComparatorsTest {

    @Test
    public void testCompareByName() {
        Pokemon pikachu = new Pokemon(25, "Pikachu", 112, 96, 111, new PokemonAttributes(500, 60, 2000, 2, 80.0));
        Pokemon bulbizarre = new Pokemon(1, "Bulbizarre", 118, 118, 90, new PokemonAttributes(613, 64, 4000, 4, 56.0));
        Pokemon salameche = new Pokemon(4, "Salameche", 116, 96, 78, new PokemonAttributes(600, 55, 2500, 3, 66.0));

        List<Pokemon> pokemons = Arrays.asList(pikachu, bulbizarre, salameche);
        pokemons.sort(PokemonComparators.NAME);

        assertEquals("Bulbizarre", pokemons.get(0).getName());
        assertEquals("Pikachu", pokemons.get(1).getName());
        assertEquals("Salameche", pokemons.get(2).getName());
    }

    @Test
    public void testCompareByIndex() {
        Pokemon pikachu = new Pokemon(25, "Pikachu", 112, 96, 111, new PokemonAttributes(500, 60, 2000, 2, 80.0));
        Pokemon bulbizarre = new Pokemon(1, "Bulbizarre", 118, 118, 90, new PokemonAttributes(613, 64, 4000, 4, 56.0));
        Pokemon salameche = new Pokemon(4, "Salameche", 116, 96, 78, new PokemonAttributes(600, 55, 2500, 3, 66.0));

        List<Pokemon> pokemons = Arrays.asList(pikachu, bulbizarre, salameche);
        pokemons.sort(PokemonComparators.INDEX);

        assertEquals("Bulbizarre", pokemons.get(0).getName());
        assertEquals("Salameche", pokemons.get(1).getName());
        assertEquals("Pikachu", pokemons.get(2).getName());
    }

    @Test
    public void testCompareByCp() {
        Pokemon pikachu = new Pokemon(25, "Pikachu", 112, 96, 111, new PokemonAttributes(500, 60, 2000, 2, 80.0));
        Pokemon bulbizarre = new Pokemon(1, "Bulbizarre", 118, 118, 90, new PokemonAttributes(613, 64, 4000, 4, 56.0));
        Pokemon salameche = new Pokemon(4, "Salameche", 116, 96, 78, new PokemonAttributes(600, 55, 2500, 3, 66.0));

        List<Pokemon> pokemons = Arrays.asList(pikachu, bulbizarre, salameche);
        pokemons.sort(PokemonComparators.CP);

        assertEquals("Pikachu", pokemons.get(0).getName());
        assertEquals("Salameche", pokemons.get(1).getName());
        assertEquals("Bulbizarre", pokemons.get(2).getName());
    }
}
