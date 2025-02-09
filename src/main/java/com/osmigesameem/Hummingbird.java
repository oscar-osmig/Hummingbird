package com.osmigesameem;

import com.osmigesameem.helper_tools.HelperTools;

import java.io.IOException;
import java.util.HashMap;

public class Hummingbird {
    static HashMap<String, String> questionDictionary = new HashMap<>();
    String dataPath = "src/main/java/com/osmigesameem/data/questionDictionary.csv";

    public static void run() throws IOException {
        boolean running = true;
        int counter = 0;
        // currently initialize the hashmap
        //init();
        // AI introduces itself
        HelperTools.introduceSelf();
        do {
            // display option board and ask the first task
           String task = HelperTools.optionBoard();
            switch (task){
                case "a": case "A":
                    String question = answerQuestion();
                    if(question.equals("null")){
                        String userOwnAnswer = HelperTools.getAnswer("\nSorry I don't know the answer to that. " +
                                "\nHow would you answer to this? ");
                        if (!userOwnAnswer.equals("null")){
                            String s = userQuestion + ", " + userOwnAnswer;
                            HelperTools.writeToFile(s);
                        }
                    }else {
                        System.out.println(question);
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
    static String  userQuestion = "";
    private static String answerQuestion() throws IOException {
        // getting user's question
       userQuestion = HelperTools.getAnswer("What is your question? ");
       // checking if question is on the 'questionDictionary'
        questionDictionary = HelperTools.readFromFile("src/main/java/com/osmigesameem/data/questionDictionary.csv");
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
