import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Middling {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("middling.dat"));
        int num = scan.nextInt();
        for (int i = 0; i < num; i++) {
            String[] strArr = scan.nextLine().split(" ");
            ArrayList<Double> doubleArr = new ArrayList<>();
            for (int j = 0; j < strArr.length; j++) {
                if (!(strArr[j].equals(""))) {
                    doubleArr.add((double) Integer.parseInt(strArr[j]));
                }
            }
            System.out.println(Math.round((forwardAve(doubleArr) + backwardAve(doubleArr)) / 2));
        }
    }
    public static double forwardAve(ArrayList<Double> a){
        while(a.size() > 1){
            a.set(1, (a.get(0) + a.get(1)) / 2) ;
            a.remove(0);
        }
        return a.get(0);
    }
    public static double backwardAve(ArrayList<Double> b){
        while(b.size() > 1){
            b.set(b.size() - 2, (b.get(0) + b.get(1)) / 2) ;
            b.remove(b.size() - 1);
        }
        return b.get(0);
    }
}
