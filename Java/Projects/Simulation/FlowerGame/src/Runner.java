public class Runner {
    public static void main(String[] args) throws InterruptedException { //The main method starts the entire program by creating a FlowerGrid object and passing it into a MakePicture object
        FlowerGrid gridOne = new FlowerGrid(1000, 1000, 10);
        new MakePicture(gridOne.rows, gridOne.cols, gridOne, gridOne.getSquareSize());
    }
}