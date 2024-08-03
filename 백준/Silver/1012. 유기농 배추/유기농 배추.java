import java.io.*;
import java.util.*;


public class Main {

	static int M,N,K;
	static int[][] map;
	static int cnt;
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
	
		for(int T =0;T<TC;T++) {
			st = new StringTokenizer(br.readLine());
			M= Integer.parseInt(st.nextToken());
			N= Integer.parseInt(st.nextToken());
			K= Integer.parseInt(st.nextToken());
			
			map = new int[N][M];

			// M 가로(column) N 세로(row)
			for(int i =0;i<K;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
			}
			
			cnt = 0;
			
			for(int r=0;r<N;r++) {
				for(int c=0;c<M;c++) {
					if(map[r][c]==1) {
						cnt++;
						dfs(r,c,cnt);
					}
				}
			}
			
			// printMap();
			
			System.out.println(cnt);
		}
	}
	
	public static void dfs(int row,int col,int cnt) {
		map[row][col] = 0;
		
		for(int d=0;d<4;d++) {
			
			int nr = row + dr[d];
			int nc = col + dc[d];
			
			if(nr>=0 && nr < N && nc >=0 && nc <M) {
				if(map[nr][nc] == 1) {
					dfs(nr,nc,cnt);
				}
			}
		}
	}
	
	public static void printMap() {
		for(int i =0;i<N;i++) {
			for(int j =0 ;j<M;j++) {
				System.out.printf("%2d",map[i][j]);
			}
			System.out.println();
		}
	}
}