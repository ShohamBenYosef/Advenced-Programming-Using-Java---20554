/**
 * @id 311597223
 * @name Shoham Ben Yosef
 * @date 21.10.2021
 *
 * MAMAN 11 question 1.
 *
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int answer;

        while(true)
        {
            WordGame game = new WordGame();  //TODO
            game.startTheGame(); // call the game.

            // end of round:
            System.out.println("For anothr game press any number, If you want to quit please enter \"-1\"");
            answer = scanner.nextInt();
            if (answer != (-1)){
                continue;
            }else{
                System.out.println("Bye");
                break;
            }
        }

    }
}