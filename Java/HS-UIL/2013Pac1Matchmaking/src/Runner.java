//import jdk.nashorn.internal.parser.Scanner;
import java.util.*;
import java.io.File;
import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException {
        Scanner yeet = new Scanner(new File("match.dat"));
        int dataSets = yeet.nextInt();
        int[] teamOne = new int[5];
        int[] teamTwo = new int[5];
        for(int i=0; i<dataSets; i++){
            for(int j=0; j<5; j++){
                teamOne[j] = yeet.nextInt();
            }
            for(int j=0; j<5; j++){
                teamTwo[j] = yeet.nextInt();
            } // blah blah change for git
        }
    }
}
