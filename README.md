# SlidePuzzle
This is an interactive sliding puzzle game. Users will be able to choose from various board sizes, and will then,
using letter inputs, maneuver around the puzzle in an attempt to get all the tiles in order.
The tiles are numbered, and the goal is to organize them from highest to lowest going by rows and down columns. 
Errors in input are handled such that the game state is not affected, and upon completion, a time and move counter will
be displayed. 

The project is divded into two files. The WhiteCastleSlider.java is the file the part of the program that interacts with the player, as well as starts and ends the game. When a valid puzzle size is given, a puzzle object (Puzzle.java) is instantiated. The object includes a custom toString method to give the user a clean representation of what their puzzle looks like.  
