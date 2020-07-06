import java.awt.*;
import java.io.FileNotFoundException;
import java.util.LinkedList;

public class Runner {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        BinaryTree tree = new BinaryTree("BinaryTree");
        System.out.print("Pre-Order traversal: "); PreOrderTraversal pre = new PreOrderTraversal(tree.gerOrigin()); LinkedList<Node> pres = new LinkedList<>(); pres.addAll(pre.getNodes());
        System.out.println();
        System.out.print("In-Order traversal: "); InOrderTraversal in = new InOrderTraversal(tree.gerOrigin());
        System.out.println();
        System.out.print("Post-Order traversal: "); PostOrderTraversal post = new PostOrderTraversal(tree.gerOrigin());
        Display test = new Display(tree, 2.5);
        while(true) {
            StdDraw.text(50, 90, "Pre-Order");
            test.solve(pres);
            whiteRec(50, 90, 10, 5);
            StdDraw.text(50, 90, "In-Order");
            test.solve(in.getNodes());
            whiteRec(50, 90, 10, 5);
            StdDraw.text(50, 90, "Post-Order");
            test.solve(post.getNodes());
            whiteRec(50, 90, 10, 5);
        }
    }

    public static void whiteRec(double x, double y, double hw, double hh){
        StdDraw.setPenColor(Color.white);
        StdDraw.filledRectangle(x, y, hw, hh);
        StdDraw.setPenColor(Color.black);
    }
}
