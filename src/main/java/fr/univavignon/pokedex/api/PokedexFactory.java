package fr.univavignon.pokedex.api;

public class PokedexFactory implements IPokedexFactory {

    /**
     * Creates a new instance of Pokedex using the specified metadata provider and Pokemon factory.
     *
     * @param metadataProvider Metadata provider used by the created pokedex.
     * @param pokemonFactory Pokemon factory used by the created pokedex.
     * @return New instance of pokedex.
     */

    @Override
    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        return new Pokedex(metadataProvider, pokemonFactory);
    }
}
