import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner working = new Scanner(new File("test.txt"));
        String[] line = working.nextLine().split(",");


        //new BloodSugars("test.txt");
        new BloodSugars("2020-01-09.csv");
    }
}
