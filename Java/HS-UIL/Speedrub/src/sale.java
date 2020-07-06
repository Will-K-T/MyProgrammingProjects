import java.io.File;
import java.io.FileNotFoundException;
import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class sale {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner yeet = new Scanner(new File("sale.dat"));
        double[] nums = new double[3];
        ArrayList<Double> numbers = new ArrayList<>();
        numbers.add(yeet.nextDouble());
        numbers.add(yeet.nextDouble());
        numbers.add(yeet.nextDouble());
        Collections.sort(numbers);
        double total = (numbers.get(0)*.5) + numbers.get(1) +numbers.get(2);
        total *= 1.0825;
        System.out.printf("%.2f", total);
    }
}
