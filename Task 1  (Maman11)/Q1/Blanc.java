/**
 * Blanc Department. Represents a skeleton for searching for the original word
 */

import java.util.ArrayList;

public class Blanc {

    private ArrayList<Character> blanc = new ArrayList<Character>(); // TODO change to arraylist  -- its not fit to toString method.

    /**
     * Constructor:
     */
    public Blanc(Word word) {
            for (int i=0; i<word.getWord(word).size(); i++) { // set _'s instad the letter.
                blanc.add('_');
            }
    }


    // getters
    public ArrayList<Character> getBlancList(Blanc blanc) {
        return blanc.blanc;
    }
    // setters
    public void addToBlanc(char c){
        this.blanc.add(c);
    }

}
