public class Node {
    int row;
    int col;
    int distance;
    Node parent;

    public Node(int row, int col){
        this.row = row;
        this.col = col;
    }

    public Node(int row, int col, int distance){
        this.row = row;
        this.col = col;
        this.distance = distance;
    }

    public Node(int row, int col, int distance, Node parent){
        this.row = row;
        this.col = col;
        this.distance = distance;
        this.parent = parent;
    }

    public int getrow(){
        return this.row;
    }
    
    public int getcol(){
        return this.col;
    }

    public int getDistance(){
        return this.distance;
    }

    public String toString(){
        return getrow()+" "+getcol();
    }
}