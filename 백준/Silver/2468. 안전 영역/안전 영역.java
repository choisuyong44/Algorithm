import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[][] map;
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static boolean[][] visited;
	static int max =0;
	
	public static void main(String[] args) throws IOException{
		input();
		
		// 물의 높이 0부터 100까지만 확인하면 됨
		for(int h =0;h<=100;h++) {
			int cnt = 0;
			visited = new boolean[N][N];
			for(int i = 0;i<N;i++) {
				for(int j =0;j<N;j++) {
					// 방문 x + 잠기지 않은 곳
					if(!visited[i][j] && map[i][j] > h) {
						bfs(i,j,h);
						cnt++;
					}
				}
			}
			max = Math.max(max, cnt);
		}
		
		System.out.println(max);
	}
	
	public static void bfs(int r, int c,int h) {
		Queue<int[]>q = new LinkedList<int[]>();
		q.add(new int[] {r,c});
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			
			int[] k = q.poll();
			
			for(int d =0;d<4;d++) {
				int nr = k[0]+dr[d];
				int nc = k[1]+dc[d];
				
				if(nr>=0 && nr<N && nc>=0 && nc<N) {
					if(!visited[nr][nc] && map[nr][nc]>h) {
						visited[nr][nc] = true;
						q.add(new int[] {nr,nc});
					}
				}
			}
		}
	}
	
	public static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for(int i =0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
	}
}