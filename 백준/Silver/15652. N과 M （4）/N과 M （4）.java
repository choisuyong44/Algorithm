import java.io.*;
import java.util.*;


public class Main {
	
	static int N;
	static int M;
	static StringBuilder sb = new StringBuilder();
	static boolean[] visit;
	static int[] arr;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
			
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visit = new boolean[N+1];
		arr = new int[N+1];
		
		dfs(1,0);
		System.out.println(sb);
		
	}
	
	public static void dfs(int idx, int cnt) {
		
		if(cnt==M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append('\n');
			return;
		}
		
		for (int i = idx; i <= N; i++) {
			arr[cnt] = i;
			dfs(i,cnt + 1);
		}
	}
}