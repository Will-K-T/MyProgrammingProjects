public class Node implements Comparable<Node>{
    int row;
    int col;
    int height;
    Node parent;
    int distance;

    public Node(int row, int col, int height){
        this.row = row;
        this.col = col;
        this.height = height;
        this.parent = null;
        this.distance = Integer.MAX_VALUE;
    }

    public Node(int row, int col, int height, int distance){
        this.row = row;
        this.col = col;
        this.height = height;
        this.distance = distance;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getHeight() {
        return height;
    }

    public int getDistance(){
        return this.distance;
    }

    public void setDistance(int dist){
        this.distance = dist;
    }

    public void setParent(Node p){
        this.parent = p;
    }

    public Node getParent(){
        return this.parent;
    }

    public String toString(){
        return this.getRow()+" "+this.getCol()+" "+this.getHeight();
    }

    @Override
    public int compareTo(Node o) {
        int uke = 840-col;
        return (this.distance+uke)-(o.getDistance()+(840-o.getCol()));
    }
}
