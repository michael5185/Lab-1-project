import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import java.util.Vector;

/*
 * Assignment:
 * 1. Fill in the neighbors() and site() methods in the Cell class.
 * 2. Fill in the pickRandomCell() and randomMaze() methods in the Maze class.
 * 3. Run the code.
 * 4. Based on the output, draw the maze on a piece of paper.
 *   Hint: Draw a 10x10 grid using a pencil and ruler. Then, for each line
 *     of output, erase the wall between the two pairs. For example, if
 *     one line of output is:
 *        0 0 0 1
 *     then erase the wall between cell (0, 0) and cell (0, 1).
 *   Hint 2: While you are working on your code, change ROWS and COLUMNS and
 *    make a 3x3 or 4x4 grid and draw it. That way, you don't spend too much
 *    time drawing the grid in case your code has a bug.
 *    x
 *
 *   Unless you are doing the extra credit challenge, do NOT add any new methods.
 *   Do not add any new classes.
 *
 *   For full credit, you must include comments that show the ideas behind your code.
 */

public class Maze {

    /*
     * Extra credit challenge:
     * 1. Can you eliminate the Cell class (as well as the "cells" instance variable)
     * and just use the WeightedQuickUnionUF?
     *
     */
    private class Cell {
        public int row;
        public int column;
        
        // our site method is a string which takes in the integer value of the row and the column
        // and changes it to a string combined together to show their position in terms of a coordinated
        // grid
        public int site() {
            String site = "";
            site += Integer.toString(row);
            site += Integer.toString(column);

            return(Integer.parseInt(site)); // REPLACE with your code
        }

        public Cell(int r, int c) {
            row = r;
            column = c;
        }
        // this method looks at the neighbors of our current Cell. it checks for boundaries by
        // looking ahead of it (by adding 1 to the current row/column) and seeing if it equals
        // to our boundaries (ROW-1/COLUMN-1)
        // in any case, we add everything surrounding it to its own neighbors method
        public Vector<Cell> neighbors() {
            Vector<Cell> neighbors = new Vector<>();

            if(row+1 <= ROWS-1){
                neighbors.add(cells[row+1][column]);
            }
            if(row-1 >= 0){
                neighbors.add(cells[row-1][column]);
            }
            if(column+1 <= COLUMNS-1){
                neighbors.add(cells[row][column+1]);
            }
            if(column-1 >= 0){
                neighbors.add(cells[row][column-1]);
            }

            return neighbors;
        }




    }

    private int ROWS = 10;
    private int COLUMNS = 10;
    private Cell[][] cells;
    private WeightedQuickUnionUF uf;
    
    // adding a vector that tracks cells that are connected to the cell(0,0), which is why we named it
    // path. A path from cell(0,0) to the end cell(9,9).
    private Vector<Cell> paths = new Vector<Cell>();

    public Maze() {
        uf = new WeightedQuickUnionUF(ROWS * COLUMNS);
        cells = new Cell[ROWS][COLUMNS];

        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLUMNS; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }

        //path stands for a path connected to cell(0,0). (all cells/vectors that are indirectly or
        //directly connected to cell(0,0).
        paths.add(cells[0][0]);
    }

    public Cell start() {
        return cells[0][0];
    }

    public Cell end() {
        return cells[ROWS - 1][COLUMNS - 1];
    }

    public static Cell pickRandom(Vector<Cell> cells) {
        return(cells.get(StdRandom.uniform(cells.size())));
    }

    private static void printWall(Cell c1, Cell c2) {
        // This prints a single wall that was knocked down.
        System.out.printf("%d %d %d %d\n", c1.row, c1.column, c2.row, c2.column);
    }
    
    //this function uses our paths vector to choose a random cell in it and return that
    public Cell pickRandomCell() {

        //in this approach, we will pick a random cell from the path vector, in this way, we won't
    	// have to waste time checking if two random cells match or are coordinated to each other
        return pickRandom(paths);

    }

    //randomMaze works by using uf.connected and uf.union.
    // uf.connected is used to check if a random cell from our path vector and its neighbors are 
    // connected.
    // if true, then we use uf.union on their corresponding coordinates to take care of that specific
    // cell (knock down its wall).
    // we also add the neighbor of our current cell into the paths vector to show that there was
    // a new addition to our path from cell(0,0) and cell(9,9).
    @SuppressWarnings("deprecation")
	public void randomMaze() {
        int startId = start().site();
        int endId = end().site();

        Cell randomPath;

        while(!uf.connected(startId,endId)) {
            randomPath =pickRandomCell();
            
            // approach: pickRandomCell() returns a random cells that are in the path vector
            Cell randomNeighbor = pickRandom(randomPath.neighbors());
            
            // if randomNeighbor and randomPath are not connected
            if (!uf.connected(randomPath.site(),randomNeighbor.site())) {
                uf.union(randomPath.site(),randomNeighbor.site()); // union the cells
                printWall(randomPath, randomNeighbor);
                paths.add(randomNeighbor); // and include the randomNeighbor to the path Vector.

            }
        }

    }


    public static void main(String[] args) {
        Maze m = new Maze();
        m.randomMaze();
        /*
        results
        "C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2019.3.2\jbr\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2019.3.2\lib\idea_rt.jar=53677:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2019.3.2\bin" -Dfile.encoding=UTF-8 -classpath C:\Users\danie\IdeaProjects\Maze\out\production\Maze;C:\Users\danie\Downloads\algs4.jar Maze
0 0 0 1
0 1 0 2
0 2 0 3
0 1 1 1
0 3 1 3
0 2 1 2
1 1 1 0
0 3 0 4
1 3 2 3
0 4 0 5
1 2 2 2
2 2 3 2
1 0 2 0
0 4 1 4
0 5 1 5
0 5 0 6
0 6 1 6
0 6 0 7
1 4 2 4
0 7 0 8
3 2 4 2
2 3 3 3
2 4 2 5
2 4 3 4
2 0 2 1
1 6 1 7
4 2 4 3
2 1 3 1
4 2 5 2
2 5 2 6
3 1 3 0
1 7 1 8
4 3 5 3
5 2 5 1
1 8 2 8
5 1 5 0
5 1 6 1
6 1 6 0
4 3 4 4
3 0 4 0
6 1 7 1
4 2 4 1
1 8 1 9
4 4 5 4
4 4 4 5
0 8 0 9
3 4 3 5
2 8 3 8
7 1 7 0
3 8 3 7
7 1 8 1
5 4 5 5
1 9 2 9
2 8 2 7
5 4 6 4
8 1 8 0
3 7 4 7
6 4 6 3
5 2 6 2
8 1 8 2
2 9 3 9
3 7 3 6
3 6 4 6
7 1 7 2
8 0 9 0
5 5 5 6
3 9 4 9
8 1 9 1
6 4 6 5
7 2 7 3
5 6 6 6
9 1 9 2
4 9 5 9
9 2 9 3
6 6 7 6
9 3 8 3
7 6 8 6
8 6 8 7
8 6 9 6
5 9 5 8
4 7 4 8
7 6 7 5
7 6 7 7
7 5 8 5
8 7 9 7
7 5 7 4
9 3 9 4
5 8 5 7
8 7 8 8
5 7 6 7
8 5 9 5
8 8 9 8
9 8 9 9
        */
    }
}
