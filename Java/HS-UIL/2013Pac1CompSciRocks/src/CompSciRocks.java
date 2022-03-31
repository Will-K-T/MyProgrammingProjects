import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CompSciRocks {
    public static void main(String[] args) throws IOException {
        Scanner yeet =  new Scanner(new File("CompSciRocks.txt"));
        while(yeet.hasNext()) {
            int number = yeet.nextInt();
            for (int i = 0; i < number; i++) {
                System.out.println("Comp Sci Rocks!!");
            }
            System.out.println();
            System.out.println();
        }
    }
}
