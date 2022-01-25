package com.agesadev;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HangmanMultiplayer {

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("1 or 2 players?");
        Scanner userInput = new Scanner(System.in);
        String word;
        if (userInput.equals("1")) {
            //read the txt file with english words
            Scanner scanner = new Scanner(new File("C:\\Users\\Agesa\\Documents\\workspace\\Hangman Game\\words.txt"));

            List<String> words = new ArrayList<>();
            while (scanner.hasNext()) {
                //add the text to a string array list
                words.add(scanner.nextLine());
            }
            Random rand = new Random();
            word = words.get(rand.nextInt(words.size()));
        } else {
            System.out.println("Player 1,please enter your word: ");
            word = userInput.nextLine();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Ready for Player 2!.GoodLuck");
        }


//      System.out.println(word);
        List<Character> playerGuesses = new ArrayList<>();
        printWordState(word, playerGuesses);
        int wrongCount = 0;
        while (true) {

            printHangMan(wrongCount);

            if (wrongCount >= 6) {
                System.out.println("You Loose !!!!");
                break;
            }
            printWordState(word, playerGuesses);
            if (!getPlayerGuess(userInput, word, playerGuesses)) {
                wrongCount++;
            }

            if (printWordState(word, playerGuesses)) {
                System.out.println("You Win !!!!!!");
                break;
            }
            System.out.println("Please Enter your guess for the word");
            if (userInput.nextLine().equals(word)) {
                System.out.println("You Win !!!!!!");
                break;
            } else {
                System.out.println("Ooops.Try again");
            }
        }

    }

    private static void printHangMan(int wrongCount) {
        System.out.println("---------");
        System.out.println(" |      |");

        if (wrongCount >= 1) {
            System.out.println(" o");
        }
        if (wrongCount >= 2) {
            System.out.print("\\ ");
            if (wrongCount >= 3) {
                System.out.println("/");
            } else {
                System.out.println("");
            }
        }

        if (wrongCount >= 4) {
            System.out.println(" |");
        }

        if (wrongCount >= 5) {
            System.out.print(" /");
            if (wrongCount >= 6) {
                System.out.println("\\");
            } else {
                System.out.println("");

            }
        }
        System.out.println("");
        System.out.println("");
    }

    private static boolean getPlayerGuess(Scanner userInput, String word, List<Character> playerGuesses) {
        System.out.println("Please Enter a letter: ");
        String userGuess = userInput.nextLine();
        playerGuesses.add(userGuess.charAt(0));
        return word.contains(userGuess);
    }

    private static boolean printWordState(String word, List<Character> playerGuesses) {
        int correctCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (playerGuesses.contains(word.charAt(i))) {
                System.out.print(word.charAt(i));
                correctCount++;

            } else {
                System.out.print("-");
            }
        }
        System.out.println();
        return (word.length() == correctCount);
    }

}
