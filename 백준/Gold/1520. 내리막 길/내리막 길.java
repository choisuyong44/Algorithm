import java.io.*;
import java.util.*;

public class Main {

	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int M,N,nr,nc;
	static int[][] map, visited;
	static int cnt =0;
	static int[] k;

	public static void main(String[] args) throws IOException{
		input();
		System.out.println(dfs(0,0));
	}
	
	static int dfs(int r, int c) {
		if(r == N-1 && c == M-1) return 1;
		
		if(visited[r][c] != -1) return visited[r][c];
		
		visited[r][c] = 0;
		for(int d =0; d<4;d++) {
			nr = r+dr[d];
			nc = c+dc[d];
			
			if(nr >=0 && nr<N && nc>=0 && nc<M && map[nr][nc] < map[r][c]) {
				visited[r][c] += dfs(nr,nc);
			}
		}
		
		return visited[r][c];
	}
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new int[N][M];
		for(int i =0;i<N;i++) {
			Arrays.fill(visited[i], -1);
		}
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0 ;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}