import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class herons {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner yeet = new Scanner(new File("herons.dat"));
        int data = yeet.nextInt();
        yeet.nextLine();
        for (int i = 0; i < data; i++) {
            String[] nums = yeet.nextLine().split(",");
            double a = Double.parseDouble(nums[0]);
            double b = Double.parseDouble(nums[1]);
            double c = Double.parseDouble(nums[2]);
            double s = (a+b+c)/2;
            double area = Math.sqrt((s*(s-a)*(s-b)*(s-c)));
            System.out.printf("%.3f%n", area);
        }
    }
}
