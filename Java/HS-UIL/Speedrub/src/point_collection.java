import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;



public class point_collection {
    public static String[][] board;
    //public static boolean[][] check;
    public static int max;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner yeet = new Scanner(new File("point_collection.dat"));
        while (yeet.hasNextLine())
        {
            max = 0;
            int moves = yeet.nextInt();
            yeet.nextLine();
            //check = new boolean[8][8];
            board = new String[8][8];
            for (int i = 0; i < 8; i++) {
                board[i] = yeet.nextLine().split("");
            }
            int startR = -1;
            int startC = -1;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if(board[i][j].equals("S"))
                    {
                        startR = i;
                        startC = j;
                    }
                }
            }
            boolean[][] check = new boolean[8][8];
            recurse(startR, startC, moves, 0, check);
            System.out.println(max);
            //System.out.println(startC + " " + startR);
            //System.out.println(moves);
            //max = 0;
            //System.out.println(Arrays.deepToString(board));
        }
    }

    public static void recurse(int r, int c, int moves, int score, boolean[][] check)
    {
        if (r < 0 || r > 7 || c < 0 || c > 7) return;

        boolean[][] meep =check;

        meep[r][c] = true;
        int s = score;

        if (board[r][c].equals("W")) return;
        //if(check[r][c] == true) return;

        try{
            int num = Integer.parseInt(board[r][c]);
            //System.out.println("uil is cringe");
            //System.out.println(num);
            if (!check[r][c]) s += num;
            check[r][c] = true;
        }
        catch (Exception e)
        {
            if (s > max) max = s;
            if(moves == 0) return;
            recurse(r-1,c,moves-1,s,meep);
            recurse(r+1,c,moves-1,s,meep);
            recurse(r,c-1,moves-1,s,meep);
            recurse(r,c+1,moves-1,s,meep);
            return;
        }
        if (s > max) max = s;
        if (moves == 0) return;
        recurse(r-1,c,moves-1,s,meep);
        recurse(r+1,c,moves-1,s,meep);
        recurse(r,c-1,moves-1,s,meep);
        recurse(r,c+1,moves-1,s,meep);
        return;
    }
}
