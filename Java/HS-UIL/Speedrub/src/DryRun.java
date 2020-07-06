import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DryRun {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner fin = new Scanner(new File("dryrun.dat"));
        int lines = fin.nextInt();
        fin.nextLine();
        for (int i = 0; i < lines; i++) {
            String s = fin.nextLine();
            System.out.println(s + " fly together.");
        }
        fin.close();//ass poo poo cock lmao xd poggers
    }
}
