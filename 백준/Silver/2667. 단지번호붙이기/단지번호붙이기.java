import java.io.*;
import java.util.*;

public class Main {

	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	static boolean[][] visited;
	static int[][] map;
	
	static int N;
	static int cnt;
	
	static int[] dr = {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	
	public static void main(String[] args)throws IOException{
		input();
		visited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j =0;j<N;j++) {
				cnt = 0;
				if(map[i][j]!=1 || visited[i][j]) continue;
				bfs(i,j);
				pq.add(cnt);
			}
		}
		
		System.out.println(pq.size());
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}
	
	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for(int i =0;i<N;i++) {
			String s = br.readLine();
			for(int j =0;j<N;j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
	}
	
	public static void bfs(int r,int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		visited[r][c] =true; cnt++;
		q.add(new int[] {r,c});
		
		int nr, nc;
		while(!q.isEmpty()) {
			
			int[] k = q.poll();
			
			for(int d =0 ;d<4;d++) {
				nr = k[0]+dr[d];
				nc = k[1]+dc[d];
				
				if(nr>=0 && nr< N &&nc>=0 &&nc<N&&!visited[nr][nc] &&map[nr][nc]==1) {
					q.add(new int[] {nr,nc});
					visited[nr][nc] = true;
					cnt++;
				}
			}	
		}
	}
}