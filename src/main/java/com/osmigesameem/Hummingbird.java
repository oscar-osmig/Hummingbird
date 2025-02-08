package com.osmigesameem;

import com.osmigesameem.helper_tools.HelperTools;

import java.util.HashMap;

public class Hummingbird {
    static HashMap<String, String> questionDictionary = new HashMap<>();

    public static void run(){
        boolean running = true;
        int counter = 0;
        // currently initialize the hashmap
        init();
        // AI introduces itself
        HelperTools.introduceSelf();
        do {
            // display option board and ask the first task
           String task = HelperTools.optionBoard();
            switch (task){
                case "a": case "A":
                    String answer = answerQuestion();
                    if(answer.equals("null")){
                        System.out.println("\nSorry I don't know the answer to that.");
                    }else {
                        System.out.println(answer);
                    }
                    break;

                case "s": case "S":
                    questionUser();
                    break;
                case "q": case "Q":
                    running = false;
                    System.out.println("\nBye bye ...");
                    break;
                default:
                    System.out.println("\nI did not understand what you just typed...");

            }
        }while (running);


    }

    private static String answerQuestion() {
        // getting user's question
       String userQuestion = HelperTools.getAnswer("What is your question? ");
       // checking if question is on the 'questionDictionary'
       if (questionDictionary.containsKey(userQuestion)){
           String answer = questionDictionary.get(userQuestion);
           return answer;
       }else {
           return "null";
       }
    }

    private static void questionUser() {
        String question = "What is 2 + 2? ";
        String userAnswer = HelperTools.getAnswer(question);
        questionDictionary.put(question, userAnswer);
        System.out.println("Thank you for your answer.");
        System.out.println(questionDictionary.toString());
    }


    private static void init(){
        questionDictionary.put("Who are you?", "I'm Hummingbird.");
    }
}
