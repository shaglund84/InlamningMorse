package Morse;

import java.util.Scanner;

import static Morse.MorseLogic.isValidInput;

public class MorseMain {
    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter morse code ( - * ) or a text (letters A-Z or numbers including characters . , and ?): ");
            String input = scan.nextLine();

            if (input.isEmpty()) { // felhantering för att vår input ska innehålla något
                throw new IllegalArgumentException("Type something!");
            }
            if (!isValidInput(input)) { // felhantering för att vår input ska innehålla giltiga tecken
                throw new IllegalArgumentException("Only letters in the English alphabet and numbers , please!");
            }
            // hämtar konverteraren från klassen MorseLogic
            MorseLogic morse = new MorseLogic();
            String output = morse.convert(input);
            System.out.println("Converted text: " + output);
        } catch (Exception e) { // fångar felet med att skriva ut ett felmeddelande
            System.out.println("Error: " + e.getMessage());
        }
    }
}