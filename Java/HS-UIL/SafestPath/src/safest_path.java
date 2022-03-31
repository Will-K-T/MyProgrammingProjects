import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class safest_path {
    static String[][] map;
    static Node[][] pred;
    static int[][] weights;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner yeet = new Scanner(new File("safest_path.dat"));
        while(yeet.hasNextLine()){
            map = new String[8][8];
            pred = new Node[8][8];
            weights = new int[8][8];
            for (int i = 0; i < 8; i++) {
                map[i] = yeet.nextLine().split("");
            }
            try {
                yeet.nextLine();
            }catch (Exception e){}
            int startR=0;
            int startC=0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if(map[i][j].equals("S")){
                        startR = i;
                        startC = j;
                    }
                    weights[i][j] = Integer.MAX_VALUE;
                }
            }
            solve(startR, startC);
        }
    }


    public static void solve(int startR, int startC){
        PriorityQueue<Node> nodes = new PriorityQueue<>();
        nodes.add(new Node(startR, startC, map[startR][startC]));
        while (!nodes.isEmpty()){
            Node curr = nodes.poll();
            int row = curr.getR();
            int col = curr.getC();
            if(map[row][col].equals("E")){
                System.out.println(curr.getWeight());
                break;
            }
            if(row+1<8){
                Node temp = new Node(row+1, col, map[row+1][col]);
                if(curr.getWeight()+temp.getWeight()<weights[row+1][col]){
                    weights[row+1][col] = curr.getWeight()+temp.getWeight();
                    pred[row+1][col] = curr;
                    temp.setWeight(curr.getWeight()+temp.getWeight());
                    nodes.add(temp);
                }
            }
            if(col+1<8){
                Node temp = new Node(row, col+1, map[row][col+1]);
                if(curr.getWeight()+temp.getWeight()<weights[row][col+1]){
                    weights[row][col+1] = curr.getWeight()+temp.getWeight();
                    pred[row][col+1] = curr;
                    temp.setWeight(curr.getWeight()+temp.getWeight());
                    nodes.add(temp);
                }
            }
            if(row-1>=0){
                Node temp = new Node(row-1, col, map[row-1][col]);
                if(curr.getWeight()+temp.getWeight()<weights[row-1][col]){
                    weights[row-1][col] = curr.getWeight()+temp.getWeight();
                    pred[row-1][col] = curr;
                    temp.setWeight(curr.getWeight()+temp.getWeight());
                    nodes.add(temp);
                }
            }
            if(col-1>=0){
                Node temp = new Node(row, col-1, map[row][col-1]);
                if(curr.getWeight()+temp.getWeight()<weights[row][col-1]){
                    weights[row][col-1] = curr.getWeight()+temp.getWeight();
                    pred[row][col-1] = curr;
                    temp.setWeight(curr.getWeight()+temp.getWeight());
                    nodes.add(temp);
                }
            }
        }
    }
}

class Node implements Comparable<Node>{
    int r;
    int c;
    int weight;
    String s;
    /*•	‘R’ – Road (1)
•	‘B’ – Bridges (2)
•	‘W’ – Wilderness (4)
•	‘G’ – Goblins (5)
•	‘T’ – Trolls (9)
*/

    public Node(int r, int c, String s) {
        this.r = r;
        this.c = c;
        this.s = s;
        switch (s){
            case "R":
                weight = 1;
                break;
            case "B":
                weight = 2;
                break;
            case "W":
                weight = 4;
                break;
            case "G":
                weight = 5;
                break;
            case "T":
                weight = 9;
                break;
            default:
                weight = 0;
        }
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getWeight(){
        return weight;
    }

    public void setWeight(int w){
        this.weight = w;
    }

    public String toString(){
        return s+ " "+weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight-o.getWeight();
    }
}
