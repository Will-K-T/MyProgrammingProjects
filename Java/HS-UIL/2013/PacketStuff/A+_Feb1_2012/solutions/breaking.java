import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;


public class breaking {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner sc = new Scanner(new File("breaking.in"));
		int inp = sc.nextInt();
		sc.nextLine();
		while(inp-- > 0){
			String[] x = sc.nextLine().split(" ");
			for(int i=0;i<x.length;i++){
				x[i]=x[i].toUpperCase();
			}
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			for(String s : x){
				map.put(s, 0);
			}
			for(String s : x){
				map.put(s, map.get(s)+1);
			}
			BC[] ll = new BC[map.size()];
			int idx =0;
			for(Map.Entry<String, Integer> e : map.entrySet()){
				ll[idx++] = new BC(e.getKey(), e.getValue());
			}
			Arrays.sort(ll);
			for(BC ans : ll){
				System.out.println(ans.s+" "+ans.c);
			}
			System.out.println("END");
		}
	}
}
class BC implements Comparable<BC>{
	String s; int c;
	public BC(String s, int c){
		this.c=c;this.s=s;
	}
	public int compareTo(BC o){
		if(c!=o.c) return o.c-c;
		return s.compareTo(o.s);
	}
}
