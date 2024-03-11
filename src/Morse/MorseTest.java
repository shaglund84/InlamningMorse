package Morse;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MorseTest {

    @Test
    public void testTextToMorse() {
        MorseLogic morseLogic = new MorseLogic();
        String testdata = "HELLO";
        String expected = "**** * *-** *-** ---";
        String actual = morseLogic.textToMorse(testdata);
        assertEquals(expected, actual);
    }

    @Test
    public void testMorseToText() {
        MorseLogic morseLogic = new MorseLogic();
        String testdata = "**** * *-** *-** ---";
        String expected = "HELLO";
        String actual = morseLogic.morseToText(testdata);
        assertEquals(expected, actual);
    }

    @Test
    public void testInvalidCharacters() {
        MorseLogic morseLogic = new MorseLogic();
        String testdata = "!#%&"; // Innehåller ogiltiga tecken
        String expected = ""; // Förväntat resultat är en tom sträng (inga omvandlingar görs)
        String actual = morseLogic.textToMorse(testdata);
        assertEquals(expected, actual);

    }
}
