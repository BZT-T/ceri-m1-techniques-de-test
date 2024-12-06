package fr.univavignon.pokedex.api;

/**
 * Trainer POJO.
 *
 * @author fv
 */
public class PokemonTrainer {

    /** Trainer name. **/
    private final String name;

    /** Trainer team. **/
    private final Team team;
    /** Trainer pokedex. **/
    private final IPokedex pokedex;
    /**
     * Default constructor.
     *
     * @param nameValue Trainer name.
     * @param teamValue Trainer team.
     * @param pokedexValue Trainer pokedex.
     */
    public PokemonTrainer(final String nameValue,
                          final Team teamValue,
                          final IPokedex pokedexValue) {
        this.name = nameValue;
        this.team = teamValue;
        this.pokedex = pokedexValue;
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
     * Returns the team of the Pokémon.
     *
     * @return the team of the Pokémon
     */
    public Team getTeam() {
        return team;
    }

    /**
     * Returns the Pokedex associated with the Pokémon.
     *
     * @return the Pokedex associated with the Pokémon
     */
    public IPokedex getPokedex() {
        return pokedex;
    }
}
