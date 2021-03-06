package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private boolean gameIsOn = true;
    ArrayList<String> QNA = new ArrayList<String>();
    Card card = new Card(); // calling to Card constructor.
    Random r = new Random();
    String[] answers = new String[4];  //
    Scanner scan = new Scanner(System.in);
    int numOfQuizLeft = 5;

    public void game(){
        while(numOfQuizLeft > 0 && gameIsOn){
            QNA = card.purseFile();
            int questionNum = numOfQuizLeft*r.nextInt(5); // throw num % 5 to choose question
            String question = QNA.get(questionNum); // set the question.
            fillTheAnswers(answers, QNA, questionNum); // set the answers in array.
            printAndCheckRandomanswers(answers); // show the user the q and the ans and let him choose.
            removeQuizFromList(questionNum);
            numOfQuizLeft--; // count the question that left...  TODO יש בעיה עם קיצוץ השאלות

            if (!wantAgain()) {
                gameIsOn = false;
                System.out.println("Take care..");
            }

        }// end while
    }

    private void removeQuizFromList(int index){
        for (int i = index; i<index+4; i++){
            QNA.remove(i);
        }
    }
    private boolean wantAgain(){
        String yes = "yes";
        System.out.println("Do you want to play again? yes/no");
        return yes.equals(scan.next());
    }

    private void fillTheAnswers(String[] ans, ArrayList<String> list, int index){
        for(int i=0; i<4; i++)
            ans[i] = list.get(index+i+1);
    }

    private void printAndCheckRandomanswers(String[] answers){
        String currAns = answers[0];
        int choose = 0;

        for (int i=0; i<20; i++) { // shaffle the array

            int i1 = r.nextInt(answers.length);
            int i2 = r.nextInt(answers.length);

            String tmp = answers[i1];
            answers[i1] = answers[i2];
            answers[i2] = tmp;
        }

        for (int i=0; i<answers.length; i++)
            System.out.println(i+1 + ". " + answers[i]);


        System.out.println("\nPlease type your ans number:");
        int cnt = 0;

        while(true) {
            cnt++;
            choose = scan.nextInt();

            if (currAns.equals(answers[choose - 1])) {
                System.out.println("Currect!");
                break;
            } else {
                System.out.println("Worng. Try Again:");
            }

        }
    }

    public void printToCheck(String q, String[] a){
        System.out.println(q);
        for (String str : a) {
            System.out.println(str);
        }
    }
    private void clearBoard(){} // ToDo ! !
}
