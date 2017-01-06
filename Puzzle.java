/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whitecastleslider;
import java.util.Random;
import java.util.ArrayList;
/**
 *
 * @author Christian
 */
public class Puzzle {
    //Upon creation of object, 2D array is put into scope as well as 
    //arraylist to be used in the shuffle method
    private ArrayList<Integer> unused = new ArrayList<Integer>();
    private int[][] slidePuzzle;
    
    //When puzzle is passed an argument, 2D array gets size and numbers needed
    //are added to arraylist
    public Puzzle(int size){
        slidePuzzle = new int[size][size];
        for(int i = 0; i < (size*size); i++){
            unused.add(i);
        }
    }
    
    //Using arraylist as a "picker" a random board is created
    public void shuffle(){
        ArrayList<Integer> tempUnused = new ArrayList<Integer>();
        for(int i = 0; i < unused.size(); i++){
            tempUnused.add(unused.get(i));
        }
        Random rng = new Random();
        for(int i = 0; i < slidePuzzle.length; i++){
            for(int j = 0; j < slidePuzzle.length; j++){
                int rand = rng.nextInt(tempUnused.size());
                slidePuzzle[i][j] = tempUnused.get(rand);
                tempUnused.remove(rand);
            }
        }
    }
    
    //Checks to see if the puzzle is solved
    //Going from left to right, and down rows, number must be in descending order
    public boolean isSolved(){
        int count = (slidePuzzle.length*slidePuzzle.length)-1;
        for(int i = 0; i < slidePuzzle.length; i++){
            for(int j = 0; j < slidePuzzle.length; j++){
                if(slidePuzzle[i][j] != count){
                        return false;
                    }
                    count--;    
        }
    }
        return true;
}
    
    /*For moving the blank space around the board, first the blank space is found,
      then, checks to see if the argument is invalid. Then, depending on the direction,
      the method checks to see if the blank space can be moved in that direction.
      If so, a swap is performed on the two tiles.
    */
    public void move(String direction)throws Exception{
        int rowSpot = 0;
        int colSpot = 0;
        for(int i = 0; i < slidePuzzle.length; i++){
            for(int j = 0; j < slidePuzzle.length; j++){
                if(slidePuzzle[i][j] == 0){
                    rowSpot = i;
                    colSpot = j;
                }
            }
        }
        if(!direction.equalsIgnoreCase("L") && !direction.equalsIgnoreCase("R")
                && !direction.equalsIgnoreCase("U") && !direction.equalsIgnoreCase("D")){
        
        throw new Exception("INCORRECT DIRECTION GIVEN");
   }
        if(direction.equalsIgnoreCase("U")){
            if(rowSpot == 0){
            throw new Exception("ERROR: CANNOT GO THAT DIRECTION");
        }
            else{
                int temp = slidePuzzle[rowSpot][colSpot];
                slidePuzzle[rowSpot][colSpot]=slidePuzzle[rowSpot-1][colSpot];
                slidePuzzle[rowSpot-1][colSpot]=temp;
            }
        }
        else if(direction.equalsIgnoreCase("D")){
            if(rowSpot == slidePuzzle.length-1){
                throw new Exception("ERROR: CANNOT GO THAT DIRECTION");
            }
            else{
                int temp = slidePuzzle[rowSpot][colSpot];
                slidePuzzle[rowSpot][colSpot]=slidePuzzle[rowSpot+1][colSpot];
                slidePuzzle[rowSpot+1][colSpot]=temp;
            }
        }
        else if(direction.equalsIgnoreCase("L")){
            if(colSpot == 0){
                throw new Exception("ERROR: CANNOT GO THAT DIRECTION");
            }
            else{
                int temp = slidePuzzle[rowSpot][colSpot];
                slidePuzzle[rowSpot][colSpot]=slidePuzzle[rowSpot][colSpot-1];
                slidePuzzle[rowSpot][colSpot-1]=temp;
            }
        }
        else if(direction.equalsIgnoreCase("R")){
            if(colSpot == slidePuzzle.length-1){
                throw new Exception("ERROR: CANNOT GO THAT DIRECTION");
            }
            else{
                int temp = slidePuzzle[rowSpot][colSpot];
                slidePuzzle[rowSpot][colSpot]=slidePuzzle[rowSpot][colSpot+1];
                slidePuzzle[rowSpot][colSpot+1]=temp;
            }
        }
}
    /*For showing the user their board, the blank space is actually a 0 for
      coding purposes, but to the user it is blank. All numbers are made 2
      digits for cleanliness purposes.*/ 
    public String toString(){
        String puzzle = "";
        for(int i = 0; i < slidePuzzle.length; i++){
            for(int j = 0; j < slidePuzzle.length; j++){
                if(slidePuzzle[i][j] == 0){
                    puzzle += "[  ]";
                }
                else{
                    if(slidePuzzle[i][j] < 10){
                        puzzle+= "[0"+ slidePuzzle[i][j] + "]";
                    }
                    else{
                         puzzle+= "[" + slidePuzzle[i][j] + "]";
                    }
                   
                }
            }
            puzzle += "\n";
        }
        return puzzle;
    }
}
