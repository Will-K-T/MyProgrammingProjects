import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner{
    static char[][] map;
    static boolean[][] visited;
    static boolean win;
    static ArrayList<ArrayList<String>> list = new ArrayList<>();
    public static void main(String[] args) throws FileNotFoundException {
        messWithLists();
        Scanner yeet = new Scanner(new File("blast.dat"));
        int startRow = 0, startCol = 0, endRow, endCol, energy;
        while(yeet.hasNext()){
            win = false;
            map = new char[10][10];
            visited = new boolean[10][10];
            for (int i = 0; i < 10; i++) {
                map[i] = yeet.nextLine().toCharArray();
            }
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if(map[i][j] == 'S'){
                        startRow = i;
                        startCol = j;
                    }
                    if(map[i][j] == 'E'){
                        endRow = i;
                        endRow = j;
                    }
                }
            }
            energy = yeet.nextInt();
            yeet.nextLine();
            solve(startRow, startCol, energy);
            System.out.println(win?"Escaped!":"Did not escape!");
        }
    }

    public static void messWithLists(){
        String[][] words = {{"I", "Like"}, {"2", "D"}, {"Array", "Lists"}};
        for (int i = 0; i < 3; i++) {
            list.add(new ArrayList<>());
            for (int j = 0; j < 2; j++) {
                list.get(i).add(words[i][j]);
            }
        }
        System.out.println(list);
        System.out.println();
        System.out.println();
    }

    public static void solve(int row, int col, int energy){
        visited[row][col] = true;
        if(map[row][col] == 'E' && energy>=0){
            win = true;
            return;
        }
        if(energy<0){
            return;
        }
        if(row+1<10 && !visited[row+1][col] && map[row+1][col] != 'X'){
            if(map[row+1][col] == '.' || map[row+1][col] == 'E'){
                solve(row+1, col, energy-1);
            }
            else if(map[row+1][col] == '*'){
                solve(row+1, col, energy-5);
            }
        }
        if(row-1>0 && !visited[row-1][col] && map[row-1][col] != 'X'){
            if(map[row-1][col] == '.' || map[row-1][col] == 'E'){
                solve(row-1, col, energy-1);
            }
            else if(map[row-1][col] == '*'){
                solve(row-1, col, energy-5);
            }
        }
        if(col+1<10 && !visited[row][col+1] && map[row][col+1] != 'X'){
            if(map[row][col+1] == '.' || map[row][col+1] == 'E'){
                solve(row, col+1, energy-1);
            }
            else if(map[row][col+1] == '*'){
                solve(row, col+1, energy-5);
            }
        }
        if(col-1>0 && !visited[row][col-1] && map[row][col-1] != 'X'){
            if(map[row][col-1] == '.' || map[row][col-1] == 'E'){
                solve(row, col-1, energy-1);
            }
            else if(map[row][col-1] == '*'){
                solve(row, col-1, energy-5);
            }
        }
        return;
    }

}
