package fr.univavignon.pokedex.api;

/**
 * Pokemon metadata POJO.
 *
 * @author fv
 */
public class PokemonMetadata {

    /** Pokemon index. **/
    private final int index;

    /** Pokemon name. **/
    private final String name;

    /** Pokemon attack level. **/
    private final int attack;

    /** Pokemon defense level. **/
    private final int defense;

    /** Pokemon stamina level. **/
    private final int stamina;

    /**
     * Default constructor.
     *
     * @param indexValue Pokemon index.
     * @param nameValue Pokemon name.
     * @param attackValue Attack level.
     * @param defenseValue Defense level.
     * @param staminaValue Stamina level.
     */
    public PokemonMetadata(final int indexValue,
                           final String nameValue,
                           final int attackValue,
                           final int defenseValue,
                           final int staminaValue) {
        this.index = indexValue;
        this.name = nameValue;
        this.attack = attackValue;
        this.defense = defenseValue;
        this.stamina = staminaValue;
    }
    /**
     * Returns the index of the Pokémon.
     *
     * @return the index of the Pokémon
     */
    public int getIndex() {
        return index;
    }

    /**
     * Returns the name of the Pokémon.
     *
     * @return the name of the Pokémon
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the attack level of the Pokémon.
     *
     * @return the attack level of the Pokémon
     */
    public int getAttack() {
        return attack;
    }

    /**
     * Returns the defense level of the Pokémon.
     *
     * @return the defense level of the Pokémon
     */
    public int getDefense() {
        return defense;
    }

    /**
     * Returns the stamina level of the Pokémon.
     *
     * @return the stamina level of the Pokémon
     */
    public int getStamina() {
        return stamina;
    }
}
