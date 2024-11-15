package fr.univavignon.pokedex.api;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of IPokemonMetadataProvider that provides metadata for Pokémon by their index.
 *
 */
public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    // Storage for Pokémon metadata based on index
    private final Map<Integer, PokemonMetadata> metadataMap;

    /**
     * Constructor initializes the metadata storage.
     * Here, sample metadata is added to simulate database or data source.
     */
    public PokemonMetadataProvider() {
        metadataMap = new HashMap<>();

        metadataMap.put(0, new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
        metadataMap.put(1, new PokemonMetadata(1, "Herbizarre", 156, 158, 120));
        metadataMap.put(2, new PokemonMetadata(2, "Florizarre", 198, 200, 160));
        metadataMap.put(133, new PokemonMetadata(133, "Aquali", 186, 168, 260));
    }

    /**
     * Retrieves and returns the metadata for the Pokémon denoted by the given index.
     *
     * @param index Index of the Pokémon to retrieve metadata for.
     * @return Metadata of the Pokémon.
     * @throws PokedexException If the given index is not valid.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (!metadataMap.containsKey(index)) {
            throw new PokedexException("Invalid Pokémon index: " + index);
        }
        return metadataMap.get(index);
    }
}
