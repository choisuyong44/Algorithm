import java.io.*;
import java.util.*;

public class Main {
	static int[] dr= {-1,-1,0,1,1,1,0,-1};
	static int[] dc= {0,1,1,1,0,-1,-1,-1};
	static int N,M,nr,nc;
	static int[][] map;
	static boolean[][] visited;
	static Queue<int[]> q = new LinkedList<int[]>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i =0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt =0;
		for(int i =0;i<N;i++) {
			for(int j =0;j<M;j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					cnt++;
					bfs(i,j);
				}
			}
		}
		
		System.out.println(cnt);
	}
	
	public static void bfs(int r,int c) {
		q.clear();
		q.add(new int[] {r,c}); visited[r][c] = true;
		while(!q.isEmpty()) {
			int[] k = q.poll();
			
			for(int d =0;d<8;d++) {
				nr = k[0]+dr[d];
				nc = k[1]+dc[d];
				
				if(nr>=0 && nr< N && nc>=0 && nc<M) {
					
					if(map[nr][nc] == 1 && !visited[nr][nc]) {
						visited[nr][nc] = true;
						q.add(new int[] {nr,nc});
					}
				}
			}
		}
	}
}