public class Node {
    private int index;
    private Node leftChild;
    private Node rightChild;
    private Node parent;
    private int xCord;
    private int yCord;
    private int num;
    private int count;

    public Node(int i, int x, int y, Node p, int count, int n){
        this.count = count;
        num = n;
        index = i;
        xCord = x;
        yCord = y;
        parent = p;
    }

    public int getIndex() {
        return index;
    }

    public int getNum() {
        return num;
    }

    public int getCount(){ return count;}

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getParent(){ return parent; }

    public Node getRightChild() {
        return rightChild;
    }

    public int getxCord() {
        return xCord;
    }

    public int getyCord() {
        return yCord;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public String toString(){
        return index+"";
    }

}
