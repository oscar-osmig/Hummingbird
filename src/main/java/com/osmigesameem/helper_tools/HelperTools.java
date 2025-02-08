package com.osmigesameem.helper_tools;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class HelperTools {

    public static String optionBoard(){
        System.out.println(
                 "\n  Enter (a) to ask questions" +
                 "\n        (s) to get questioned" +
                 "\n  or    (q) to quit");
        String userChoice = getAnswer("\nYour choice: ");
        return userChoice;
    }

    public static void introduceSelf(){
        System.out.println("Hello, I'm Hummingbird. I can currently do the following: ");
    }

    public static String getAnswer(String q){
        Scanner scanner = new Scanner(System.in);
        System.out.print(q);
        return scanner.nextLine();
    }

    public static HashMap<String, String> readFromFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        HashMap<String, String> map = new HashMap<>();
        String delimiter = "\n";
        String line;
        //
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(Pattern.quote(delimiter));

            for(String part : parts){
                String[] sentence = part.split(",");
                String question = sentence[0];
                String answer = sentence[1];
                map.put(question, answer);
            }
        }
        return map;
    }

    public static void main(String[] args) throws IOException {
        HashMap<String, String> map = readFromFile("src/main/java/com/osmigesameem/data/questionDictionary.csv");
        System.out.println(map.toString());
        System.out.println(map.get("Who made you?"));
    }
}
