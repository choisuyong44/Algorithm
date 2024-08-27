import java.io.*;
import java.util.*;

public class Solution {
	
	static int max;
	static int N,L;
	static int[][] food;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		int TC  = Integer.parseInt(br.readLine());
		
		for(int T = 1; T<TC+1;T++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
		
			food = new int[N][2];
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				food[i][0] = Integer.parseInt(st.nextToken());
				food[i][1] = Integer.parseInt(st.nextToken());
			}
			
			max =0;
			dfs(0,0,0,L);
			
			System.out.println("#"+ T + " " +max);
		}
	}
	
	public static void dfs(int idx, int cal,int score,int limit) {
		if(cal > limit) {
			return;
		}

		max = Math.max(max, score);

		for(int i =idx;i<N;i++) {
			score += food[i][0];
			cal += food[i][1];
			dfs(i+1,cal,score,limit);
			score -= food[i][0];
			cal -= food[i][1];
		}
	}
}