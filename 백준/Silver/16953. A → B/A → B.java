import java.io.*;
import java.util.*;

public class Main {
	
	static long N,M;

	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Long.parseLong(st.nextToken());
		M = Long.parseLong(st.nextToken());
		
		dfs(N,0);
				
		// 1_000_000_000 : 10억
		// 최소 연산이 2^30 = 1000 * 1000 * 1000
		// N이 M 까지 도달하는 데 최소 9번 최대 30번
		// 
		
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}
		else {
			System.out.println(min+1);
			return;
		}
	}
	
	public static void dfs(long n,int cnt) {
		if(n==M) {
			min = Math.min(cnt, min);
			return;
		}
		
		else if(n > M) {
			return;
		}
		
		dfs(n*10+1,cnt+1);
		dfs(n*2,cnt+1);
	}
}