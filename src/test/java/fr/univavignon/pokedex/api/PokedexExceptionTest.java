package fr.univavignon.pokedex.api;

import org.junit.Test;
import static org.junit.Assert.*;

public class PokedexExceptionTest {

    @Test
    public void testPokedexExceptionMessage() {
        // Message d'erreur prévu
        String errorMessage = "Index invalide pour le pokédex";

        // Création de l'exception avec le message d'erreur
        PokedexException exception = new PokedexException(errorMessage);

        // Vérifie que le message de l'exception est correct
        assertEquals(errorMessage, exception.getMessage());
    }

    @Test(expected = PokedexException.class)
    public void testThrowPokedexException() throws PokedexException {
        // Simulation d'une condition qui lancerait cette exception
        throw new PokedexException("Erreur simulée pour le test");
    }
}