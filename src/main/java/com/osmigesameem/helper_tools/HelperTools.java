package com.osmigesameem.helper_tools;

import java.util.Scanner;

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
}
