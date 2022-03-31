import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class rat {
    static String[][] map;
    static Node[][] parents;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner yeet = new Scanner(new File("rat.dat"));
        int dataSets = yeet.nextInt();
        for (int i = 0; i < dataSets; i++) {
            int row = yeet.nextInt();
            int col = yeet.nextInt();
            yeet.nextLine();
            map = new String[row][col];
            parents = new Node[row][col];
            for (int j = 0; j < map.length; j++) {
                map[j] = yeet.nextLine().split("");
            }
            int startCol=0; int startRow=0;
            for (int j = 0; j < map.length; j++) {
                for (int k = 0; k < map[j].length; k++) {
                    if(map[j][k].equals("S")){
                        startRow = j;
                        startCol = k;
                    }
                }
            }
            parents[startRow][startCol] = new Node(0,0,-1);
            solveMaze(startRow, startCol);
        }
    }

    public static void countItUp(Node p){
        Node currN = p;
        int currR;
        int currC;
        int count = -1;
        while(currN.getDist()!=-1){
            count++;
            currR = currN.getRow();
            currC = currN.getCol();
            currN = parents[currR][currC];
        }
        System.out.println(count +" seconds");
    }

    public static void solveMaze(int sR, int sC){
        LinkedList<Node> nodes = new LinkedList<>();
        nodes.push(new Node(sR, sC, 0));
        int currR;
        int currC;
        int currD;
        Node currN;
        while (!nodes.isEmpty()){
            currN = nodes.poll();
            currR = currN.getRow();
            currD = currN.getDist();
            currC = currN.getCol();
            if(map[currR][currC].equals("E")){
                countItUp(currN);
                return;
            }
            if(currR+1<map.length && !map[currR+1][currC].equals("G") && (parents[currR+1][currC]==null || parents[currR+1][currC].getDist()>currN.getDist())){
                nodes.add(new Node(currR+1, currC, currD+1));
                parents[currR+1][currC] = currN;
            }
            if(currC+1<map[0].length && !map[currR][currC+1].equals("G") && (parents[currR][currC+1]==null || parents[currR][currC+1].getDist()>currN.getDist())){
                nodes.add(new Node(currR, currC+1, currD+1));
                parents[currR][currC+1] = currN;
            }
            if(currR-1>=0 && !map[currR-1][currC].equals("G") && (parents[currR-1][currC]==null || parents[currR-1][currC].getDist()>currN.getDist())){
                nodes.add(new Node(currR-1, currC, currD+1));
                parents[currR-1][currC] = currN;
            }
            if(currC-1>=0 && !map[currR][currC-1].equals("G") && (parents[currR][currC-1]==null || parents[currR][currC-1].getDist()>currN.getDist())){
                nodes.add(new Node(currR, currC-1, currD+1));
                parents[currR][currC-1] = currN;
            }
        }
        System.out.println("Oh Rem please help me");
    }
}

class Node{
    int row;
    int col;
    int dist;
    public Node(int r, int c, int d){
        row = r;
        col = c;
        dist = d;
    }

    public int getRow(){
        return this.row;
    }

    public int getCol(){
        return this.col;
    }

    public int getDist(){
        return this.dist;
    }
    public String toString(){
        return this.getRow()+" "+this.getCol();
    }
}