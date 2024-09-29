import java.io.*;
import java.util.*;

public class Solution {

	static int[][] map;
	static boolean[] visited;
	static int[] A,B;
	static int N;
	static int min;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
	
		int TC = Integer.parseInt(br.readLine());
		
		for(int T = 1;T<TC+1;T++) {
			N = Integer.parseInt(br.readLine());
			
			min = Integer.MAX_VALUE;
			visited = new boolean[N];
			A = new int[N/2];
			B = new int[N/2];
			map = new int[N][N];
			
			for(int i =0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j =0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			combi(0,0);
			sb.append("#").append(T).append(" ").append(min).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void combi(int Aidx,int depth) {
		if(depth == N/2) {	
			int idx =0;
			for(int i =0;i<N;i++) {
				if(!visited[i]) B[idx++] = i;
			}		
			calSynergy();
			return;
		}
		
		for(int i =Aidx;i<N;i++) {
			if(!visited[i]) {
				visited[i] = true;
				A[depth] = i;
				combi(i+1,depth+1);
				visited[i] = false;
			}
		}
	}
	public static void calSynergy() {
		int scoreA = 0; int scoreB =0;
		for(int i =0;i<N/2;i++) {
			for(int j =0;j<N/2;j++) {
				scoreA += map[A[i]][A[j]];
			}
		}
		for(int i =0;i<N/2;i++) {
			for(int j =0;j<N/2;j++) {
				scoreB += map[B[i]][B[j]];
			}
		}
		int ans = Math.abs(scoreA-scoreB);
		min = Math.min(ans, min);
	}
}