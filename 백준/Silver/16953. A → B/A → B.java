import java.io.*;
import java.util.*;

public class Main {

	static int min =Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
	
		int cnt =0;
		dfs(A,B,cnt);
		
		if(min==Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(min+1);
		}
	}
	
	public static void dfs(long A,long B,int cnt) {
		if(A == B) {
			min = Math.min(cnt,min);
			return;
		}
		
		if(A>B) {
			return;
		}
		
		dfs(A*10+1,B,cnt+1);
		dfs(A*2,B,cnt+1);
	}
}