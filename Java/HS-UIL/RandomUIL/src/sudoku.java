import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class sudoku {
    static String[][] map;
    static Grid[][] sMap;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner yeet = new Scanner(new File("sudoku.dat"));
        int dataSets = yeet.nextInt();
        yeet.nextLine();
        for (int i = 0; i < dataSets; i++) {
            map = new String[9][9];
            sMap = new Grid[3][3];
            for (int j = 0; j < 9; j++) {
                if(yeet.hasNextLine()) {
                    map[j] = yeet.nextLine().split(" ");
                }
            }
            for (int j = 0; j < 9; j += 3) {
                for (int k = 0; k < 9; k += 3) {
                    sMap[j/3][k/3] = new Grid();
                    for (int l = j; l < j + 3; l++) {
                        for (int m = k; m < k + 3; m++) {
                            sMap[j/3][k/3].setSpot(map[l][m], l, m);
                        }
                    }
                }
            }
        }
    }

    public static String[][] getMap(){
        return map;
    }

    public static Grid[][] getsMap(){
        return sMap;
    }
}

class NodeS{
    int row;
    int col;
    int num;
    ArrayList<Integer> vertNums;
    ArrayList<Integer> horzNums;
    ArrayList<Integer> gridNums;
    public NodeS(int r, int c, int n){
        row = r;
        col = c;
        num = n;
        vertNums = new ArrayList<>();
        horzNums = new ArrayList<>();
        gridNums = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            vertNums.add(i);
            horzNums.add(i);
            gridNums.add(i);
        }
    }

    public void calcVert(int r, int c){
        TreeSet<Integer> col = new TreeSet<>();
        for (int i = 0; i < 9; i++) {
            col.add(Integer.parseInt(sudoku.getMap()[i][c]));
        }
        vertNums.removeAll(col);
    }

    public void calcHorz(int r, int c){
        TreeSet<Integer> row = new TreeSet<>();
        for (int i = 0; i < 9; i++) {
            row.add(Integer.parseInt(sudoku.getMap()[r][i]));
        }
        horzNums.removeAll(row);
    }

    public void calcGrid(int r, int c){
        Grid g = sudoku.getsMap()[r/3][c/3];

    }
}

class Grid{
    int[][] grid;

    public Grid(){
        grid = new int[3][3];
    }

    public void setSpot(String num, int r, int c){
        grid[r%3][c%3] = Integer.parseInt(num);
    }

    public String toString(){
        String res = "";
        for (int i = 0; i < grid.length; i++) {
            res += Arrays.toString(grid[i]);
        }
        return res;
    }
}