import java.awt.*;
import java.util.LinkedList;

public class Display {
    private double radius;

    public Display(BinaryTree t, double r){
        radius = r;
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 100);
        StdDraw.setYscale(0, 100);
        LinkedList<Node> nodes = new LinkedList<>();
        nodes.add(t.gerOrigin());
        Node curr;
        while(!nodes.isEmpty()){
            curr = nodes.poll();
            if(curr==null) break;
            if(curr.getIndex()!=-1){
                StdDraw.filledCircle(curr.getxCord(), curr.getyCord(), radius);
                try {
                    StdDraw.line(curr.getxCord(), curr.getyCord(), curr.getParent().getxCord(), curr.getParent().getyCord());
                }catch(Exception e){}
                StdDraw.text(curr.getxCord(), curr.getyCord(), ""+curr.getIndex());
            }
            nodes.add(curr.getLeftChild());
            nodes.add(curr.getRightChild());
        }
        StdDraw.show();
    }

    public void solve(LinkedList<Node> nodes) throws InterruptedException {
        StdDraw.setPenColor(Color.green);
        LinkedList<Node> history = new LinkedList<>();
        LinkedList<Node> newNodes = new LinkedList<>(); newNodes.addAll(nodes);
        history.addAll(nodes);
        while(!newNodes.isEmpty()){
            Node curr = newNodes.poll();
            StdDraw.filledCircle(curr.getxCord(), curr.getyCord(), radius);
            StdDraw.show();
            Thread.sleep(500);
        }
        StdDraw.setPenColor(Color.black);
        while(!history.isEmpty()){
            Node curr = history.poll();
            StdDraw.filledCircle(curr.getxCord(), curr.getyCord(), radius);
        }
        StdDraw.show();
    }
}
