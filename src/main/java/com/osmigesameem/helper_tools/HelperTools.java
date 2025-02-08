package com.osmigesameem.helper_tools;

import java.util.Scanner;

public class HelperTools {

    public static String introduceSelf(){
        System.out.println(
                "\nHello, I'm Hummingbird. I'm currently able to answer questions and ask you questions! " +
                 "\n  Enter (a) to ask questions" +
                 "\n  or    (s) to get questioned");
        String userChoice = getAnswer("\nYour choice: ");
        return userChoice;
    }

    public static String getAnswer(String q){
        Scanner scanner = new Scanner(System.in);
        System.out.print(q);
        return scanner.nextLine();
    }
}
