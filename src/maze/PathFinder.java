package maze;

import java.util.LinkedList;

public class PathFinder {

    Maze maze;

    public PathFinder(Maze iMaze) {
        maze = iMaze;
    }

    //Recurssive method to find exit
    /* 
       INPUT: Row & column coordinate of the current position
              Direction where it previously came from (so it doesn't traverse it)
              LinkedList containing path to the exit
      OUTPUT: Next LinkedList coordinates to the exit
    */
    private boolean traverseMaze (int row, int col, char direction, LinkedList<Coordinate> path) {
        // initialized: false, will keep searching for a path until true
        boolean isAptStep = false;
        
        //recurssive method base case
        if (maze.isExit(row, col)) {
            return (true);
        } else {
            
            // check its previous direction where it came from and if the path is a dead-end
            if (direction != 'E' && !maze.hasEastWall(row, col) && isAptStep == false)
                isAptStep = traverseMaze(row, col + 1, 'W', path);            
            if (direction != 'S' && !maze.hasSouthWall(row, col) && isAptStep == false)
                isAptStep = traverseMaze(row + 1, col, 'N', path);  
            if (direction != 'W' && !maze.hasWestWall(row, col) && isAptStep == false)
                isAptStep = traverseMaze(row, col - 1, 'E', path);
            if (direction != 'N' && !maze.hasNorthWall(row, col) && isAptStep == false)
                isAptStep = traverseMaze(row - 1, col, 'S', path);
            
            // add correct path to list
            if (isAptStep)
                path.add(new Coordinate(row, col));
            
            return (isAptStep);
        }
    }
    
    public LinkedList<Coordinate> findPath(int startRow, int startColumn) {
        LinkedList<Coordinate> myPath = new LinkedList<Coordinate>();
        traverseMaze(startRow, startColumn, ' ', myPath); 
        return (myPath);
    }
}
