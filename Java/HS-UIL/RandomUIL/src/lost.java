import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class lost {
    static String[][] map;
    static int[][] dist;
    static int count;
    static int startR;
    static boolean isSolved;
    static int startC;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner yeet = new Scanner(new File("lost.dat"));
        int dataSets = yeet.nextInt();
        for (int i = 0; i < dataSets; i++) {
            int row = yeet.nextInt();
            int col = yeet.nextInt();
            yeet.nextLine();
            map = new String[row][col];
            dist = new int[row][col];
            for (int j = 0; j < row; j++) {
                map[j] = yeet.nextLine().split("");
            }
            startR = 0;
            startC = 0;
            for (int j = 0; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    dist[j][k] = Integer.MAX_VALUE;
                    if(map[j][k].equals("S")){
                        startR = j;
                        startC = k;
                    }
                }
            }
            isSolved = false;
            count = 0;
            solveMaze(startR, startC);
        }
    }

    public static void solveMaze(int r, int c){
        LinkedList<Node> nodes = new LinkedList<>();
        nodes.add(new Node(map[r][c], r, c, 0));
        dist[r][c] = -1;
        while(!nodes.isEmpty()){
            Node curr = nodes.poll();
            int row = curr.getRow(); int col = curr.getCol(); String t = curr.getThing(); int dis = curr.getDist();
            if(t.equals("E")){
                System.out.println(dis);
                isSolved = true;
                break;
            }
            if(row+1<map.length && !map[row+1][col].equals("#") && dis+1<dist[row+1][col]){
                nodes.add(new Node(map[row+1][col], row+1, col, dis+1));
                dist[row+1][col] = dis+1;
            }
            if(col+1<map[0].length && !map[row][col+1].equals("#") && dis+1<dist[row][col+1]){
                nodes.add(new Node(map[row][col+1], row, col+1, dis+1));
                dist[row][col+1] = dis+1;
            }
            if(row-1>=0 && !map[row-1][col].equals("#") && dis+1<dist[row-1][col]){
                nodes.add(new Node(map[row-1][col], row-1, col, dis+1));
                dist[row-1][col] = dis+1;
            }
            if(col-1>=0 && !map[row][col-1].equals("#") && dis+1<dist[row][col-1]){
                nodes.add(new Node(map[row][col-1], row, col-1, dis+1));
                dist[row][col-1] = dis+1;
            }
        }
        System.out.print(isSolved?"":"Not Possible\n");
    }
}

class Node{
    String thing;
    int row;
    int col;
    int dist;

    public Node(String t, int r, int c, int d){
        thing = t;
        dist = d;
        row = r;
        col = c;
    }

    public String getThing() {
        return thing;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getDist() {
        return dist;
    }

    @Override
    public String toString() {
        return "Node{" +
                "thing='" + thing + '\'' +
                ", row=" + row +
                ", col=" + col +
                ", dist=" + dist +
                '}';
    }
}
