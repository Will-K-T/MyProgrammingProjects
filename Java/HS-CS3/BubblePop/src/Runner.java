import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Runner {
    static int count = 0;
    static String[][] board = new String[10][10];
    static boolean[][] boolBoard = new boolean[10][10];
    public static void main(String[] args) throws FileNotFoundException {
        Scanner yeet = new Scanner(new File("bubblepop.dat"));
        for(int i=0; i<10; i++){
            board[i] = yeet.nextLine().split("");
        }
        int numOfCords = yeet.nextInt();
        int row, col;
        for(int i=0; i<numOfCords; i++){
            row = yeet.nextInt();
            col = yeet.nextInt();
            count = 0;
            count = pop(row, col);
            System.out.println(count>=3 ? "YES "+count : "NO");
        }
    }

    public static int pop(int row, int col){
        boolBoard[row][col] = true;
        count++;
        if(row+1<10 && !boolBoard[row+1][col] && board[row+1][col].equals(board[row][col])){
            pop(row+1, col);
        }
        if(row-1>0 && !boolBoard[row-1][col] && board[row-1][col].equals(board[row][col])){
            pop(row-1, col);
        }
        if(col+1<10 && !boolBoard[row][col+1] && board[row][col+1].equals(board[row][col])){
            pop(row, col+1);
        }
        if(col-1>0 && !boolBoard[row][col-1] && board[row][col-1].equals(board[row][col])){
            pop(row, col-1);
        }
        return count;
    }
}
