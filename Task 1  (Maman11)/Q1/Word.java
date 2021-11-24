/**
 * Word class. Represents a random word we are looking for
 */
import java.util.ArrayList;

public class Word {

    //instanse variables:
     private ArrayList<Character> word = new ArrayList<Character>();


    /**
     *  Constrator:
     */
    public Word() {
        // Set the arrays for starting the game.
        String[] words = {
                "Monkey", "Zebra", "Lion", "Dog", "Cat", "Bird", "Donkey", "Fish", "Turtle",
                "Rabbit", "Mouse", "Hamster", "Cow", "Duck", "Pig", "Deer", "Sheep", "Chicken",
                "Dove", "Parrot", "Goat", "Elephant", "Leopard", "Fox", "Camel", "Bear", "Koala", "Tiger",
                "Dolphin", "Wolf", "Toad", "Octopus", "Starfish", "Jellyfish", "Bee", "Fly", "Beetle"
            };
        String chosen_word = words[(int)(Math.random()*(words.length-1))];
        for (int i=0; i<chosen_word.length(); i++){
            word.add(chosen_word.charAt(i));

        }
    }

    // getters
    public ArrayList<Character> getWord(Word word) {
        return word.word;
    }
    // setters
    public void addToWord(char c){
        this.word.add(c);
    }

}
