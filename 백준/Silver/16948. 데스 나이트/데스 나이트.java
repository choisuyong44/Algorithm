import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dr = {-2,-2,0,0,2,2};
	static int[] dc = {-1,1,-2,2,-1,1};
	static int r1,c1,r2,c2;
	static boolean[][] visited;
	static int[][] map;	
	static int N;
	static int cnt = 0;
	static Queue<int[]> q = new LinkedList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		r1 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());
		bfs();
	}
	
	public static void bfs() {
		visited[r1][c1] = true;
		q.add(new int[] {r1,c1,0});
		while(!q.isEmpty()) {
			int[] k = q.poll();
			if(k[0]==r2 && k[1]==c2) {
				System.out.println(k[2]);
				return;
			}
			for(int d = 0;d<6;d++) {
				int nr = k[0]+dr[d];
				int nc = k[1]+dc[d];
				if(nr>=0 && nr<N && nc>=0 && nc<N) {
					if(!visited[nr][nc]) {
						visited[nr][nc] =true;
						q.add(new int[] {nr,nc,k[2]+1});
					}
				}
			}
		}
		System.out.println(-1);
	}
}