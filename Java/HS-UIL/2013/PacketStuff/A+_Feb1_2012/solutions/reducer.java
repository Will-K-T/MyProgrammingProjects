import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class reducer{
	public static void main(String[] args) throws FileNotFoundException{
		Scanner sc = new Scanner(new File("reducer.in"));
		int inp = sc.nextInt();
		
		boolean[] prime = new boolean[1001];
		Arrays.fill(prime,true);
		List<Integer> pL = new ArrayList<Integer>(1000);
		for(int i=2;i<prime.length;i++){
			if(prime[i]){
				pL.add(i);
				for(int k=i+i;k<prime.length;k+=i){
					prime[k]=false;
				}
			}
		}
		
		while(inp-- > 0){
			int p = sc.nextInt();
			int q = sc.nextInt();
			List<Integer> fp = get(p,pL);
			List<Integer> fq = get(q,pL);
			fq.retainAll(fp);
			System.out.println(fq.size());
		}
	}
	public static List<Integer> get(int m, List<Integer> pl){
		List<Integer> r = new ArrayList<Integer>();
		while(m>1){
			for(int i : pl){
				while(m % i ==0){
					m /= i;
					r.add(i);
				}
			}
		}
		return r;
	}
	
}
