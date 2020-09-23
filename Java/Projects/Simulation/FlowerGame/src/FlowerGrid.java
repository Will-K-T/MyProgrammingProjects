public class FlowerGrid {

    //region Vars
    int[][] flowers; //Integer array to represent the state of each flower
    int rows; //Integer to store the total rows of the image
    int cols; //Integer to store the total columns of the image
    int squareSize; //Integer to store how many pixels each flower will take up on the image
    //endregion

    //region Constructors
    /**
     * The FlowerGrid constructor sets all of the instance variables to the parameter values and instantiates the flowers array
     * Calls the initFlowerGrid() method
     * @param rows
     * @param cols
     * @param squareSize
     */
    public FlowerGrid(int rows, int cols, int squareSize){
        this.squareSize = squareSize;
        flowers = new int[rows/squareSize][cols/squareSize];
        this.rows = rows;
        this.cols = cols;
        initFlowerGrid();
    }
    //endregion

    //region Working Methods
    /**
     * The initFlowerGrid() method sets every index of the flowers array to either a 1 (living flower) or a 0 (dead flower) at random
     * The initFlowerGrid() method is only called once at the instantiation of the FlowerGrid object
     * Calls the random() method in the Math class
     */
    public void initFlowerGrid(){
        double random;
        for(int row=0; row<flowers.length; row++){
            for(int col=0; col<flowers[row].length; col++){
                random = Math.random();
                if(random>.5){
                    flowers[row][col] = 1;
                }
            }
        }
    }

    /**
     * The connectedFlowers() method calculates the number of living flowers that are directly touching the flower at row, col in the flowers array
     * Calls the getSquareSize() method in the FlowerGrid class
     * @param row
     * @param col
     * @return An integer representing the number of living flowers that are touching flower at the index row, col in flowers
     */
    public int connectedFlowers(int row, int col){
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int checkRow = (((i+row)+rows/getSquareSize())%(rows/getSquareSize()));
                int checkCol = (((j+col)+cols/getSquareSize())%(cols/getSquareSize()));
                if(!(checkRow==row && checkCol==col) && (flowers[checkRow][checkCol] == 1 || flowers[checkRow][checkCol] == 2)){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * The updateFlowerGrid() method goes through all of the flowers in the flowers array and determines what each flower should do: die, stay the same, or come back to life
     * Calls the connectedFlowers() method
     * Calls the getRows() method in the FlowerGrid class
     * Calls the getCols() method in the FlowerGrid class
     * Calls the getSquareSize() method in the FlowerGrid class
     */
    public void updateFlowerGrid(){
        int[][] temp = new int[this.getRows()][this.getCols()];
        for(int row=0; row<this.getRows()/getSquareSize(); row++){
            for(int col=0; col<this.getCols()/getSquareSize(); col++){
                if (flowers[row][col] > 0) {
                    if (connectedFlowers(row, col) < 2 || connectedFlowers(row, col) > 3) {
                        temp[row][col] = -1;
                        temp[row][col] = 0;
                    } else if (connectedFlowers(row, col) <= 3) {
                        temp[row][col] = 1;
                    }
                }
                else if (flowers[row][col] <= 0 && connectedFlowers(row, col) == 3) {
                    temp[row][col] = 2;
                    temp[row][col] = 1;
                }
                else {
                    if(flowers[row][col] == -1){
                        temp[row][col] = 0;
                    }
                    else if(flowers[row][col] == 2){
                        temp[row][col] = 1;
                    }
                    else {
                        temp[row][col] = flowers[row][col];
                    }
                }
            }
        }
        flowers = temp;
    }
    //endregion

    //region gets
    /**
     * @return The integer array flowers
     */
    public int[][] getFlowerGrid(){
        return flowers;
    }

    /**
     * @return The integer rows
     */
    public int getRows(){
        return this.rows;
    }

    /**
     * @return The integer cols
     */
    public int getCols(){
        return this.cols;
    }

    /**
     * @return The integer squareSize
     */
    public int getSquareSize(){
        return this.squareSize;
    }
    //endregion

}