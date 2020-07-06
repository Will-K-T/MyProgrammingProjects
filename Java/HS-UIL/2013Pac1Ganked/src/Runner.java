import java.util.*;

import java.io.File;
import java.io.IOException;

public class Runner {
    static boolean win;
    static int r, c=0;
    static int row, col;
    static String[][] maze;
    static boolean[][] boolMaze;
    public static void main(String[] args) throws IOException {
        Scanner yeet = new Scanner(new File("Ganked.txt"));
        int numOfCases = yeet.nextInt();
        for(int i=0; i<numOfCases; i++){
            row = yeet.nextInt();
            col = yeet.nextInt();
            maze = new String[row][col];
            yeet.nextLine();
            for(int j=0; j<maze.length; j++){
                maze[j] = yeet.nextLine().split("");
            }
            boolean brek = false;
            for(int j=0; j<maze.length; j++){
                for(int k=0; k<maze[j].length; k++){
                    if(maze[j][k].equals("C")){
                        r = j;
                        c = k;
                        brek = true;
                        break;
                    }
                }
                if(brek){
                    break;
                }
            }
            win = false;
            boolMaze = new boolean[maze.length][maze[0].length];
            System.out.println(helpCap(r, c));
        }
    }
    public static String helpCap(int currR, int currC){
        if(maze[currR][currC].equals("Z")){
            win = true;
            return "";
        }
        else if(currR-1 >= 0 && !boolMaze[currR-1][currC] && (maze[currR-1][currC].equals("E") || (maze[currR-1][currC].equals("Z"))))
        {
            boolMaze[currR-1][currC] = true;
            helpCap(currR-1, currC);
        }
        else if(currR+1<maze.length && !boolMaze[currR+1][currC] && (maze[currR+1][currC].equals("E") || maze[currR+1][currC].equals("Z"))){
            boolMaze[currR+1][currC] = true;
            helpCap(currR+1, currC);
        }
        else if(currC-1>=0 && !boolMaze[currR][currC-1] && (maze[currR][currC-1].equals("E") || maze[currR][currC-1].equals("Z"))){
            boolMaze[currR][currC-1] = true;
            helpCap(currR, currC-1);
        }
        else if(currC+1<maze[0].length && !boolMaze[currR][currC+1] && (maze[currR][currC+1].equals("E") || maze[currR][currC+1].equals("Z"))){
            boolMaze[currR][currC+1] = true;
            helpCap(currR, currC+1);
        }
        if(win){
            return "I win";
        }
        return "I am stuck";
    }
}
