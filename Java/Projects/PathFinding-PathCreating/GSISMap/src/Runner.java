import java.io.FileNotFoundException;

public class Runner {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        Map test = new Map();
        Image blank = new Image(test.getMap());
        Image pic = new Image(test.getMap());
        GreedySolver dab = new GreedySolver(test.getMap(), pic.getMap());
        //AStarSolver haha = new AStarSolver(test.getMap(), pic.getMap());
    }
}
