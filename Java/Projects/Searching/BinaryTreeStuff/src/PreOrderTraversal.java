import java.util.LinkedList;

public class PreOrderTraversal {
    Node origin;
    LinkedList<Node> nodes;
    LinkedList<Node> test;

    public PreOrderTraversal(Node o){
        origin = o;
        preOrder();
    }

    public void preOrder(){
        nodes = new LinkedList<>();
        test = new LinkedList<>();
        Node curr;
        recurse(origin);
        test.addAll(nodes);
        while(!test.isEmpty()){
            curr = test.poll();
            System.out.print(curr+" ");
        }
    }

    public Node recurse(Node start){
        nodes.add(start);
        if(start.getLeftChild().getIndex()!=-1){
            recurse(start.getLeftChild());
        }
        if(start.getRightChild().getIndex()!=-1){
            recurse(start.getRightChild());
        }
        return start;
    }

    public LinkedList<Node> getNodes(){
        return this.nodes;
    }
}
