
package whitecastleslider;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
public class WhiteCastleSlider {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        //Initializes neccesary variables and readies Scanner, prints opening message
        Scanner input = new Scanner(System.in);
        int size = 0;
        System.out.println("Welcome, slide puzzle game!");
        System.out.println("In this game, the goal is to organize the tiles such");
        System.out.println("that they go in descending order (organized from left to right)");
        System.out.println("");
        boolean done = false;
        /*Prompts user for puzzle size, size constraints are what the developer considers
        reasonable in scope and difficulty*/
        while(!done){
        System.out.println("What size (n x n) puzzle do you want to solve? Enter a"
                + " number between 3-6 ");
        boolean validSize = false;
        boolean solved = false;
        //Loop for ensuring user eventually enters a correct size
        while(!validSize){
            size = input.nextInt();
            if(size > 6 || size < 3){
                System.out.println("INVALID SIZE: Please enter a size between 3-6");
            }
            else{
                validSize = true;
            }
        }
        
        //Creates the puzzle and prints to user, initializes move counter
        Puzzle p = new Puzzle(size);
        p.shuffle();
        System.out.println("Here is your puzzle! You can move any adjacent tile into");
        System.out.println("the blank tile to move.");
        System.out.println("");
        int moves = 0;
        double timeStart = System.currentTimeMillis();
        /* While the puzzle has not been solved the user is promted to move.
           Exceptions are handled such that the user will be able to input again
           without disrupting the state of the game. Loop is exited on quit or
           solving.
        */
        while(!solved){
            System.out.println(p);
            System.out.println("Moves so far: "+moves);
            System.out.println("What tile would you like to move into the blank space?");
            System.out.println("U = Up, D = Down, R = Right, L = Left, Q = Quit");
            try{
                String direction = input.next();
                if(direction.equalsIgnoreCase("Q")){
                    break;
                }
                else{
                 p.move(direction);
                 moves++;
                }
                
            }
            catch(Exception e){
                System.out.println(""+e);
            }
            if(p.isSolved()){
                solved = true;
            }
           
            
        }
        
        //Prints victory message if solved, or failure message upon quit
        if(solved){
            double timeEnd = System.currentTimeMillis();
            double tTotal = (timeEnd-timeStart)/1000;
            System.out.println(p);
            System.out.println("Congratulations! You solved it in "+moves+" moves!");
            System.out.println("You cleared it in "+tTotal+" seconds!");
        }
        else{
            System.out.println("You quit before the puzzle was solved :(");
        }
        //Asks the user if they want to start a new game rather than opening the
        //program again, loops back to prompt for board size
        boolean validResponse = false;
        while(!validResponse){
            System.out.println("Would you like to start a new puzzle? (Y)-Yes (N)-No");
            String response = input.next();
            if(response.equalsIgnoreCase("Y")){
                validResponse = true;
            }
            else if(response.equalsIgnoreCase("N")){
                validResponse = true;
                done = true;
            }
            else{
                System.out.println("Invalid Response");
            }
        }
            
    }
}
}
    
