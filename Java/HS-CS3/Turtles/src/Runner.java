import java.awt.*;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Math.sin(0.0));
        Turtle test = new Turtle();
        test.forward(10);
        test.setPenColor(Color.red);
        test.turnLeft();
        test.forward(20);
        test.turnRight();
        test.forward(10);
    }
}
