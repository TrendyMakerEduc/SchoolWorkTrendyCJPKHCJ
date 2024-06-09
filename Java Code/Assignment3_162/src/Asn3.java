//Name  : Daniel Trenholm
//ID    : 201202966
//Email : x2012cml@stfx.ca

import maze.Cell;
import maze.Maze;
import maze.MazeRenderer;
import maze.MazeSolver;

import java.util.Set;

public class Asn3 {
    private static final String RELATIVE_RESOURCES = "./resources/maze/";

    public static void main(String[] args) {
//What I noticed about this maze solver is it likes to check the openings that travel off the path, but return to the correct path
        //Maze 1 test
        System.out.println("Maze 1 Solved!" + "\n"); // For identification
        MazeSolver mazeSolve1 = new AStarMazeSolver(); // Create a MazeSolver (in other words the class we used, DfsMazeSolver)
        Maze maze1 = Maze.fromFile(RELATIVE_RESOURCES + "maze3.txt"); // This uses the maze.fromFile method to read the text file from its path.
        Set<Cell> solution1 = mazeSolve1.solve(maze1); // Solution is recorded as a set of cells
        MazeRenderer renderer1 = new MazeRenderer(); // We create the MazeRenderer
        String o1 = renderer1.render(maze1, solution1); // We render the solution into a string object
        System.out.println(o1 + "\n"); // We print out the string with a new line, these steps are the same for the other two maze test solutions.

    }
}
