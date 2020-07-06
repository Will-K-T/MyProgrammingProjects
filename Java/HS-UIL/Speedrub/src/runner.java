import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class runner {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner yeet = new Scanner(new File("runner.dat"));
        double hours = 0;
        double miles = 0;
        for (int i = 0; i < 5; i++) {
            miles += yeet.nextInt();
            hours += yeet.nextInt();
        }
        miles /= 5280;
        hours /= 60;
        double mph = miles / hours;
        System.out.printf("Your speed was %.3f miles per hour.", mph);
    }
}
