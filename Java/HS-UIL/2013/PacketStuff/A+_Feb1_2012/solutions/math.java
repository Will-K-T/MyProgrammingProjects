import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class math{
	public static void main(String[] args) throws FileNotFoundException{
		Scanner sc = new Scanner(new File("math.in"));
		int inp = sc.nextInt();
		while(inp-- > 0){
			String exp = sc.next();
			System.out.println(is(exp)?"Yes":"No");
		}
	}
	public static boolean is(String s){
		if(s.length()==0) return false;
		if(s.length()==1){
			return s.matches("[0-9]");
		}
		if(s.charAt(0) == '(' && s.charAt(s.length()-1) == ')') {
			return is(s.substring(1,s.length()-1));
		}
		String[] arr = s.split("[\\+\\-\\*\\/]", Integer.MAX_VALUE);
		for(String ss : arr){
			if(!is(ss)) return false;
		}		
		return true;
	}
}
