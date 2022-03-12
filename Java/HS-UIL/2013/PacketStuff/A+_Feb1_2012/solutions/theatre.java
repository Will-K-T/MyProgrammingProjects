import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class theatre{
	public static void main(String[] args) throws FileNotFoundException{
		Scanner sc = new Scanner(new File("theatre.in"));
		int inp = sc.nextInt();
	
		while(inp-- > 0){
			int n = sc.nextInt();
			int k = sc.nextInt();
			System.out.println(f(n+1-k, k));
		}
	}
	public static int f(int m, int n){
		if(n==0) return 1;
		if(m<n || m==0) return 0;
		return f(m-1,n-1) + f(m-1,n);
	}
	
}
