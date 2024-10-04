import java.io.*;
import java.util.*;

public class Solution {

	static int INF = Integer.MAX_VALUE;
	static int N,nr,nc;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int[][] map;
	static int[][] res;
	static Queue<int[]> q = new LinkedList<int[]>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1;tc<T+1;tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			res = new int[N][N];
			for(int i =0;i<N;i++) {
				Arrays.fill(res[i], INF);
			}
			for(int i =0;i<N;i++) {
				String s = br.readLine();
				for(int j =0;j<N;j++) {
					map[i][j] = s.charAt(j)-'0';
				}
			}
			bfs(0,0);
			sb.append("#").append(tc).append(" ").append(res[N-1][N-1]).append("\n");
		}
		System.out.println(sb.toString());
	}
	public static void bfs(int r,int c) {
		q.add(new int[] {r,c,0}); res[r][c] = 0;
		while(!q.isEmpty()) {
			int[] k = q.poll();
			for(int d = 0;d<4;d++) {
				nr = k[0]+dr[d];
				nc = k[1]+dc[d];
				if(nr >=0 && nr<N && nc>=0 && nc<N) {
					if(res[nr][nc] > res[k[0]][k[1]]+map[nr][nc]) {
						res[nr][nc] = res[k[0]][k[1]]+map[nr][nc];
						q.add(new int[] {nr,nc,res[nr][nc]});
					}
				}
			}
		}
	}
}