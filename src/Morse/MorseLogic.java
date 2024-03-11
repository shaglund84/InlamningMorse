package Morse;
import java.util.HashMap;

public class MorseLogic {
    private HashMap<String, String> textToMorse; // en hashmap för att översätta text till morse
    private HashMap<String, String> morseToText; // och en till hashmap för att översätta morse till text

    public MorseLogic() { // konstruktor för MorseLogic-klassen som kallas när en ny instans av klassen skapas.
        initializeMaps(); // anropar metoden initializeMaps för att förbereda hashmapparna
    }

    private void initializeMaps() { // metod som fyller hashmapparna med nycklar och värden
                                    // för att utföra översättning mellan text och morsekod
        textToMorse = new HashMap<>();
        morseToText = new HashMap<>();
                                    // Två arrayer, en för bokstäver och siffror, och en för motsvarande morsekod
        String[] lettersNumbers = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
                "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y",
                "Z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", ",", "?"};
        String[] morseCodes = {"*-", "-***", "-*-*", "-**", "*", "**-*", "--*", "****",
                "**", "*---", "-*-", "*-**", "--", "-*", "---", "*--*", "--*-", "*-*",
                "***", "-", "**-", "***-", "*--", "-**-", "-*--", "--**", "-----", "*----",
                "**---", "***--", "****-", "*****", "-****", "--***", "---**", "----*", "*-*-*-", "--**--", "**--**"};
        for (int i = 0; i < lettersNumbers.length; i++) { // for-loop som går igenom arrayerna och lagrar i hashmapsen
            textToMorse.put(lettersNumbers[i], morseCodes[i]);
            morseToText.put(morseCodes[i], lettersNumbers[i]);
        }
    }
    public String convert(String input) { // metod för att konvertera, antingen morse to text eller text to morse
        if (isMorse(input)) { // anropar isMorse (metoden nedanför här) för att kontroller om det är morsekod som matas in
            return morseToText(input); // returnerar i så fall morseToText
        } else {
            return textToMorse(input); // och om inte, returnerar textToMorse
        }
    }

    private boolean isMorse(String input) { // metod för att avgöra om input är morse-kod
        return input.contains("*") || input.contains("-") || input.contains(" ");
    }

    String textToMorse(String text) { // metod som översätter text->morse
        StringBuilder result = new StringBuilder(); // lagrar resultatet i en StringBuilder
        for (char c : text.toUpperCase().toCharArray()) { // varje tecken gås igenom och görs till uppercase
            String letter = String.valueOf(c); // strängen letter innehåller det aktuella tecknet c
            if (textToMorse.containsKey(letter)) { // kontrollerar om tecknet finns i hashmapen
                result.append(textToMorse.get(letter)).append(" "); // lägger isåfall till morsekoden i resultatet, med mellanslag för att separera
            } else if (c == ' ') { // mellanslag betyder flera tecken/ord som ska separeras
                result.append(" ");// Lägger till ett mellanslag för att separera
            }
        }
        return result.toString().trim(); // konverterar resultatet till en vanlig sträng och trimmar den
    }

    String morseToText(String morseCode) { // metod som översätter morse->text
        StringBuilder result = new StringBuilder();
        String[] words = morseCode.split("   "); // morsekoden sparas i en array och separeras med tre mellanslag för att göra det tydligare
        for (String word : words) { // varje ord i word-arrayen gås igenom (med en enchanced for-loop för det blev snyggare
            String[] letters = word.split(" "); // delar upp med mellanslag
            for (String letter : letters) {
                if (morseToText.containsKey(letter)) { // kontroll över om bokstaven finns i hashmapen för morseToText
                    result.append(morseToText.get(letter)); // och lägger isåfall till motsvarande text i resultatet
                }
            }
            result.append(" ");
        }
        return result.toString().trim(); // trimmar bort överflödiga mellanslag före och efter översättningen
    }
}