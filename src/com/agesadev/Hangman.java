package com.agesadev;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {

    public static void main(String[] args) throws FileNotFoundException {
        //read the txt file with english words
        Scanner scanner = new Scanner(new File("C:\\Users\\Agesa\\Documents\\workspace\\Hangman Game\\words.txt"));
        Scanner userInput = new Scanner(System.in);

        List<String> words = new ArrayList<>();
        while (scanner.hasNext()) {
            //add the text to a string array list
            words.add(scanner.nextLine());

        }
        Random rand = new Random();
        String word = words.get(rand.nextInt(words.size()));

        System.out.println(word);

        List<Character> playerGuesses = new ArrayList<>();
        printWordState(word, playerGuesses);
        System.out.println("Please Enter a letter: ");
        String userGuess = userInput.nextLine();
        playerGuesses.add(userGuess.charAt(0));
        printWordState(word, playerGuesses);

    }

    private static void printWordState(String word, List<Character> playerGuesses) {
        for (int i = 0; i < word.length(); i++) {
            if (playerGuesses.contains(word.charAt(i))) {
                System.out.print(word.charAt(i));
            } else {
                System.out.print("-");
            }
        }
        System.out.println();
    }


}
