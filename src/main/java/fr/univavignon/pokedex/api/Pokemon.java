package fr.univavignon.pokedex.api;

/**
 * Pokemon POJO.
 *
 * @author fv
 */
public final class Pokemon extends PokemonMetadata {

    /** Combat Point of the pokemon. **/
    private final int cp;

    /** HP of the pokemon. **/
    private final int hp;

    /** Required dust for upgrading this pokemon. **/
    private final int dust;

    /** Required candy for upgrading this pokemon. **/
    private final int candy;

    /** IV perfection percentage. **/
    private final double iv;

    /**
     * Default constructor.
     *
     * @param index Pokemon index.//////////////////////////////////////////////////////////
     * @param name Pokemon name.
     * @param attack Attack level.
     * @param defense Defense level.
     * @param stamina Stamina level.
     * @param attributes Object containing
     *        additional attributes of the Pokemon,
     *        including CP, HP, Stardust, Candy,
     *        and IV values.
     */
    public Pokemon(
            final int index,
            final String name,
            final int attack,
            final int defense,
            final int stamina,
            final PokemonAttributes attributes) {
        super(index, name, attack, defense, stamina);
        this.cp = attributes.getCp();
        this.hp = attributes.getHp();
        this.dust = attributes.getDust();
        this.candy = attributes.getCandy();
        this.iv = attributes.getIv();
    }

    /** Combat Point getter getter.
     * @return the combat points (CP) of the Pokémon
     **/
    public int getCp() {
        return cp;
    }

    /** HP getter.
     * @return the hit points (HP) of the Pokémon
     **/
    public int getHp() {
        return hp;
    }

    /** Dust getter.
     * @return the stardust cost
     **/
    public int getDust() {
        return dust;
    }

    /** Candy getter.
     * @return the number of candies
     **/
    public int getCandy() {
        return candy;
    }

    /** IV getter.
     * @return the individual value (IV) as a percentage
     **/
    public double getIv() {
        return iv;
    }
}
