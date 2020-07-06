import java.util.LinkedList;

public class PostOrderTraversal {
    Node origin;
    LinkedList<Node> nodes;
    LinkedList<Node> test;

    public PostOrderTraversal(Node o){
        origin = o;
        PostOrder();
    }

    public void PostOrder(){
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
        if(start.getRightChild().getIndex()!=-1){
            recurse(start.getRightChild());
        }
        nodes.add(start);
        return start;
    }

    public LinkedList<Node> getNodes(){
        return this.nodes;
    }
}
