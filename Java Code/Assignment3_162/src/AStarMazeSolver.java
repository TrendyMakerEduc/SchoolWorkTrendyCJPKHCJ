//Name  : Daniel Trenholm
//ID    : 201202966
//Email : x2012cml@stfx.ca

import maze.Cell;
import maze.Maze;
import maze.MazeSolver;

import java.util.HashSet;
import java.util.Set;

public class AStarMazeSolver implements MazeSolver {
    //A priority Queue is made to check open cells, which are the set of cells to be evaluated
    private LinkedPriorityQueue<Cell> openCells = new LinkedPriorityQueue<>();
    // Two sets are made, one for returning, and one for checking if the collection contains that cell location
    Set<Cell> set = new HashSet<Cell>();
    Set<Cell> copiedSet = new HashSet<Cell>();


    public Set<Cell> solve(Maze maze) {
        //The bulk of the function, similar to the depth search, but uses a cost formula to generate a path

        process(maze);
        if(set.contains(maze.getEnd())) {
            return set; //Returns the set
        } else{
            set.removeAll(set);
            return set;
        }
    }

    public int updateCostIfRequired(Cell other, Maze maze, int cost) {
        Cell start = maze.getStart(); //for grabbing x y values
        Cell end = maze.getEnd(); //for grabbing x y values
        int i, j; // start integers
        i = start.getX();
        j = start.getY();
        int k, l; // current cell's integers
        k = other.getX();
        l = other.getY();
        int m, n; // end integers
        m = end.getX();
        n = end.getY();

        int getToXCost = Math.abs(((i - k) + (j - l))); //The cost to get to X

        int otherFinalCost = Math.abs((k - m) + (l - n)) + getToXCost; //The total value from start to x, to x to end
        int xToEnd = Math.abs((k - m) + (l - n)); //The calculation for current to end
        if (otherFinalCost < (xToEnd + cost)) { //if the total value is less then xtoEnd + number of steps to reach x
            return otherFinalCost; //Return total path value

        } else
            return xToEnd + cost; //else, return the x to end path + number of steps
    }

    public void process(Maze maze){
        Cell current = maze.getStart(); //Current starts at start
        int steps = 0; // Number of steps initialized to 0
        while(true){
            steps++; //steps increment
            if(current != null && openCells.isEmpty() != true) //if current is not null and priority queue is not empty
                current = openCells.dequeue(); //dequeue



            if(current.isEnd()) //if current == end, return to break the loop
                return;
            Cell t; //For simplicity in programming through the directions
            if (maze.isLocationInMaze(current.getX(), current.getY() + 1))  { //If the coordinates are visible in the maze
                if (maze.getCell(current.getX(), current.getY() + 1).isVisitable() && copiedSet.contains(maze.getCell(current.getX(), current.getY() + 1)) != true
                ) { // and the copiedSet of hashSet objects does not contain this cell object
                    t = maze.getCell(current.getX(),current.getY() + 1); //Cell t == the path we are traveling
                    set.add(maze.getCell(t.getX(), t.getY())); // set adds X and Y values
                    copiedSet.add(maze.getCell(t.getX(), t.getY())); //copied set for making sure we don't travel the same path
                    int s = updateCostIfRequired(t, maze, steps); //the priority value of the nodes get updated through this function
                    openCells.enqueue(t, s); //enqueue the cell with the priority value retrieved from above function


                }
            }
            // currents the east
            // The directions are the same as pointed out in currenting the north position, but coordinates have changed
            if (maze.isLocationInMaze(current.getX() + 1, current.getY())) {
                if (maze.getCell(current.getX() + 1, current.getY()).isVisitable() && copiedSet.contains(maze.getCell(current.getX() + 1, current.getY())) != true
                ) {
                    t = maze.getCell(current.getX() + 1,current.getY());
                    set.add(maze.getCell(t.getX(), t.getY()));
                    copiedSet.add(maze.getCell(t.getX(), t.getY()));
                    int s = updateCostIfRequired(t, maze, steps);
                    openCells.enqueue(t, maze.getEnd().getX() + t.getX());

                }
            }
            // currents the south
            // The directions are the same as pointed out in currenting the north position, but coordinates have changed
            if (maze.isLocationInMaze(current.getX(), current.getY() - 1)) {
                if (maze.getCell(current.getX(), current.getY() - 1).isVisitable() && copiedSet.contains(maze.getCell(current.getX(), current.getY() - 1)) != true
                ) {
                    t = maze.getCell(current.getX(),current.getY() - 1);
                    set.add(maze.getCell(t.getX(), t.getY()));
                    copiedSet.add(maze.getCell(t.getX(), t.getY()));
                    int s = updateCostIfRequired(t, maze, steps);
                    openCells.enqueue(t, s);
                }
            }
            //currents the west
            // The directions are the same as pointed out in currenting the north position, but coordinates have changed
            if (maze.isLocationInMaze(current.getX() - 1, current.getY())) {
                if (maze.getCell(current.getX() - 1, current.getY()).isVisitable() && copiedSet.contains(maze.getCell(current.getX() - 1, current.getY())) != true
                ) {
                    t = maze.getCell(current.getX() - 1,current.getY());
                    set.add(maze.getCell(t.getX(), t.getY()));
                    copiedSet.add(maze.getCell(t.getX(), t.getY()));

                    int s = updateCostIfRequired(t, maze, steps);
                    openCells.enqueue(t, s);
                }
            }
            //If you are interested in looking at the path, it can be found right here by uncommenting the below line
            //System.out.println(openCells);
        }

    }
}
