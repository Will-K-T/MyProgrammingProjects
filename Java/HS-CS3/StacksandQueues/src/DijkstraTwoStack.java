import java.util.Stack;
import java.util.StringTokenizer;

public class DijkstraTwoStack {
    public static void main(String[] args) {
        String ops = "+-*/";
        String math = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        StringTokenizer tokenizer = new StringTokenizer(math, " ");
        Stack<String> operators = new Stack<>();
        Stack<Float> operands = new Stack<>();
        String token = "";
        while(tokenizer.hasMoreTokens()){
            token = tokenizer.nextToken();
            if(token.equals(")")){
                String op = operators.pop();
                if(op.equals("+")){
                    operands.push(operands.pop()+operands.pop());
                }
                else if(op.equals("-")){
                    operands.push(-1*(operands.pop()-operands.pop()));
                }
                else if(op.equals("*")){
                    operands.push(operands.pop()*operands.pop());
                }
                else if(op.equals("/")){
                    float bottomNumber = operands.pop();
                    float topNumber = operands.pop();
                    operands.push(topNumber/bottomNumber);
                }
            }
            else if(ops.contains(token)){
                operators.push(token);
            }
            else if(!token.equals("(")){
                operands.push(Float.parseFloat(token));
            }
        }
        System.out.println(operands.pop());
    }
}
