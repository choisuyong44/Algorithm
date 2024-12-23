import java.io.*;
import java.util.*;

public class Main {

	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int N,nr,nc,max;
	static int[][] map,dp;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		input();
		max = 0;
		for(int i = 0;i<N;i++) {
			for(int j =0;j<N;j++) {
				max = Math.max(dfs(i,j),max);
			}
		}
		System.out.println(max);
	}
	
	public static int dfs(int r, int c) {
		if(visited[r][c]) return dp[r][c];
		
		visited[r][c] = true;
		dp[r][c] = 1;
		
		for(int d =0;d<4;d++) {
			nr = r+dr[d];
			nc = c+dc[d];
			if(nr < 0 || nr>= N || nc< 0 || nc>=N) continue; 
			
			if(map[nr][nc] > map[r][c]) {
				dp[r][c] = Math.max(dp[r][c],dfs(nr,nc)+1);
			}
		}
		return dp[r][c];
	}
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new int[N][N];
		visited = new boolean[N][N];
		for(int i =0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}