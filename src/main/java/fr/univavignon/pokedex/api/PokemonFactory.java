package fr.univavignon.pokedex.api;

import java.util.Random;

/**
 * Implementation of the IPokemonFactory interface for creating Pokemon instances.
 * This class calculates the IV (Individual Value) based on the provided parameters.
 *
 */
public class PokemonFactory implements IPokemonFactory {
    private final Random random = new Random();
    /**
     * Creates a Pokemon instance with calculated IV based on given stats.
     *
     * @param index Index of the Pokemon.
     * @param cp Combat Points of the Pokemon.
     * @param hp Hit Points of the Pokemon.
     * @param dust Stardust needed to level up the Pokemon.
     * @param candy Candy needed to level up the Pokemon.
     * @return A new instance of Pokemon with calculated IV.
     */
    @Override
        public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {

        PokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        try {
            PokemonMetadata pokemonMetadata = metadataProvider.getPokemonMetadata(index);

            // Generate random individual stats (between 0 and 15)
            int individualAttack = random.nextInt(16);
            int individualDefense = random.nextInt(16);
            int individualStamina = random.nextInt(16);

            // Calculate actual stats for the individual Pokémon
            int attack = pokemonMetadata.getAttack() + individualAttack;
            int defense = pokemonMetadata.getDefense() + individualDefense;
            int stamina = pokemonMetadata.getStamina() + individualStamina;

            // Calculate IV as a percentage (average of individual stats)
            double iv = (individualAttack + individualDefense + individualStamina) / 45.0;

            // Return the newly created Pokemon instance
            return new Pokemon(index, pokemonMetadata.getName(), attack, defense, stamina, cp, hp, dust, candy, iv);
        } catch (PokedexException e) {
            return null;
        }
    }
}
