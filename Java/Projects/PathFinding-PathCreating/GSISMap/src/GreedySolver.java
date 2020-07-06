import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GreedySolver {
    private int[][] heightMap;
    private Picture map;
    private int startCol;

    public GreedySolver(int[][] heightMap, Picture map) throws InterruptedException {
        Scanner yeet = new Scanner(System.in);
        this.heightMap = heightMap;
        this.map = map;
        int bestPathRow = 0;
        int min = Integer.MAX_VALUE;
        //System.out.print("What is the starting col :: ");
        //startCol = yeet.nextInt();
        startCol = 0;
        for (int i = 0; i < map.height()-1; i++) {
            int temp = solve(i,startCol);
            if(temp<min){
                min = temp;
                bestPathRow = i;
            }
        }
        traceBestPath(bestPathRow, startCol);
    }

    public Node findSmallest(ArrayList<Node> nodes, int height){
        Node smallest = nodes.get(0);
        int smallDelta = Math.abs(height-nodes.get(0).getHeight());
        for (int i = 1; i < nodes.size(); i++) {
            int delta = Math.abs(height-nodes.get(i).getHeight());
            if(delta<smallDelta){
                smallest = nodes.get(i);
            }/*
            if(nodes.get(i).getHeight()<smallest.getHeight()){
                smallest = nodes.get(i);
            }//*/
        }
        return smallest;
    }

    public void traceBestPath(int r, int c){
        int row = r;
        int col = c;
        boolean[][] visited = new boolean[heightMap.length][heightMap[0].length];
        ArrayList<Node> sides;
        while(col<map.width()-1){
            map.show();
            sides = new ArrayList<>();
            map.set(col, row, Color.GREEN);
            visited[row][col] = true;
            if(row-1>0 && !visited[row-1][col]){
                sides.add(new Node(row-1, col, heightMap[row-1][col]));
            }
            if(row+1<map.height() && !visited[row+1][col]){
                sides.add(new Node(row+1, col, heightMap[row+1][col]));
            }
            if(col+1<map.width() && !visited[row][col+1]){
                sides.add(new Node(row, col+1, heightMap[row][col+1]));
            }
            Node temp = findSmallest(sides, heightMap[row][col]);
            row = temp.getRow();
            col = temp.getCol();
        }
    }

    public int solve(int r, int c) throws InterruptedException {
        int row = r;
        int col = c;
        int distance = 0;
        boolean[][] visited = new boolean[heightMap.length][heightMap[0].length];
        ArrayList<Node> sides;
        while(col<map.width()-1){
            map.show();
            Thread.sleep(1);
            sides = new ArrayList<>();
            map.set(col, row, Color.RED);
            visited[row][col] = true;
            if(row-1>0 && !visited[row-1][col] && !map.get(col, row-1).equals(Color.RED)){
                sides.add(new Node(row-1, col, heightMap[row-1][col]));
            }
            if(row+1<map.height() && !visited[row+1][col] && !map.get(col, row+1).equals(Color.RED)){
                sides.add(new Node(row+1, col, heightMap[row+1][col]));
            }
            if(col+1<map.width() && !visited[row][col+1] && !map.get(col+1, row).equals(Color.RED)){
                sides.add(new Node(row, col+1, heightMap[row][col+1]));
            }
            if(sides.size()==0){
                break;
            }
            Node temp = findSmallest(sides, heightMap[row][col]);
            row = temp.getRow();
            col = temp.getCol();
            distance++;
        }
        return distance;
    }
}
