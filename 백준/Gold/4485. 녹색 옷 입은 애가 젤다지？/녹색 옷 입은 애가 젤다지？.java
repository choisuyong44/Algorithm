import java.io.*;
import java.util.*;


public class Main {

	static Queue<int[]> q = new LinkedList<int[]>();
	static int N,nr,nc;
	static int INF = Integer.MAX_VALUE;
	static int[][] map;
	static int[][] ans;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int tc =0;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N==0) break;
			ans = new int[N][N];
			map = new int[N][N];
			for(int i =0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j =0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// ans 초기화
			for(int i=0;i<N;i++) {
				Arrays.fill(ans[i], INF);
			}
			bfs(0,0);
			sb.append("Problem ").append(++tc).append(": ").append(ans[N-1][N-1]).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void bfs(int r,int c) {
		q.clear(); q.add(new int[] {r,c});
		ans[r][c] = map[r][c];
		while(!q.isEmpty()) {
			int[] k = q.poll();
			for(int d=0;d<4;d++) {
				nr = k[0]+dr[d];
				nc = k[1]+dc[d];
				if(nr>=0 && nr<N && nc>=0 && nc<N) {
					if(ans[nr][nc] > ans[k[0]][k[1]]+map[nr][nc]) {
						ans[nr][nc] = ans[k[0]][k[1]]+map[nr][nc];
						q.add(new int[] {nr,nc});
					}
				}
			}
		}
		
	}
}