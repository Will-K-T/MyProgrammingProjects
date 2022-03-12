import java.awt.*;
import java.util.Stack;

public class Maze{
    Picture maze;
    int gridSize;
    public Maze(int x, int y, int gridSize) throws InterruptedException {
        maze = new Picture(x, y);
        this.gridSize = gridSize;
        makeEmptyMaze();
        makeMaze();
        maze.show();
        maze.save("maze.png");
    }

    public Maze(int x, int y, int gridSize, Picture m) throws InterruptedException {
        maze = m;
        this.gridSize = gridSize;
        makeEmptyMaze();
        makeMaze();
        maze.show();
        maze.save("maze.png");
    }

    public void makeEmptyMaze() throws InterruptedException {
        int row;
        int col;
        int square = (int)(Math.sqrt(gridSize))+1;
        for(row=1; row<maze.height()-1; row+=square){
            for(col=1; col<maze.width()-1; col+=square){
                makeSquare(row, col, square, Color.white);
            }
        }
    }

    public void makeSquare(int row, int col, int square, Color color){
        if(col+square-1<maze.width() && row+square-1<maze.height()) {
            for (int i = 0; i < square - 1; i++) {
                for (int j = 0; j < square - 1; j++) {
                    maze.set(col + j, row + i, color);
                }
            }
        }
    }

    public void removeLine(int row, int col, char dir){
        int startRow;
        int startCol;
        switch (dir){
            case ('r'):
                startRow = (((int) (Math.sqrt(gridSize)) + 1) * row) + 1;
                startCol = (((int) (Math.sqrt(gridSize)) + 1) * col);
                for (int i = 0; i < (int) (Math.sqrt(gridSize)); i++) {
                    maze.set(startCol, startRow + i, Color.white);
                }
                break;
            case ('d'):
                startRow = (((int) (Math.sqrt(gridSize)) + 1) * row);
                startCol = (((int) (Math.sqrt(gridSize)) + 1) * col) + 1;
                for (int i = 0; i < (int) (Math.sqrt(gridSize)); i++) {
                    maze.set(startCol+i, startRow, Color.white);
                }
                break;
            case ('l'):
                startRow = (((int) (Math.sqrt(gridSize)) + 1) * row) + 1;
                startCol = (((int) (Math.sqrt(gridSize)) + 1) * col) + ((int)(Math.sqrt(gridSize)) + 1);
                for (int i = 0; i < (int) (Math.sqrt(gridSize)); i++) {
                    maze.set(startCol, startRow+i, Color.white);
                }
                break;
            case ('u'):
                startRow = (((int) (Math.sqrt(gridSize)) + 1) * row) + ((int)(Math.sqrt(gridSize)) + 1);
                startCol = (((int) (Math.sqrt(gridSize)) + 1) * col) + 1;
                for (int i = 0; i < (int) (Math.sqrt(gridSize)); i++) {
                    maze.set(startCol+i, startRow, Color.white);
                }
                break;
        }
    }

    public void createFinish(){
        int square = (int)(Math.sqrt(gridSize))+1;
        makeSquare(maze.height()-square, maze.width()-square, square, Color.red);
    }

    public void makeMaze() throws InterruptedException {
        int random;
        boolean moved = false;
        boolean[][] boolMaze = new boolean[maze.height()/((int)(Math.sqrt(gridSize))+1)][maze.width()/((int)(Math.sqrt(gridSize))+1)];
        Stack<Node> mazeStack = new Stack<>();
        mazeStack.push(new Node(0,0));
        boolMaze[mazeStack.peek().getrow()][mazeStack.peek().getcol()] = true;
        while(!mazeStack.empty()){
            do {
                if((mazeStack.peek().getcol()+1 < boolMaze.length &&!boolMaze[mazeStack.peek().getrow()][mazeStack.peek().getcol()+1]) || (mazeStack.peek().getrow()+1 < boolMaze.length && !boolMaze[mazeStack.peek().getrow()+1][mazeStack.peek().getcol()] )|| (mazeStack.peek().getcol()-1 > 0 && !boolMaze[mazeStack.peek().getrow()][mazeStack.peek().getcol()-1]) || (mazeStack.peek().getrow()-1 > 0 && !boolMaze[mazeStack.peek().getrow()-1][mazeStack.peek().getcol()])) {
                    random = (int) (Math.random() * 4);
                    if (mazeStack.peek().getcol() + 1 < boolMaze[0].length && random == 0 && !boolMaze[mazeStack.peek().getrow()][mazeStack.peek().getcol() + 1]) {
                        removeLine(mazeStack.peek().getrow(), mazeStack.peek().getcol()+1, 'r');
                        mazeStack.push(new Node(mazeStack.peek().getrow(), mazeStack.peek().getcol() + 1));
                        boolMaze[mazeStack.peek().getrow()][mazeStack.peek().getcol()] = true;
                        moved = true;
                    }
                    if (mazeStack.peek().getrow() + 1 < boolMaze.length && random == 1 && !boolMaze[mazeStack.peek().getrow() + 1][mazeStack.peek().getcol()]) {
                        removeLine(mazeStack.peek().getrow()+1, mazeStack.peek().getcol(), 'd');
                        mazeStack.push(new Node(mazeStack.peek().getrow()+1, mazeStack.peek().getcol()));
                        boolMaze[mazeStack.peek().getrow()][mazeStack.peek().getcol()] = true;
                        moved = true;
                    }
                    if (mazeStack.peek().getcol() - 1 >= 0 && random == 2 && !boolMaze[mazeStack.peek().getrow()][mazeStack.peek().getcol() - 1]) {
                        removeLine(mazeStack.peek().getrow(), mazeStack.peek().getcol()-1, 'l');
                        mazeStack.push(new Node(mazeStack.peek().getrow(), mazeStack.peek().getcol() - 1));
                        boolMaze[mazeStack.peek().getrow()][mazeStack.peek().getcol()] = true;
                        moved = true;
                    }
                    if (mazeStack.peek().getrow() - 1 >= 0 && random == 3 && !boolMaze[mazeStack.peek().getrow() - 1][mazeStack.peek().getcol()]) {
                        removeLine(mazeStack.peek().getrow()-1, mazeStack.peek().getcol(), 'u');
                        mazeStack.push(new Node(mazeStack.peek().getrow()-1, mazeStack.peek().getcol() ));
                        boolMaze[mazeStack.peek().getrow()][mazeStack.peek().getcol()] = true;
                        moved = true;
                    }
                }
                else{
                    mazeStack.pop();
                    moved = true;
                }
            }while (!moved);
            moved = false;
        }
        createFinish();
    }

    public Picture getMaze() {
        return this.maze;
    }
}