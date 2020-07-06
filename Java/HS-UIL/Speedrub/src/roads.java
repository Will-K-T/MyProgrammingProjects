import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



public class roads {
    static char[][] map;
    static boolean[][] visited;
    static ArrayList<Node> nodes;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner yeet = new Scanner(new File("roads.dat"));
        while(yeet.hasNextLine()){
            map = new char[10][10];
            visited = new boolean[10][10];
            nodes = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                String line = yeet.nextLine();
                for (int j = 0; j < 10; j++) {
                    map[i][j] = line.charAt(j);
                    if(line.charAt(j)=='*'){
                        nodes.add(new Node(i, j));
                    }
                }
            }
            recurse(nodes.get(0).row, nodes.get(0).col);
            System.out.println(nodes.size()==0?"Good!":"No Good!");
            try {
                yeet.nextLine();
            }catch (Exception e){}
        }
    }

    public static void recurse(int row, int col){
        visited[row][col] = true;
        if(map[row][col]=='*') nodes.remove(0);
        if(row+1<10 && map[row+1][col]!='I' && !visited[row+1][col]){
            recurse(row+1, col);
        }
        if(col+1<10 && map[row][col+1]!='I' && !visited[row][col+1]){
            recurse(row, col+1);
        }
        if(row-1>-1 && map[row-1][col]!='I' && !visited[row-1][col]){
            recurse(row-1, col);
        }
        if(col-1>-1 && map[row][col-1]!='I' && !visited[row][col-1]){
            recurse(row, col-1);
        }
    }
}

class Node{
    int row;
    int col;

    public Node(int r, int c){
        row = r;
        col = c;
    }
}
