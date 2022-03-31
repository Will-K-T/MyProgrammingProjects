import java.util.Scanner;

public class Game {
    private Scanner yeet = new Scanner(System.in);
    private Node[][] board;
    private Screen sc;
    private boolean[][] visited;
    private boolean lost;
    private  int count;

    public Game(){
        startNewGame();
    }

    public void startNewGame(){
        System.out.print("How big would you like the board to be? ");
        String dim = yeet.next();
        System.out.print("\nHow many mines would you like? ");
        int mines = yeet.nextInt();
        generateMap(dim, mines);
        playGame();
    }

    public void generateMap(String dim, int mines){
        int row = Integer.parseInt(dim.substring(0, dim.indexOf("x")));
        int col = Integer.parseInt(dim.substring(dim.indexOf("x")+1));
        sc = new Screen(row*10, col*10);
        board = new Node[row][col];
        int randRow;
        int randCol;
        int m = mines;
        while(m!=0){
            randRow = (int)(Math.random()*board.length);
            randCol = (int)(Math.random()*board[0].length);
            if(board[randRow][randCol] == null){
                board[randRow][randCol] = new Node(false, true);
                m--;
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] == null){
                    board[i][j] = new Node(false, false);
                }
            }
        }
        findMines();
        sc.updateScreen(board);
    }

    public void findMines(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int count = 0;
                for (int k = -1; k < 2; k++) {
                    for (int l = -1; l < 2; l++) {
                        try {
                            if (board[i + k][j + l].getIsMine()) {
                                count++;
                            }
                        }catch (Exception e){
                            continue;
                        }
                    }
                }
                board[i][j].setMinesTouched(count);
            }
        }
    }

    public void playGame(){
        while(!sc.getLost() && !sc.getWin()) {
            sc.setClickedOnce();
            clickNode(sc.waitForMove());
        }
    }

    public void clickNode(int[] cords){
        int shift = cords[2];
        int col = cords[1] / 10;
        int row = cords[0] / 10;
        if(shift==0) {
            board[row][col].setIsClicked(true);
            visited = new boolean[board.length][board[0].length];
            if (board[row][col].getMinesTouched() == 0) {
                clickNode(row, col);
            }
        }
        else{
            board[row][col].setShift(!board[row][col].getShift());
            //board[row][col].setIsClicked(true);
        }
        sc.updateScreen(board);
    }

    public void clickNode(int row, int col){
        visited[row][col] = true;
        board[row][col].setIsClicked(true);
        if(col+1<board[0].length && !visited[row][col+1] && board[row][col+1].getMinesTouched()>=0){
            if(board[row][col+1].getMinesTouched()>0){
                board[row][col+1].setIsClicked(true);
                /*visited[row][col+1] = true;
                clickNode(row, col);*/
                if(row+1<board.length && !board[row+1][col+1].getIsMine()){
                    board[row+1][col+1].setIsClicked(true);
                }
                if(row-1>=0 && !board[row-1][col+1].getIsMine()){
                    board[row-1][col+1].setIsClicked(true);
                }
            }
            else if(board[row][col+1].getMinesTouched()==0){
                clickNode(row, col+1);
            }
        }
        if(row+1<board.length && !visited[row+1][col] && board[row+1][col].getMinesTouched()>=0){
            if(board[row+1][col].getMinesTouched()>0){
                board[row+1][col].setIsClicked(true);
                /*visited[row+1][col] = true;
                clickNode(row, col);*/
                if(col+1<board[0].length && !board[row+1][col+1].getIsMine()){
                    board[row+1][col+1].setIsClicked(true);
                }
                if(col-1>=0 && !board[row+1][col-1].getIsMine()){
                    board[row+1][col-1].setIsClicked(true);
                }
            }
            else if(board[row+1][col].getMinesTouched()==0){
                clickNode(row+1, col);
            }
        }
        if(col-1>=0 && !visited[row][col-1] && board[row][col-1].getMinesTouched()>=0){
            if(board[row][col-1].getMinesTouched()>0){
                board[row][col-1].setIsClicked(true);
                /*visited[row][col-1] = true;
                clickNode(row, col);*/
                if(row+1<board.length && !board[row+1][col-1].getIsMine()){
                    board[row+1][col-1].setIsClicked(true);
                }
                if(row-1>=0 && !board[row-1][col-1].getIsMine()){
                    board[row-1][col-1].setIsClicked(true);
                }
            }
            else if(board[row][col-1].getMinesTouched()==0){
                clickNode(row, col-1);
            }
        }
        if(row-1>=0 && !visited[row-1][col] && board[row-1][col].getMinesTouched()>=0){
            if(board[row-1][col].getMinesTouched()>0){
                board[row-1][col].setIsClicked(true);
                /*visited[row-1][col] = true;
                clickNode(row, col);*/
                if(col+1<board[0].length && !board[row-1][col+1].getIsMine()){
                    board[row-1][col+1].setIsClicked(true);
                }
                if(col-1>=0 && !board[row-1][col-1].getIsMine()){
                    board[row-1][col-1].setIsClicked(true);
                }
            }
            else if(board[row-1][col].getMinesTouched()==0){
                clickNode(row-1, col);
            }
        }
        return;
    }

}
