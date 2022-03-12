import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class ganked{
	static boolean can;
	static boolean[][] vis;
	public static void main(String[] args) throws FileNotFoundException{
		Scanner sc = new Scanner(new File("ganked.in"));
		int inp = sc.nextInt();
		while(inp-- > 0){
			can = false;
			int r = sc.nextInt();
			int c = sc.nextInt();
			vis = new boolean[r][c];
			sc.nextLine();
			char[][] arr = new char[r][c];
			int str=0,stc=0;
			for(int i=0;i<r;i++){
				String s=  sc.nextLine();
				for(int k=0;k<c;k++){
					arr[i][k] = s.charAt(k);
					if(arr[i][k]=='C'){
						str = i; stc = k;
					}
				}
			}
			doit(arr, str, stc);
			System.out.println(can?"Arc Flash":"Feed");
		}
	}
	public static void doit(char[][] arr, int r, int c){
		if(r<0 || c<0 || r>arr.length-1 || c>arr[0].length-1) return;
		if(vis[r][c]||arr[r][c]=='X') return;
		vis[r][c] = true;
		if(arr[r][c] =='Z'){
			can=true;
			return;
		}
		doit(arr,r+1,c);
		doit(arr,r,c+1);
		doit(arr,r-1,c);
		doit(arr,r,c-1);
	}
	
}
