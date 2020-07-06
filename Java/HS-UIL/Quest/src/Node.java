public class Node {
    int row, col, dist; //Stuff that makes a Node a Node

    /**
     * Creates a Node
     * @param row
     * @param col
     * @param dist
     */
    public Node(int row, int col, int dist){
        this.row = row;
        this.col = col;
        this.dist = dist;
    }

    //region Gets

    /**
     * Gets the column of this Node
     * @return col
     */
    public int getCol(){
        return this.col;
    }

    /**
     * Gets the row of this Node
     * @return row
     */
    public int getRow(){
        return this.row;
    }

    /**
     * Gets the distance of this Node form the start of the maze
     * @return dist
     */
    public int getDist(){
        return this.dist;
    }
    //endregion

    public String toString(){
        return row+" "+col+" "+dist;
    } //You should know what this is
}
