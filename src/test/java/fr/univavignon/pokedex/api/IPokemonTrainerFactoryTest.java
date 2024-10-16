package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class IPokemonTrainerFactoryTest {

    private IPokemonTrainerFactory pokemonTrainerFactory;
    private IPokedexFactory pokedexFactory;
    private IPokedex pokedex;

    @Before
    public void setUp() {
        // Création d'un mock pour IPokedexFactory et IPokedex
        pokedexFactory = mock(IPokedexFactory.class);
        pokedex = mock(IPokedex.class);

        // Configuration du mock pokedexFactory pour retourner un pokédex simulé
        when(pokedexFactory.createPokedex(any(IPokemonMetadataProvider.class), any(IPokemonFactory.class))).thenReturn(pokedex);

        // Création d'une implémentation réelle de IPokemonTrainerFactory
        pokemonTrainerFactory = new IPokemonTrainerFactory() {
            @Override
            public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
                IPokedex createdPokedex = pokedexFactory.createPokedex(mock(IPokemonMetadataProvider.class), mock(IPokemonFactory.class));
                return new PokemonTrainer(name, team, createdPokedex);
            }
        };
    }

    @Test
    public void testCreateTrainer() {
        // Création du dresseur
        PokemonTrainer trainer = pokemonTrainerFactory.createTrainer("Ash", Team.VALOR, pokedexFactory);

        // Vérification que le dresseur n'est pas null
        assertNotNull(trainer);

        // Vérification des attributs du dresseur
        assertEquals("Ash", trainer.getName());
        assertEquals(Team.VALOR, trainer.getTeam());
        assertEquals(pokedex, trainer.getPokedex());

        // Vérification que la méthode createPokedex a été appelée une fois
        verify(pokedexFactory, times(1)).createPokedex(any(IPokemonMetadataProvider.class), any(IPokemonFactory.class));
    }
}
