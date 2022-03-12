import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FirstLetter {
    public static void main(String[] args) throws IOException {
        Scanner yeet = new Scanner(new File("FirstLetter.txt"));
        int nuymberOfSets = yeet.nextInt();
        yeet.nextLine();
        for(int i=0; i<nuymberOfSets; i++){
            String word = yeet.nextLine();
            for(int j=0; j<word.length(); j++){
                System.out.print(word.charAt(0));
            }
            System.out.println();
        }
    }
}
