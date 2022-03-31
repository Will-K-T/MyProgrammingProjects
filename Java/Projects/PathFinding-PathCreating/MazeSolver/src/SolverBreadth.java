import java.awt.*;
import java.util.LinkedList;

public class SolverBreadth {

    //89CFF0 - comments
    //98FF98 - markup
    //FFB6C1 - text
    //98FF98 - tag value
    //FFB6C1 - tag foreground
    //98FF98 - effects

    //region Vars
    int gridSize, square;
    int[][] dist;
    Node[][] prev;
    Picture maze;
    //endregion

    /**
     * Sets of vars and starts the search
     * @param maze
     * @param gridSize
     * @throws InterruptedException
     */
    public SolverBreadth(Picture maze, int gridSize) throws InterruptedException {
        //region Setting up vars with default values
        this.maze = maze;
        this.gridSize = (int)(Math.sqrt(gridSize));
        square = (int)(Math.sqrt(gridSize))+1;
        dist = new int[maze.height()/square][maze.width()/square];
        prev = new Node[maze.height()/square][maze.width()/square];
        //endregion

        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist[0].length; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }//Sets the distance of each spot in the distance array to Integer.MAX_VALUE to represent an infinite distance

        floodMaze();//Starts the breadth first flood

        maze.save("breadth.png");
    }

    /**
     * Recursively visits each parent node and sets it to a color based on its row and col
     * @param row
     * @param col
     * @throws InterruptedException
     */
    public void solveMaze(int row, int col) throws InterruptedException {
        //region Timer stuff
        Thread.sleep(1);
        maze.show();
        //endregion

        //makeSquare((square*row)+1, square*col+1, square, Color.white);
        makeSquare((square*row)+1, square*col+1, square, new Color(Color.HSBtoRGB(1f-(((row)/(float)(maze.height()/(gridSize+1))) + ((col)/(float)(maze.width()/(gridSize+1))))/2, 1f, 1f)));//Sets each node on the path to a rainbow color based on the nodes row and col

        if(prev[row][col]!=null) {
            solveMaze(prev[row][col].getrow(), prev[row][col].getcol());
        }//Checks if there is a parent node to move to and then moves to the parent node

        return;//Kills the recursive branch
    }

    /**
     * Fills a node on the maze with a color.
     * @param row
     * @param col
     * @param square
     * @param color
     */
    public void makeSquare(int row, int col, int square, Color color){
        if(col+square-1<maze.width() && row+square-1<maze.height()) {
            for (int i = 0; i < square - 1; i++) {
                for (int j = 0; j < square - 1; j++) {
                    maze.set(col + j, row + i, color);
                }
            }
        }
    }

    /**
     * Solves the maze by using a breadth first approach. This is done by using a queue.
     */
    public void floodMaze() throws InterruptedException {
        LinkedList<Node> nodes = new LinkedList<>();//Old fashion queue
        int r, c, distance;//Need these for later

        nodes.add(new Node(0, 0, 1));//Starting the whole search
        dist[0][0] = -1;//Making sure that the first node will never be checked again

        //region Storing the winning spot
        int winRow=0;
        int winCol=0;
        //endregion

        while(!nodes.isEmpty()){
            //region Making my life easy
            r = nodes.element().getrow();
            c = nodes.element().getcol();
            distance = nodes.element().getDistance();
            //endregion

            ///*
            Thread.sleep(1);
            maze.show();
             ///Timer Stuff

            if(maze.get((square*r)+1, square*c+1).equals(Color.red)){
                winRow = r;
                winCol = c;
            }//Stores the winning spot

            if(c<(maze.width()/(gridSize+1))-1 && maze.get(square*(c+1), (square*r)+1).equals(Color.white) && distance+1<dist[r][c+1]){
                nodes.add(new Node(r, c+1, distance+1));
                dist[r][c+1] = distance+1;
                prev[r][c+1] = nodes.element();
            }//Check Right

            if(r<(maze.width()/(gridSize+1))-1 && maze.get((square*c)+1, square*(r+1)).equals(Color.white) && distance+1<dist[r+1][c]){
                nodes.add(new Node(r+1, c, distance+1));
                dist[r+1][c] = distance+1;
                prev[r+1][c] = nodes.element();
            }//Check Down

            if((c)*(square)>0 && maze.get(square*c, (square*r)+1).equals(Color.white) && distance+1<dist[r][c-1]){
                nodes.add(new Node(r, c-1, distance+1));
                dist[r][c-1] = distance+1;
                prev[r][c-1] = nodes.element();
            }//Check Left

            if((r)*(square)>0 && maze.get((square*c)+1, square*(r)).equals(Color.white) && distance+1<dist[r-1][c]){
                nodes.add(new Node(r-1, c, distance+1));
                dist[r-1][c] = distance+1;
                prev[r-1][c] = nodes.element();
            }//Check Up

            //makeSquare((square*r)+1, square*c+1, square, new Color(Color.HSBtoRGB(1f-(((r)/(float)(maze.height()/(gridSize+1))) + ((c)/(float)(maze.width()/(gridSize+1))))/2, 1f, 1f)));
            makeSquare((square*r)+1, square*c+1, square, Color.black);//Set each node that has been looked at to black
            nodes.poll();//remove the current node
        }//Loop to check every single node by using a queue (Breadth first search)

        solveMaze(prev[winRow][winCol].getrow(), prev[winRow][winCol].getcol());//After every node has been looked at, solve the maze
    }
}