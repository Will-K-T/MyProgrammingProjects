import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class dryrun {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("dryrun.dat"));

        int n = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("I like " + scan.nextLine() + ".");
        }

        scan.close();
    }
}
