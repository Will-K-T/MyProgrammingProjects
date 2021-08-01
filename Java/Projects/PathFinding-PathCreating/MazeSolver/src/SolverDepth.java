import java.awt.*;
import java.util.Stack;

public class SolverDepth {

    //region Vars
    Picture maze;
    int gridSize, square;
    //endregion

    /**
     * Sets up vars and starts the search
     * @param maze
     * @param gridSize
     * @throws InterruptedException
     */
    public SolverDepth(Picture maze, int gridSize) throws InterruptedException {
        this.maze = maze;
        square = (int)(Math.sqrt(gridSize))+1;
        this.gridSize = (int)(Math.sqrt(gridSize));
        solveMaze();
        maze.show();
        maze.save("depth.png");
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
     * Solves the maze by using a breadth first approach. This is done by using a stack.
     * @throws InterruptedException
     */
    public void solveMaze() throws InterruptedException {
        boolean moved = false;
        Stack<Node> mazeNodes = new Stack<>();
        boolean[][] visited = new boolean[maze.height()/(gridSize+1)][maze.width()/(gridSize+1)];
        mazeNodes.push(new Node(0,0));
        Color line;
        line = new Color(Color.HSBtoRGB(1f, 1f, 1f));
        makeSquare(1,1,gridSize+1, line);
        visited[mazeNodes.peek().getrow()][mazeNodes.peek().getcol()] = true;
        while(!mazeNodes.empty()){
            Thread.sleep(1);
            maze.show();
            if(mazeNodes.peek().getcol()<(maze.width()/(gridSize+1))-1 && !visited[mazeNodes.peek().getrow()][mazeNodes.peek().getcol()+1] && maze.get(square*(mazeNodes.peek().getcol()+1), (square*mazeNodes.peek().getrow())+1).equals(Color.white)){
                mazeNodes.push(new Node(mazeNodes.peek().getrow(), mazeNodes.peek().getcol()+1));
                if(maze.get(square*mazeNodes.peek().getcol()+1, (square*mazeNodes.peek().getrow())+1).equals(Color.red)){
                    break;
                }
                line = new Color(Color.HSBtoRGB(1f-(((mazeNodes.peek().getrow())/(float)(maze.height()/(gridSize+1))) + ((mazeNodes.peek().getcol())/(float)(maze.width()/(gridSize+1))))/2, 1f, 1f));
                makeSquare((square*mazeNodes.peek().getrow())+1, square*mazeNodes.peek().getcol()+1, square, line);
                visited[mazeNodes.peek().getrow()][mazeNodes.peek().getcol()] = true;
                moved = true;
            }
            if(mazeNodes.peek().getrow()<(maze.width()/(gridSize+1))-1 && !visited[mazeNodes.peek().getrow()+1][mazeNodes.peek().getcol()] && maze.get((square*mazeNodes.peek().getcol())+1, square*(mazeNodes.peek().getrow()+1)).equals(Color.white)){
                mazeNodes.push(new Node(mazeNodes.peek().getrow()+1, mazeNodes.peek().getcol()));
                if(maze.get((square*mazeNodes.peek().getcol())+1, square*mazeNodes.peek().getrow()+1).equals(Color.red)){
                    break;
                }
                line = new Color(Color.HSBtoRGB(1f-(((mazeNodes.peek().getrow())/(float)(maze.height()/(gridSize+1))) + ((mazeNodes.peek().getcol())/(float)(maze.width()/(gridSize+1))))/2, 1f, 1f));
                makeSquare(square*mazeNodes.peek().getrow()+1, (square*mazeNodes.peek().getcol())+1, square, line);
                visited[mazeNodes.peek().getrow()][mazeNodes.peek().getcol()] = true;
                moved = true;
            }
            if((mazeNodes.peek().getcol())*(square)>0 && !visited[mazeNodes.peek().getrow()][mazeNodes.peek().getcol()-1] && maze.get(square*mazeNodes.peek().getcol(), (square*mazeNodes.peek().getrow())+1).equals(Color.white)){
                mazeNodes.push(new Node(mazeNodes.peek().getrow(), mazeNodes.peek().getcol()-1));
                if(maze.get((square*mazeNodes.peek().getcol())+1, (square*mazeNodes.peek().getrow())+1).equals(Color.red)){
                    break;
                }
                line = new Color(Color.HSBtoRGB(1f-(((mazeNodes.peek().getrow())/(float)(maze.height()/(gridSize+1))) + ((mazeNodes.peek().getcol())/(float)(maze.width()/(gridSize+1))))/2, 1f, 1f));
                makeSquare((square*mazeNodes.peek().getrow())+1, (square*mazeNodes.peek().getcol())+1, square, line);
                visited[mazeNodes.peek().getrow()][mazeNodes.peek().getcol()] = true;
                moved = true;
            }
            if((mazeNodes.peek().getrow())*(square)>0 && !visited[mazeNodes.peek().getrow()-1][mazeNodes.peek().getcol()] && maze.get((square*mazeNodes.peek().getcol())+1, square*(mazeNodes.peek().getrow())).equals(Color.white)){
                mazeNodes.push(new Node(mazeNodes.peek().getrow()-1, mazeNodes.peek().getcol()));
                if(maze.get((square*mazeNodes.peek().getcol())+1, square*(mazeNodes.peek().getrow())+1).equals(Color.red)){
                    break;
                }
                line = new Color(Color.HSBtoRGB(1f-(((mazeNodes.peek().getrow())/(float)(maze.height()/(gridSize+1))) + ((mazeNodes.peek().getcol())/(float)(maze.width()/(gridSize+1))))/2, 1f, 1f));
                makeSquare(square*(mazeNodes.peek().getrow())+1, (square*mazeNodes.peek().getcol())+1, square, line);
                visited[mazeNodes.peek().getrow()][mazeNodes.peek().getcol()] = true;
                moved = true;
            }
            if(!moved){
                Node poped = mazeNodes.pop();
                makeSquare((square*poped.getrow())+1, (square*poped.getcol())+1, square, Color.white);
            }
            moved = false;
        }

    }
}