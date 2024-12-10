package Action;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

/**
 * Cette classe contient les tests unitaires pour la classe SkipTurn.
 */
public class SkipTurnTest {
    
    /**
     * Teste la méthode Do de la classe SkipTurn.
     * Cette méthode vérifie si l'appel de la méthode Do affiche correctement
     * le message "You have skipped your turn!".
     */
    @Test
    void testDo() {
        // Arrange
        SkipTurn skipTurn = new SkipTurn();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        skipTurn.Do();
        assertEquals("You have skipped your turn!", outputStream.toString().trim());
    }
    
    /**
     * Teste la méthode toString de la classe SkipTurn.
     * Cette méthode vérifie si l'appel de la méthode toString retourne
     * correctement la chaîne "Skip your turn?".
     */
    @Test
    void testToString() {
        // Arrange
        SkipTurn skipTurn = new SkipTurn();
        String result = skipTurn.toString();
        assertEquals("Skip your turn?", result);
    }
}
