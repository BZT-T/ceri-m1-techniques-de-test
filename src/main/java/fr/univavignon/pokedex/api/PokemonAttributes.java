package fr.univavignon.pokedex.api;

/**
 * Represents the attributes of a Pokémon.
 * This class encapsulates the key statistical attributes
 * of a Pokémon, including combat power (CP),
 * hit points (HP),
 * stardust cost for upgrades,
 * candy count,
 * and individual value (IV).
 *
 * @author Your Name
 * @version 1.0
 */
public class PokemonAttributes {

    /** Hit Points (HP) of the Pokémon. */
    private final int hp;

    /** Stardust cost required for upgrading the Pokémon. */
    private final int dust;

    /** Candy count required for upgrading the Pokémon. */
    private final int candy;

    /** Combat Power (CP) of the Pokémon. */
    private final int cp;

    /** Individual Value (IV) of the Pokémon. */
    private final double iv;

    /**
     * Constructor for creating a new instance of Pokémon attributes.
     *
     * @param cpValue Combat Power (CP) of the Pokémon.
     * @param hpValue Hit Points (HP) of the Pokémon.
     * @param dustValue Stardust cost for upgrading the Pokémon.
     * @param candyValue Candy count required for upgrading the Pokémon.
     * @param ivValue Individual Value (IV) of the Pokémon.
     */
    public PokemonAttributes(final int cpValue,
                             final int hpValue,
                             final int dustValue,
                             final int candyValue,
                             final double ivValue) {
        this.cp = cpValue;
        this.hp = hpValue;
        this.dust = dustValue;
        this.candy = candyValue;
        this.iv = ivValue;
    }

    /**
     * Returns the Combat Power (CP) of the Pokémon.
     *
     * @return Combat Power of the Pokémon.
     */
    public int getCp() {
        return cp;
    }

    /**
     * Returns the Hit Points (HP) of the Pokémon.
     *
     * @return Hit Points of the Pokémon.
     */
    public int getHp() {
        return hp;
    }

    /**
     * Returns the Stardust cost for upgrading the Pokémon.
     *
     * @return Stardust cost of the Pokémon.
     */
    public int getDust() {
        return dust;
    }

    /**
     * Returns the Candy count required for upgrading the Pokémon.
     *
     * @return Candy count of the Pokémon.
     */
    public int getCandy() {
        return candy;
    }

    /**
     * Returns the Individual Value (IV) of the Pokémon.
     *
     * @return Individual Value of the Pokémon.
     */
    public double getIv() {
        return iv;
    }
}
