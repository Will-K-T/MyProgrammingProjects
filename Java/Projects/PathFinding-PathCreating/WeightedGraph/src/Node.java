public class Node implements Comparable<Node>{

    //region Instance Vars
    String name;
    double weight;
    //endregion

    /**
     * Default constructor
     * @param n
     * @param w
     */
    public Node(String n, double w){
        name = n;
        weight = w;
    }

    /**
     * Gets the name of the node
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the weight of the node from its parent node
     * @return weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Compares two node objects
     * @param o
     * @return the node with the smallest weight
     */
    @Override
    public int compareTo(Node o) {
        if(this.getWeight()-o.getWeight()<0){
            return -1;
        }
        else if(this.getWeight()-o.getWeight()>0){
            return 1;
        }
        return 0;
    }

    /**
     * Creates a string representation of the node object
     * @return the name of the node and the weight of the node
     */
    public String toString(){
        return name+" "+weight;
    }
}