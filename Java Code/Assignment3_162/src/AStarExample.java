import maze.Cell;
import maze.Maze;
import maze.MazeSolver;

import java.util.HashSet;
import java.util.Set;

public class AStarExample implements MazeSolver {
    //A priority Queue is made to check open cells, which are the set of cells to be evaluated
    private LinkedPriorityQueue<Cell> openCells = new LinkedPriorityQueue<>();
    //Closed cells are the cells that are already evaluated
    // Two sets are made, one for returning, and one for checking if the collection contains that cell location
    Set<Cell> set = new HashSet<Cell>();
    Set<Cell> copiedSet = new HashSet<Cell>();


    public Set<Cell> solve(Maze maze) {
        process(maze);
        return set;

    }

    public int updateCostIfRequired(Cell other, Maze maze, int cost) {
        Cell start = maze.getStart();
        Cell end = maze.getEnd();
        int i, j;
        i = start.getX();
        j = start.getY();
        int k, l;
        k = other.getX();
        l = other.getY();
        int m, n;
        m = end.getX();
        n = end.getY();

        int getToXCost = Math.abs(((i - k) + (j - l)));

        int otherFinalCost = Math.abs((k - m) + (l - n)) + getToXCost;
        int startToEnd = Math.abs((k - m) + (l - n));
        if (otherFinalCost < (startToEnd + cost)) {
            return otherFinalCost;

        } else
            return startToEnd + cost;
    }

    public void process(Maze maze){
        Cell current = maze.getStart();
        int steps = 0;
        while(true){
            steps++;
            if(current != null && openCells.isEmpty() != true)
                current = openCells.dequeue();



            if(current.isEnd())
            return;
        Cell t;
        if (maze.isLocationInMaze(current.getX(), current.getY() + 1))  { //If the coordinates are visible in the maze
            if (maze.getCell(current.getX(), current.getY() + 1).isVisitable() && copiedSet.contains(maze.getCell(current.getX(), current.getY() + 1)) != true
            ) { // and the copiedSet of hashSet objects does not contain this cell object
                t = maze.getCell(current.getX(),current.getY() + 1);
                set.add(maze.getCell(t.getX(), t.getY()));
                copiedSet.add(maze.getCell(t.getX(), t.getY()));
                int s = updateCostIfRequired(t, maze, steps);
                openCells.enqueue(t, s);


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

        }
    }
}
