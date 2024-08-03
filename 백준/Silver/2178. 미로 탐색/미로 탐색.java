import java.io.*;
import java.util.*;


public class Main {

	static int[][] map;
	static int[][] ans;
	static Queue<Integer[]> queue = new LinkedList<Integer[]>(); 
	
	static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    
    static int cnt;
    
    static int N,M;
    		
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		ans = new int[N][M];
		
		for(int i =0;i<N;i++) {
			String s = br.readLine();
			for(int j =0;j<M;j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		
		cnt =1;
		bfs(0,0);
		//printMap();
		
		// 항상 1,1에서 출발
		System.out.println(ans[N-1][M-1]);
	}
	
	public static void printMap() {
		for(int i =0;i<N;i++) {
			for(int j =0;j<M;j++) {
				System.out.printf("%3d",ans[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void bfs(int row, int col) {
		queue.offer(new Integer[] {row,col});
		Integer[] xy; int r;int c;
		int nr,nc;
		ans[row][col] =1;
		
		while(!queue.isEmpty()) {
			
			xy = queue.poll();
			r = xy[0];
			c = xy[1];
			
			for(int d =0 ;d<4;d++) {
				nr = r + dr[d];
				nc = c + dc[d];
				
				if(nr >=0 && nr< N && nc >=0 && nc<M) {
					// 방문 x queue에도 없을 때
					if(ans[nr][nc]==0 && map[nr][nc]==1) {
						queue.offer(new Integer[]{nr,nc});
						ans[nr][nc]= ans[r][c] +1;
					}
				}
			}
			
		}
	}
}