package fr.univavignon.pokedex.api;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of IPokemonMetadataProvider that
 * provides metadata for Pokémon by their index.
 *
 */
public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    /**
     * Map storing Pokemon metadata indexed
     * by their unique identifier.
     * The key represents the Pokemon's index,
     * and the value is its associated metadata.
     */
    private final Map<Integer, PokemonMetadata> metadataMap;

    /** Index for Bulbizarre Pokémon. **/
    private static final int BULBIZARRE_INDEX = 0;

    /** Name of the Bulbizarre Pokémon. **/
    private static final String BULBIZARRE_NAME = "Bulbizarre";

    /** Attack value for Bulbizarre Pokémon. **/
    private static final int BULBIZARRE_ATTACK = 126;

    /** Defense value for Bulbizarre Pokémon. **/
    private static final int BULBIZARRE_DEFENSE = 126;

    /** Stamina value for Bulbizarre Pokémon. **/
    private static final int BULBIZARRE_STAMINA = 90;


    /** Index for Herbizarre Pokémon. **/
    private static final int HERBIZARRE_INDEX = 1;

    /** Name of the Herbizarre Pokémon. **/
    private static final String HERBIZARRE_NAME = "Herbizarre";

    /** Attack value for Herbizarre Pokémon. **/
    private static final int HERBIZARRE_ATTACK = 156;

    /** Defense value for Herbizarre Pokémon. **/
    private static final int HERBIZARRE_DEFENSE = 158;

    /** Stamina value for Herbizarre Pokémon. **/
    private static final int HERBIZARRE_STAMINA = 120;


    /** Index for Florizarre Pokémon. **/
    private static final int FLORIZARRE_INDEX = 2;

    /** Name of the Florizarre Pokémon. **/
    private static final String FLORIZARRE_NAME = "Florizarre";

    /** Attack value for Florizarre Pokémon. **/
    private static final int FLORIZARRE_ATTACK = 198;

    /** Defense value for Florizarre Pokémon. **/
    private static final int FLORIZARRE_DEFENSE = 200;

    /** Stamina value for Florizarre Pokémon. **/
    private static final int FLORIZARRE_STAMINA = 160;


    /** Index for Aquali Pokémon. **/
    private static final int AQUALI_INDEX = 133;

    /** Name of the Aquali Pokémon. **/
    private static final String AQUALI_NAME = "Aquali";

    /** Attack value for Aquali Pokémon. **/
    private static final int AQUALI_ATTACK = 186;

    /** Defense value for Aquali Pokémon. **/
    private static final int AQUALI_DEFENSE = 168;

    /** Stamina value for Aquali Pokémon. **/
    private static final int AQUALI_STAMINA = 260;


    /**
     * Constructor initializes the metadata storage.
     * Here, sample metadata is added to simulate database or data source.
     */
    public PokemonMetadataProvider() {
        metadataMap = new HashMap<>();

        metadataMap.put(BULBIZARRE_INDEX,
                new PokemonMetadata(BULBIZARRE_INDEX,
                                    BULBIZARRE_NAME,
                                    BULBIZARRE_ATTACK,
                                    BULBIZARRE_DEFENSE,
                                    BULBIZARRE_STAMINA));
        metadataMap.put(HERBIZARRE_INDEX,
                new PokemonMetadata(HERBIZARRE_INDEX,
                                    HERBIZARRE_NAME,
                                    HERBIZARRE_ATTACK,
                                    HERBIZARRE_DEFENSE,
                                    HERBIZARRE_STAMINA));
        metadataMap.put(FLORIZARRE_INDEX,
                new PokemonMetadata(FLORIZARRE_INDEX,
                                    FLORIZARRE_NAME,
                                    FLORIZARRE_ATTACK,
                                    FLORIZARRE_DEFENSE,
                                    FLORIZARRE_STAMINA));
        metadataMap.put(AQUALI_INDEX,
                new PokemonMetadata(AQUALI_INDEX,
                                    AQUALI_NAME,
                                    AQUALI_ATTACK,
                                    AQUALI_DEFENSE,
                                    AQUALI_STAMINA));
    }

    /**
     * Retrieves and returns the metadata for
     * the Pokémon denoted by the given index.
     *
     * @param index Index of the Pokémon to retrieve metadata for.
     * @return Metadata of the Pokémon.
     * @throws PokedexException If the given index is not valid.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(final int index)
            throws PokedexException {
        if (!metadataMap.containsKey(index)) {
            throw new PokedexException("Invalid Pokémon index: " + index);
        }
        return metadataMap.get(index);
    }
}
