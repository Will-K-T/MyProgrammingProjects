import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Runner {
    static boolean[][] visited = new boolean[10][10];
    static char[][] map = new char[10][10];
    static String c = "WFBO";
    static ArrayList<Node> nodes = new ArrayList<>();
    public static void main(String[] args) throws FileNotFoundException {
        Scanner yeet = new Scanner(new File("floor_cleaner.dat"));
        for (int i = 0; i < 10; i++) {
            map[i] = yeet.nextLine().toCharArray();
        }
        while(yeet.hasNext()){
            String cord = yeet.next();
            int x = Integer.parseInt(cord.substring(1,2));
            int y = Integer.parseInt(cord.substring(3,4));
            map[y][x] = 'O';
        }
        //System.out.println(Arrays.deepToString(map));
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(map[i][j] == 'B'){
                    visit(i , j);
                }
            }
        }
        makeNodes();
        Collections.sort(nodes);
        System.out.println(nodes);
    }

    public static void makeNodes(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(!visited[i][j] && map[i][j] == '-'){
                    nodes.add(new Node(i, j));
                }
            }
        }
    }

    public static String visit(int row, int col){
        visited[row][col] = true;
        if(col+1 <= 9 && !visited[row][col+1] && map[row][col+1] == '-'){
            visit(row, col+1);
        }
        if(row+1 <= 9 && !visited[row+1][col] && map[row+1][col] == '-'){
            visit(row+1, col);
        }
        if(col-1 <= 9 && !visited[row][col-1] && map[row][col-1] == '-'){
            visit(row, col-1);
        }
        if(row-1 <= 9 && !visited[row-1][col] && map[row-1][col] == '-'){
            visit(row-1, col);
        }
        return "";
    }
}

class Node implements Comparable<Node>{
    int row;
    int col;

    public Node(int row, int col){
        this.row = row;
        this.col = col;
    }

    @Override
    public int compareTo(Node o) {
        if(this.col==o.col){
            return this.row-o.row;
        }
        return this.col-o.col;
    }

    public String toString(){
        return row+","+col;
    }
}
