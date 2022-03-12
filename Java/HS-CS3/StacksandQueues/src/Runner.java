import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Runner {
    public static void main(String[] args) {
        StringTokenizer string;
        String math;
        do {
            System.out.print("Give me some math :: ");
            Scanner yeet = new Scanner(System.in);
            math = yeet.nextLine();
            string = new StringTokenizer(math, " ");
            System.out.println(postFixSolver(string));
        }while (true);
    }


    public static String postFixSolver(StringTokenizer string){
        Stack<Float> numbers = new Stack<>();
        float finalAns = 0;
        String curToken = "";
        while(string.hasMoreTokens()){
            curToken = string.nextToken();
            if(curToken.equals("+")){
                numbers.push(numbers.pop()+numbers.pop());
            }
            else if(curToken.equals("-")){
                numbers.push(-1*(numbers.pop()-numbers.pop()));
            }
            else if(curToken.equals("*")){
                numbers.push(numbers.pop()*numbers.pop());
            }
            else if(curToken.equals("/")){
                float bottomNumber = numbers.pop();
                float topNumber = numbers.pop();
                numbers.push(topNumber/bottomNumber);
            }
            else{
                numbers.push(Float.parseFloat(curToken));
            }
        }
        finalAns = numbers.pop();
        return "= "+finalAns;
    }
}
