import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class DepthFirst {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {

        //vars
        Scanner file = new Scanner(new File("DFM"));
        int[][] maze = new int[file.nextInt()][file.nextInt()];
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        boolean solved = false;

        //setting up the maze from file
        file.nextLine();
        int counter = 0;
        int startRow = 0;
        int startCol = 0;
        int endRow = 0;
        int endCol = 0;
        while(file.hasNextLine()){
            String line = file.nextLine();
            for (int i = 0; i < line.length(); i++) {
                int currSpot = Integer.parseInt(line.substring(i, i+1));
                if(currSpot == 3){
                    startRow = counter;
                    startCol = i;
                }
                if(currSpot == 2){
                    endRow = counter;
                    endCol = i;
                }
                maze[counter][i] = currSpot;
            }
            counter++;
        }

        //setting up graphics
        int width = 500;
        int height = 500;
        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);
        int sqSize = width/maze.length;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if(maze[i][j] == 1) {
                    StdDraw.filledSquare(j*sqSize+sqSize/2, height-i*sqSize-sqSize/2, sqSize/2);
                }
            }
        }
        StdDraw.setPenColor(Color.GREEN);
        StdDraw.filledSquare(endCol*sqSize+sqSize/2, height-endRow*sqSize-sqSize/2, sqSize/2);

        //solving
        LinkedList<Node> nodes = new LinkedList<>();
        nodes.push(new Node(startRow, startCol));
        while(nodes.size()>0){
            Thread.sleep(100);
            Node currNode = nodes.peek();
            int cR = currNode.getRow();
            int cC = currNode.getCol();
            StdDraw.setPenColor(Color.CYAN);
            StdDraw.filledSquare(cC*sqSize+sqSize/2, height-cR*sqSize-sqSize/2, sqSize/2);
            visited[cR][cC] = true;

            if(maze[cR][cC] == 2){
                System.out.println("Win");
                System.out.println(cR+" "+cC);
                solved = true;
                break;
            }
            if(cC+1 < maze[0].length && maze[cR][cC+1] != 1 && !visited[cR][cC+1]){
                nodes.push(new Node(cR, cC+1, currNode));
            }
            else if(cR+1 < maze.length && maze[cR+1][cC] != 1 && !visited[cR+1][cC]){
                nodes.push(new Node(cR+1, cC, currNode));
            }
            else if(cC-1 >= 0 && maze[cR][cC-1] != 1 && !visited[cR][cC-1]){
                nodes.push(new Node(cR, cC-1, currNode));
            }
            else if(cR-1 >= 0 && maze[cR-1][cC] != 1 && !visited[cR-1][cC]){
                nodes.push(new Node(cR-1, cC, currNode));
            }
            else{
                StdDraw.setPenColor(Color.WHITE);
                StdDraw.filledSquare(cC*sqSize+sqSize/2, height-cR*sqSize-sqSize/2, sqSize/2);
                nodes.poll();
            }
        }
        if(!solved) {
            System.out.println("Maze not solvable");
        }
    }
}