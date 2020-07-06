import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class cave_adventure {
    static String [][]  map;
    static boolean[][] visited;
    static boolean solved;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner yeet = new Scanner(new File("cave_adventure.dat"));
        while(yeet.hasNext()){
            map = new String[8][8];
            visited = new boolean[8][8];
            for (int i = 0 ; i < 8 ; i++) {
                map[i] = yeet.nextLine().split("");
            }
            if(yeet.hasNext()) {
                yeet.nextLine();
            }
            int startR=0, startC=0;
            dog: for (int i = 0 ; i < 8 ; i++) {
                for (int j = 0 ; j < 8 ; j++) {
                    if(map[i][j].equals("S")){
                        startC = j;
                        startR = i;
                        break dog;
                    }
                }
            }
            solved=false;
            solveMaze(startR, startC);
            System.out.println(solved?"Solvable":"No Solution");
        }
    }

    public static boolean solveMaze(int r, int c){
        visited[r][c] = true;
        if(map[r][c].equals("E")){
            solved = true;
            return true;
        }
        if(r+1<8 && !visited[r+1][c] && !map[r+1][c].equals("W")){
            if(map[r+1][c].equals("-") || map[r+1][c].equals("E") ){
                solveMaze(r+1, c);
            }
            else{
                if(r+2<8 && (map[r+2][c].equals("-") || map[r+2][c].equals("E"))){
                    visited[r+1][c] = true;
                    solveMaze(r+2, c);
                }
                else if(r+2<8 && map[r+2][c].equals("W")){
                    visited[r+1][c] = true;
                }
            }
        }
        if(c+1<8 && !visited[r][c+1] && !map[r][c+1].equals("W")){
            if(map[r][c+1].equals("-") || map[r][c+1].equals("E")){
                solveMaze(r, c+1);
            }
            else{
                if(c+2<8 && (map[r][c+2].equals("-") || map[r][c+2].equals("E"))){
                    visited[r][c+1] = true;
                    solveMaze(r, c+2);
                }
                else if(c+2<8 && map[r][c+2].equals("W")){
                    visited[r][c+1] = true;
                }
            }
        }
        if(r-1>=0 && !visited[r-1][c] && !map[r-1][c].equals("W")){
            if(map[r-1][c].equals("-") || map[r-1][c].equals("E")){
                solveMaze(r-1, c);
            }
            else{
                if(r-2>=0 && (map[r-2][c].equals("-") || map[r-2][c].equals("E"))){
                    visited[r-1][c] = true;
                    solveMaze(r-2, c);
                }
                else if(r-2>=0 && map[r-2][c].equals("W")){
                    visited[r-1][c] = true;
                }
            }
        }
        if(c-1>=0 && !visited[r][c-1] && !map[r][c-1].equals("W")){
            if(map[r][c-1].equals("-") || map[r][c-1].equals("E")){
                solveMaze(r, c-1);
            }
            else{
                if(c-2>=0 && (map[r][c-2].equals("-") || map[r][c-2].equals("E"))){
                    visited[r][c-1] = true;
                    solveMaze(r, c-2);
                }
                else if(c-2>=0 && map[r][c-2].equals("W")){
                    visited[r][c-1] = true;
                }
            }
        }
        return false;
    }
}
