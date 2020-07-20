import java.awt.*;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        //numberOfBoxes * sqrt(gridSize) + ((numberOfBoxes+1))
        //111, 100
        Maze test;
        Picture pic = new Picture(501, 501);
        while(true) {
            test = new Maze(1001, 1001, 16, pic);

            new SolverDepth(test.getMaze(), 16);

            new SolverBreadth(test.getMaze(), 16);

            pic = clearPic(pic);
        }
    }

    public static Picture clearPic(Picture pic){
        for (int i = 0; i < pic.height(); i++) {
            for (int j = 0; j < pic.width(); j++) {
                pic.set(j, i, Color.black);
            }
        }
        return pic;
    }
}
