import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class match{
	public static void main(String[] args) throws FileNotFoundException{
		Scanner sc = new Scanner(new File("match.in"));
		int inp = sc.nextInt();
		while(inp-- > 0){
			int[] a = new int[10];
			int sum = 0;
			for(int i=0;i<10;i++){
				a[i]=sc.nextInt();
				sum += a[i];
			}
			int min = Integer.MAX_VALUE;
			for(int i=0;i<(1<<10);i++){
				if(Integer.bitCount(i)==5){
					int curr = 0;
					for(int k=0;k<10;k++){
						if((i&(1<<k))!=0){
							curr += a[k];
						}
					}
					min = Math.min(min, Math.abs(curr-(sum-curr)));
				}
			}
			System.out.println(min);
		}
	}
}
