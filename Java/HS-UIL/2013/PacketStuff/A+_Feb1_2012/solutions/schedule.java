import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class schedule{
	public static void main(String[] args) throws FileNotFoundException{
		Scanner sc = new Scanner(new File("schedule.in"));
		int inp = sc.nextInt();
		while(inp-- > 0){
			int n = sc.nextInt();
			List<Interval> ll = new ArrayList<Interval>();
			for(int j=0;j<n;j++)
			ll.add(new Interval(sc.nextInt(),sc.nextInt()));
			Collections.sort(ll);
			int count = 0;
			Interval prev = null;
			for(Interval x : ll){ 
				if(prev == null || x.s > prev.e){
					prev = x;
					count++;
				}
			}
			System.out.println(count);
		}
	}
}
class Interval implements Comparable<Interval>{
	int s; int e;
	public Interval(int s, int e){ this.s=s; this.e=e; }
	public int compareTo(Interval i){
		return e-i.e;
	}
}
