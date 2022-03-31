//Kinda need these to do stuff
import java.io.*;
import java.util.*;

public class Maze {
    //Going to need these later
    char[][] maze;
    int[][] dist;
    Node[][] prev;

    /**
     * Starts all of the maze solving stuff
     * @throws IOException
     */
    public Maze() throws IOException {
        Scanner yeet = new Scanner(new File("quest.dat")); //Gotta scan the data
        int num = yeet.nextInt(); //The number of mazes to come

        for (int i = 0; i < num; i++) {
            //Setting up all of the arrays that will be needed
            maze = new char[10][10];
            dist = new int[10][10];
            prev = new Node[10][10];

            yeet.nextLine(); //Getting on the next line to read in the maze

            //Going need these later
            int startRow=0, startCol=0, kRow=0, kCol=0;
            boolean kFound = false;

            for (int j = 0; j < 10; j++) {
                String line = yeet.nextLine();
                for (int k = 0; k < 10; k++) {
                    char let = line.charAt(k);
                    maze[j][k] = let;
                    dist[j][k] = Integer.MAX_VALUE;
                    if(let == 'K'){
                        kRow = j;
                        kCol = k;
                        kFound = true;
                    } //Records the rabbit pos
                    if(let == 'A'){
                        startRow = j;
                        startCol = k;
                        dist[startRow][startCol] = -1;
                    } //Records the start pos
                }
            } //Sets up the maze of chars, sets the distance array to infinity, stores the starting pos, and records the killer rabbit pos

            if(kFound) {
                if (kCol + 1 < 10) {
                    maze[kRow][kCol + 1] = '#';
                }
                if (kCol - 1 >= 0) {
                    maze[kRow][kCol - 1] = '#';
                }
                if (kRow + 1 < 10) {
                    maze[kRow + 1][kCol] = '#';
                }
                if (kRow - 1 >= 0) {
                    maze[kRow - 1][kCol] = '#';
                }
            } //If a killer rabbit is found, it is surround by walls so that if will be avoided later

            for (int j = 0; j < 10; j++) {
                System.out.println(Arrays.toString(maze[j]));
            } //I just wanted to see the maze

            floodMaze(startRow, startCol); //Starts the maze flood

            for (int j = 0; j < 10; j++) {
                System.out.println(Arrays.toString(maze[j]));
            } //I just wanted to see the solved maze

            //region I did not want to think about the "-"
            try{
                yeet.next();
            }catch (Exception e){
                continue;
            }
            //endregion

            System.out.println(); //Making the output readable

        } //Goes through all of the mazes
    }

    /**
     * Starts at the end point and recursively finds the best path back to the start
     * @param row
     * @param col
     */
    public void solveMaze(int row, int col){
        if(maze[row][col]=='.'){
            maze[row][col] = 'X';
            solveMaze(prev[row][col].getRow(), prev[row][col].getCol());
        } //Goes through the maze and puts an "X" on the best path
        return;
    }

    /**
     * Floods every spot in the maze to find the end point and then calls the solveMaze method
     * @param row
     * @param col
     */
    public void floodMaze(int row, int col){
        LinkedList<Node> nodes = new LinkedList<>(); //Old fashion queue
        int r, c, distance; //Instantiating vars to make the code more readable

        nodes.add(new Node(row, col, 1)); //Starting the flood by adding the starting point to the queue

        while(!nodes.isEmpty()){

            //region Making my life easier
            r = nodes.element().getRow();
            c = nodes.element().getCol();
            distance = nodes.element().getDist();
            //endregion

            if(maze[r][c] == 'H'){
                System.out.println("Row: "+r+" Col: "+c);
                solveMaze(prev[r][c].getRow(), prev[r][c].getCol());
                break;
            } //Finds the end point, calls the solveMaze method, and ends the loop

            if(c+1 < 10 && distance+1<dist[r][c+1] && (maze[r][c+1]=='.' || maze[r][c+1]=='H')){
                nodes.add(new Node(r, c+1, distance+1));
                dist[r][c+1] = distance+1;
                prev[r][c+1] = nodes.element();
            } //Checks if the Node to the right of the current Node is a valid move and then adds it to the queue

            if(r+1 < 10 && distance+1<dist[r+1][c] && (maze[r+1][c]=='.' || maze[r+1][c]=='H')){
                nodes.add(new Node(r+1, c, distance+1));
                dist[r+1][c] = distance+1;
                prev[r+1][c] = nodes.element();
            } //Checks if the Node below the current Node is a valid move and then adds it to the queue

            if(c-1 >= 0 && distance+1<dist[r][c-1] && (maze[r][c-1]=='.' || maze[r][c-1]=='H')){
                nodes.add(new Node(r, c-1, distance+1));
                dist[r][c-1] = distance+1;
                prev[r][c-1] = nodes.element();
            } //Checks if the Node to the left of the current Node is a valid move and then adds it to the queue

            if(r-1 >= 0 && distance+1<dist[r-1][c] && (maze[r-1][c]=='.' || maze[r-1][c]=='H')){
                nodes.add(new Node(r-1, c, distance+1));
                dist[r-1][c] = distance+1;
                prev[r-1][c] = nodes.element();
            } //Checks if the Node above the current Node is a valid move and then adds it to the queue

            nodes.poll(); //Removes the Node that was just checked so that the next Node can be checked

        } //Loop to keep going until all of the nodes have been checked or the end has been reached
    }
}
