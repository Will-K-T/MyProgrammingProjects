import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Cards {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner yeet = new Scanner(new File("cards.dat"));
        int numOfSets = yeet.nextInt();
        yeet.nextLine();
        for (int i=0; i<numOfSets; i++){
            int count = 0;
            String line = yeet.nextLine();
            for (int j=0; j<line.length(); j++){ //0 - 48 9 - 57
                char c = line.charAt(j);
                if(   !(c >= 48 && c <= 57)   ){
                    count++;
                }
            }
            System.out.println(52-count);
        }
    }
}
