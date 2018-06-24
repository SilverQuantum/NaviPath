
package maze;
import java.awt.Point;
import java.util.LinkedList;

public class Main implements MazeListener {

    Maze maze;
    
    public static void main(String[] args) {
        Main main = new Main();
    }

    public Main() {
        maze = new Maze(40, 50);    //maze size
        maze.addMazeListener(this);
    }

    @Override
    public void MazeClicked(int row, int col) {
        ClairPathFinder path = new ClairPathFinder(maze);
        LinkedList list = path.findPath(row, col);
        maze.showPath(list.iterator());
    }
    
    public LinkedList Recursion(int row, int col) {
        LinkedList<Point> list = new LinkedList();
        for (int i = 10; i < 20; i++) {
            list.addFirst(new Point(i, i));
        }
        return(list);
    }

}
