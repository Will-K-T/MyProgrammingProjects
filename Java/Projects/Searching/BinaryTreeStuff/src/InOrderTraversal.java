import java.util.LinkedList;

public class InOrderTraversal {
    Node origin;
    LinkedList<Node> nodes;
    LinkedList<Node> test;

    public InOrderTraversal(Node o){
        origin = o;
        InOrder();
    }

    public void InOrder(){
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
        if(start.getLeftChild().getIndex()!=-1){
            recurse(start.getLeftChild());
        }
        nodes.add(start);
        if(start.getRightChild().getIndex()!=-1){
            recurse(start.getRightChild());
        }
        return start;
    }

    public LinkedList<Node> getNodes(){
        return this.nodes;
    }
}
