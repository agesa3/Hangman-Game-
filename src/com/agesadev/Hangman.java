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
        Scanner scanner = new Scanner(new File(""));

        List<String> words = new ArrayList<>();
        while (scanner.hasNext()) {
            //add the text to a string array list
            words.add(scanner.nextLine());
        }
        Random rand = new Random();
        String word = words.get(rand.nextInt(words.size()));


    }
}
