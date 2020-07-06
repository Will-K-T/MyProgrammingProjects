import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Q {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("q.dat"));
        ArrayList<Integer> hof = new ArrayList<>();
        hof.add(0, 0);
        hof.add(1, 1);
        hof.add(2, 1);
        for(int i = 3; i < 1000000; i++) {
            hof.add(i, hof.get(i - hof.get(i-1)) + hof.get(i-hof.get(i-2)));
        }
        int n = scan.nextInt();
        scan.nextLine();
        for(int i = 0; i < n; i++) {
            System.out.println(hof.get(scan.nextInt()));
        }
    }
}
