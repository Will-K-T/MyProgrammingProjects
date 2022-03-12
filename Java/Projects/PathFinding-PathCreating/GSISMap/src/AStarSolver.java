import java.awt.*;
import java.util.PriorityQueue;

public class AStarSolver {
    private int[][] heightMap;
    private Node[][] moreInfo;
    private Picture map;

    public AStarSolver(int[][] heightMap, Picture map) throws InterruptedException {
        this.heightMap = heightMap;
        this.map = map;
        moreInfo = new Node[heightMap.length][heightMap[0].length];
        for (int i = 0; i < heightMap.length; i++) {
            for (int j = 0; j < heightMap[0].length; j++) {
                moreInfo[i][j] = new Node(i, j, heightMap[i][j]);
            }
        }
        solve(0,0);
    }

    public void makePath(Node start){
        System.out.println("asdf");
        map.set(start.getCol(), start.getRow(), Color.red);
        if(start.getParent()!=null){
            makePath(start.getParent());
        }
        return;
    }

    public void solve(int row, int col) throws InterruptedException {
        PriorityQueue<Node> nodes = new PriorityQueue<>();
        moreInfo[row][col].setDistance(0);
        nodes.add(moreInfo[row][col]);
        int currRow;
        int currCol;
        while(!nodes.isEmpty()){
            //System.out.println(nodes);
            currRow = nodes.element().getRow();
            currCol = nodes.element().getCol();
            Node parent = nodes.poll();
            System.out.println(parent.getCol());
            map.set(parent.getCol(), parent.getRow(), Color.RED);
            map.show();
            Thread.sleep(1);
            if(parent.getCol()==moreInfo[0].length){
                nodes.clear();
                makePath(parent);
                break;
            }
            if(currRow-1>0){
                moreInfo[currRow-1][currCol].setDistance(parent.getDistance()+heightMap[currRow-1][currCol]);
                moreInfo[currRow-1][currCol].setParent(parent);
                nodes.add(moreInfo[currRow-1][currCol]);
            }
            if(currRow+1<map.height()){
                moreInfo[currRow+1][currCol].setDistance(parent.getDistance()+heightMap[currRow+1][currCol]);
                moreInfo[currRow+1][currCol].setParent(parent);
                nodes.add(moreInfo[currRow+1][currCol]);
            }
            if(currCol+1<map.width()){
                moreInfo[currRow][currCol+1].setDistance(parent.getDistance()+heightMap[currRow][currCol+1]);
                moreInfo[currRow][currCol+1].setParent(parent);
                nodes.add(moreInfo[currRow][currCol+1]);
            }/*
            if(currCol-1>0){
                moreInfo[currRow][currCol-1].setDistance(parent.getDistance()+heightMap[currRow][currCol-1]);
                moreInfo[currRow][currCol-1].setParent(parent);
                nodes.add(moreInfo[currRow][currCol-1]);
            }*/
        }
    }
}
