import java.util.Arrays;
import java.util.LinkedList;

public class Runner2 {
    static Node[][] visitedNodes = new Node[10][10];
    public static void main(String[] args) {
        boolean[][] visited = new boolean[10][10];
        Node[][] visitedNodes = new Node[10][10];
        LinkedList<Node> nodes = new LinkedList<>();
        int[][] maze = {{1,1,1,1,1,1,0,0,0,0},
                        {0,1,0,0,0,1,1,0,0,0},
                        {0,1,0,0,0,0,0,0,0,0},
                        {0,1,1,1,1,1,0,0,0,0},
                        {0,0,1,0,0,1,0,0,0,0},
                        {0,0,1,0,0,1,0,0,0,0},
                        {0,1,1,0,0,1,1,1,0,0},
                        {0,0,0,0,0,0,0,1,0,0},
                        {0,0,0,0,0,0,0,1,0,0},
                        {0,0,0,0,0,0,0,1,1,1}};
        /*
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                maze[i][j] = (int)(Math.random()*2);
            }
        }*/
        int distance = 0;
        nodes.add(new Node(0,0));
        while(!nodes.isEmpty()){
            distance++;
            //System.out.println(nodes);
            //System.out.println(Arrays.deepToString(visitedNodes));
            //System.out.println(Arrays.deepToString(visited));
            if(nodes.element().getcol() == 9 && nodes.element().getrow() == 9){
                findPath(9, 9);
            }
            if(nodes.element().getcol()+1<10 /*&& !visited[nodes.element().getrow()][nodes.element().getcol()+1]*/ && maze[nodes.element().getrow()][nodes.element().getcol()+1] == 1){
                nodes.add(new Node(nodes.element().getrow(), nodes.element().getcol()+1, distance, new Node(nodes.element().getrow(), nodes.element().getcol())));
                //visited[nodes.element().getrow()][nodes.element().getcol()+1] = true;
                visitedNodes[nodes.element().getrow()][nodes.element().getcol()] = nodes.element();
            }
            if(nodes.element().getrow()+1<10 /*&& !visited[nodes.element().getrow()+1][nodes.element().getcol()]*/ && maze[nodes.element().getrow()+1][nodes.element().getcol()] == 1){
                nodes.add(new Node(nodes.element().getrow()+1, nodes.element().getcol(), distance, new Node(nodes.element().getrow(), nodes.element().getcol())));
                //visited[nodes.element().getrow()+1][nodes.element().getcol()] = true;
                visitedNodes[nodes.element().getrow()][nodes.element().getcol()] = nodes.element();
            }
            if(nodes.element().getcol()-1>0 /*&& !visited[nodes.element().getrow()][nodes.element().getcol()-1]*/ && maze[nodes.element().getrow()][nodes.element().getcol()-1] == 1){
                nodes.add(new Node(nodes.element().getrow(), nodes.element().getcol()-1, distance, new Node(nodes.element().getrow(), nodes.element().getcol())));
                //visited[nodes.element().getrow()][nodes.element().getcol()-1] = true;
                visitedNodes[nodes.element().getrow()][nodes.element().getcol()] = nodes.element();
            }
            if(nodes.element().getrow()-1>0 /*&& !visited[nodes.element().getrow()-1][nodes.element().getcol()]*/ && maze[nodes.element().getrow()-1][nodes.element().getcol()] == 1){
                nodes.add(new Node(nodes.element().getrow()-1, nodes.element().getcol(), distance, new Node(nodes.element().getrow(), nodes.element().getcol())));
                //visited[nodes.element().getrow()-1][nodes.element().getcol()] = true;
                visitedNodes[nodes.element().getrow()][nodes.element().getcol()] = nodes.element();
            }
            nodes.remove();
        }

        for (int i = 0; i < visitedNodes.length; i++) {
            System.out.println(Arrays.toString(visitedNodes[i]));
        }
    }

    public static void findPath(int r, int c){
        if(visitedNodes[r][c] != null){
            findPath(visitedNodes[r][c].getrow(), visitedNodes[r][c].getcol());
            visitedNodes[r][c] = new Node(2,2);
        }
    }
}
