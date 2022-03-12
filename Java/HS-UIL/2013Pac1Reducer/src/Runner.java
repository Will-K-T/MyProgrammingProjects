import java.io.File;
import java.io.IOError;
import java.io.IOException;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws IOException {
        Scanner yeet = new Scanner(new File("Reduced.txt"));
        int numOfCases = yeet.nextInt();
        yeet.nextLine();
        for(int i=0; i<numOfCases; i++){
            int numerator = yeet.nextInt();
            int denom = yeet.nextInt();
            int count = 0;
                for(int k=2; k<=Integer.min(numerator, denom); k++) {
                    if ((numerator % k == 0 && denom % k == 0)) {
                        count++;
                        numerator /= k;
                        denom /= k;
                        k--;
                    }
                }
            System.out.println(count);
        }
    }
}
