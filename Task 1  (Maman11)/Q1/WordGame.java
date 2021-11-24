import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.Character.toLowerCase;

public class WordGame {

    private int countToEnd; // flag for loops. count from word length to zero.
    private int countGuess; // count the user's guesses.

    private ArrayList<Character> leftLetters = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w','x' ,'y','z'));
    Word chosenWord = new Word(); // Word object for the wanted word
    Blanc base = new Blanc(chosenWord); // blanc arrayList to fill with chars.

    Scanner scan = new Scanner(System.in);

    /**
     * the Brain of the game.
     * user choose letter from list, and the program found it in the Word-List.
     */
    public void startTheGame(){


        countToEnd = chosenWord.getWord(chosenWord).size(); // set the counting

        while( countToEnd >0) {

            System.out.print("\nEnter a letter from the list: \n");
            toString(leftLetters);
            char letter = scan.next().charAt(0);

            if (isInvalid(letter)){ // check if the user print invalid character
                System.out.println("This is not valid character, please try again:");
                continue;
            }
            removeFromList(letter); // remove the chosen letter from the list so we cant use it again.

            countGuess++;
            countToEnd = findLetter(chosenWord, base, letter,countToEnd);
            toString(base.getBlancList(base));

        } // end of while loop.
        System.out.println("Good job! Your score is: " + countGuess + "\n\n");
    }

    /**
     * A mathod that remove chosen letter from 'leftLetters' so the user can't use it again.
     * @param l the letter that we want to remove.
     */
    private void removeFromList(char l){
        for (int i=0; i<leftLetters.size(); i++){
            if (leftLetters.get(i) == l)
                leftLetters.remove(i);
        }
    }

    /**
     * A method that checks the validation of a selected character
     * @param l The char that we get from the user.
     * @return true if its invalid.
     */
    private boolean isInvalid(char l){
        for (int i=0; i<leftLetters.size(); i++){
            if (leftLetters.get(i) == l)
                return false;
        }
        return true;
    }

    /**
     * Overriding method. print ArrayList.
     * @param list the ArrayList that we want to print.
     */
    private void toString(ArrayList list){
        for (int i=0; i<list.size(); i++) {
            System.out.print(list.get(i));
        }
    }

    /**
     * A method that receives a character and an array and checks if a character is in the array And returns the number of instances
     * @param wo Word object - the array-list - the word we are looking for.
     * @param bl Blanc object - the array that we want to insert the letter to.
     * @param letter the char that we looking for
     * @param count the number of instances
     * @return count the number of instances
     */
    private static int findLetter(Word wo, Blanc bl, char letter, int count){
        for (int i = 0; i<wo.getWord(wo).size(); i++){
            if (toLowerCase(wo.getWord(wo).get(i)) == toLowerCase(letter)){ // compare the letters in lower case!
                bl.getBlancList(bl).set(i,letter);
                count--;
            }// End of if.
        }// End of for loop.
        return count;
    }

    /**
     *
     * @param word
     * @param bl
     * @return
     */
    public boolean isEqual(Word word ,Blanc bl){
        for (int i=0; i<word.getWord(word).size(); i++){
            if(toLowerCase(word.getWord(word).get(i)) != toLowerCase( bl.getBlancList(bl).get(i)))
                return false;
        }// End of if.
        return true;
    }

}
