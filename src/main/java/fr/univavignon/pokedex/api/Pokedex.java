package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex {

    /** List of Pokemons in the Pokedex. **/
    private final List<Pokemon> pokemons;

    /** Provider of Pokemon metadata. **/
    private final IPokemonMetadataProvider metadataProvider;

    /** Factory to create new Pokemon instances. **/
    private final IPokemonFactory pokemonFactory;

    /**
     * Constructor to initialize the Pokedex with
     * metadata provider and Pokemon factory.
     *
     * @param metadataProviderValue The provider for Pokemon metadata.
     * @param pokemonFactoryValue The factory to create new Pokemon instances.
     */
    public Pokedex(final IPokemonMetadataProvider metadataProviderValue,
                   final IPokemonFactory pokemonFactoryValue) {
        this.metadataProvider = metadataProviderValue;
        this.pokemonFactory = pokemonFactoryValue;
        this.pokemons = new ArrayList<>();
    }

    /**
     * Returns the number of Pokemons in the Pokedex.
     *
     * @return The size of the Pokedex.
     */
    @Override
    public int size() {
        return pokemons.size();
    }

    /**
     * Adds a Pokemon to the Pokedex and returns its index.
     *
     * @param pokemon The Pokemon to be added.
     * @return The index of the newly added Pokemon.
     */
    @Override
    public int addPokemon(final Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemons.size() - 1; // Index of the newly added Pokemon
    }

    /**
     * Retrieves a Pokemon from the Pokedex by its ID.
     *
     * @param id The ID of the Pokemon to retrieve.
     * @return The Pokemon with the specified ID.
     * @throws PokedexException If the ID is invalid.
     */
    @Override
    public Pokemon getPokemon(final int id) throws PokedexException {
        if (id < 0 || id >= pokemons.size()) {
            throw new PokedexException("Invalid Pokemon ID: " + id);
        }
        return pokemons.get(id);
    }

    /**
     * Returns an unmodifiable list of all Pokemons in the Pokedex.
     *
     * @return An unmodifiable list of Pokemons.
     */
    @Override
    public List<Pokemon> getPokemons() {
        return Collections.unmodifiableList(pokemons);
    }

    /**
     * Returns an unmodifiable list of all
     * Pokemons in the Pokedex, sorted by the given comparator.
     *
     * @param order The comparator to sort the list of Pokemons.
     * @return An unmodifiable list of sorted Pokemons.
     */
    @Override
    public List<Pokemon> getPokemons(final Comparator<Pokemon> order) {
        List<Pokemon> sortedPokemons = new ArrayList<>(pokemons);
        sortedPokemons.sort(order);
        return Collections.unmodifiableList(sortedPokemons);
    }

    /**
     * Retrieves the metadata for a specific Pokemon.
     *
     * @param index The index of the Pokemon.
     * @return The metadata of the Pokemon.
     * @throws PokedexException If the Pokemon metadata cannot be retrieved.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(final int index)
            throws PokedexException {
        return metadataProvider.getPokemonMetadata(index);
    }

    /**
     * Creates a new Pokemon with the specified parameters.
     *
     * @param index The index of the Pokemon.
     * @param cp The combat points of the Pokemon.
     * @param hp The health points of the Pokemon.
     * @param dust The amount of dust needed to power up the Pokemon.
     * @param candy The amount of candy needed to evolve the Pokemon.
     * @return A new Pokemon instance.
     */
    @Override
    public Pokemon createPokemon(final int index, final int cp,
                                 final int hp, final int dust,
                                 final int candy) {
        return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }
}
