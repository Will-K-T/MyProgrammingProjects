import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BinaryTree {
    private HashMap<Integer, ArrayList<Node>> nodes;
    private Scanner yeet;
    private Node origin;

    public BinaryTree(String file) throws FileNotFoundException {
        nodes = new HashMap<>();
        yeet = new Scanner(new File(file));
        createTree();
    }

    public void createTree(){
        int totalX = 100;
        origin = new Node(0, 50, 80, null, 1, 1);
        while(yeet.hasNextLine()){
            int vert = yeet.nextInt();
            Node c = searchTree(vert);
            c.setLeftChild(new Node(yeet.nextInt(), ((c.getNum()*2-1)*totalX/(int)Math.pow(2, c.getCount()+1)), c.getyCord()-10, c, c.getCount()+1, (c.getNum()*2-1)));
            c.setRightChild(new Node(yeet.nextInt(),((c.getNum()*2+1)*totalX/(int)Math.pow(2, c.getCount()+1)), c.getyCord()-10, c, c.getCount()+1, (c.getNum()*2+1)));
        }
    }

    public Node searchTree(int wanted){
        LinkedList<Node> nodes = new LinkedList<>();
        nodes.add(origin);
        Node curr;
        while(!nodes.isEmpty()){
            curr = nodes.poll();
            if(curr.getIndex() == wanted){
                return curr;
            }
            nodes.add(curr.getLeftChild());
            nodes.add(curr.getRightChild());
        }
        return null;
    }

    public Node gerOrigin(){
        return origin;
    }

    public String toString(){
        String result = "";
        for (Integer name: nodes.keySet()){
            String key = name.toString();
            String value = nodes.get(name).toString();
            result += key+": "+value+"\n";
        }
        return result;
    }
}