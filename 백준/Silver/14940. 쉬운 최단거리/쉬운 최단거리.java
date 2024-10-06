import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	static int[][] map;
	static int tr,tc;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static boolean[][] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for(int i =0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					tr = i;
					tc = j;
					map[i][j] = 0;
				}
				else if(map[i][j]==0) map[i][j]=0;
				else map[i][j] =-1;
			}
		}
		
		bfs(tr,tc);
		for(int i =0;i<N;i++) {
			for(int j =0;j<M;j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		visited[r][c] = true;
		q.add(new int[] {r,c});
		while(!q.isEmpty()) {
			int[] k = q.poll();
			for(int d = 0;d<4;d++) {
				int nr = k[0]+dr[d];
				int nc = k[1]+dc[d];
				if(isValid(nr,nc)) {
					map[nr][nc] = map[k[0]][k[1]]+1;
					q.add(new int[] {nr,nc});
					visited[nr][nc] = true;
				}
			}
		}
	}
	
	public static boolean isValid(int r, int c) {
		if(r>=0 && r<N && c>=0 && c<M) {
			if(!visited[r][c] && map[r][c] != 0) return true;
		}
		return false;
	}
}