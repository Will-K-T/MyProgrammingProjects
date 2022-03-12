import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.FileHandler;

public class occurring_difference {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner yeet = new Scanner(new File("occurring_difference.dat"));
        while(yeet.hasNextLine()) {
            ArrayList<Number> nums = new ArrayList<>();
            String[] num = yeet.nextLine().split(" ");
            nums.add(new Number(Integer.parseInt(num[0])));
            for (int i = 1; i < num.length; i++) {
                boolean change = false;
                for (int j = 0; j < nums.size(); j++) {
                    if(Integer.parseInt(num[i])==nums.get(j).number){
                        nums.get(j).count();
                        change = true;
                    }
                }
                if(!change){
                    nums.add(new Number(Integer.parseInt(num[i])));
                }
            }
            Collections.sort(nums);
            System.out.println("The difference is "+Math.abs(nums.get(nums.size()-1).number-nums.get(0).number));
        }
    }
}

class Number implements Comparable<Number>{
    int number;
    int count = 0;

    public Number(int n){
        number = n;
        count++;
    }

    public void count(){
        count++;
    }

    @Override
    public int compareTo(Number o) {
        return this.count-o.count;
    }

    public String toString(){
        return number+" "+count;
    }
}
