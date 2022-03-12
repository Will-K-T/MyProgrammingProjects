import java.awt.*; //Import needed to work with colors

public class MakePicture {

    //region Vars
    Picture flowers; //Picture object that will be used to display the program
    FlowerGrid flowerGrid; //FlowerGrid object to store a FlowerGrid object
    int squareSize; //Integer to store how many pixels each flower will take up on the image
    int numOfIterations; //Integer to store the number of iterations that the program has gone through
    //endregion

    //region Constructors
    /**
     * The MakePicture() sets all of the instance variables to the parameter values and instantiates a Picture object
     * Calls the autoIterations() method
     * @param width
     * @param height
     * @param grid
     * @param squareSize
     * @throws InterruptedException
     */
    public MakePicture(int width, int height, FlowerGrid grid, int squareSize) throws InterruptedException {
        flowers = new Picture(width, height);
        flowerGrid = grid;
        this.squareSize = squareSize;
        numOfIterations = 0;
        autoIterations();
    }
    //endregion

    //region Working Methods
    /**
     * The autoIterations() method continuously updates the image forever
     * Calls the updateImage() method
     * Calls the the show() method in the Picture class
     * Calls Thread.sleep() to make the program slow enough to be visible to the human eye
     * Calls the updateFlowerGrid() method in the FlowerGrid class
     * @throws InterruptedException
     */
    public void autoIterations() throws InterruptedException {
        while(true) {
            numOfIterations += 1;
            this.updateImage();
            flowers.show();
            Thread.sleep(10);
            flowerGrid.updateFlowerGrid();
        }
    }

    /**
     * The updateImage() method goes though the entire flowers image and creates a square of color to represent the living, and dead flowers
     * Calls the makeSquare() method
     * Calls the getFlowerGrid() method in the FlowerGrid class
     * Calls the getRows() method in the FlowerGrid class
     * Calls the getCols() method in the FlowerGrid class
     */
    public void updateImage(){
        for(int rows=0; rows<flowerGrid.getRows()/squareSize; rows++){
            for(int cols=0; cols<flowerGrid.getCols()/squareSize; cols++){
                try {
                    if (flowerGrid.getFlowerGrid()[rows][cols] == 1) {
                        makeSquare(rows*squareSize, cols*squareSize, Color.white);
                    } else if (flowerGrid.getFlowerGrid()[rows][cols] == 2) {
                        makeSquare(rows*squareSize, cols*squareSize, Color.green);
                    } else if (flowerGrid.getFlowerGrid()[rows][cols] == -1) {
                        makeSquare(rows*squareSize, cols*squareSize, Color.red);
                    } else {
                        makeSquare(rows*squareSize, cols*squareSize, Color.black);
                    }
                }catch (Exception e){ continue; }
            }
        }
    }

    /**
     * The makeSquare() method creates a square of size squareSize and of color color at the row, col
     * Calls the getCols() method in the FlowerGrid class
     * Calls the getRows() method in the FlowerGrid class
     * @param row
     * @param col
     * @param color
     */
    public void makeSquare(int row, int col, Color color){
        for(int i=row; i<row+squareSize; i++){
            for(int j=col; j<col+squareSize; j++){
                flowers.set(j%flowerGrid.getCols(), i%flowerGrid.getRows(), color);
            }
        }
    }
    //endregion

}