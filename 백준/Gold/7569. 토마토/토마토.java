import java.io.*;
import java.util.*;

public class Main {
	static int N,M,H,nr,nc,nh,tomato;
	static int[] dr = {0,0,0,0,-1,1};
	static int[] dc = {0,0,-1,1,0,0};
	static int[] dh = {-1,1,0,0,0,0};
	static Queue<int[]> q = new LinkedList<int[]>();
	static boolean[][][] visited;
	static int[][][] tomatos;
	public static void main(String[] args) throws IOException{
		input();
		int ans = bfs();
		System.out.println(ans);
	}
	
	static int bfs() {
		int SZ; int time =-1;
		while(!q.isEmpty()) {
			SZ = q.size();
			time++;
			for(int i =0;i<SZ;i++) {
				int[] k = q.poll();
				for(int d =0 ;d<6;d++) {
					nh = k[0]+dh[d];
					nr = k[1]+dr[d];
					nc = k[2]+dc[d];
				
					if(nh<0 || nh>=H || nr<0 || nr>=N || nc<0 || nc>=M) continue;
					if(tomatos[nh][nr][nc]==0 && !visited[nh][nr][nc]) {
						visited[nh][nr][nc] = true;
						q.add(new int[] {nh,nr,nc});
						tomato--;
					}
				}
			}
		}
		if(tomato!=0) time = -1;
		return time;
	}
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		visited = new boolean[H][N][M];
		tomatos = new int[H][N][M];
		tomato = 0;
		for(int k = 0;k<H;k++) {			
			for(int i =0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j =0;j<M;j++) {
					tomatos[k][i][j] = Integer.parseInt(st.nextToken());
					if(tomatos[k][i][j]==1) {
						q.add(new int[] {k,i,j});
						visited[k][i][j] = true;
					}
					if(tomatos[k][i][j]==0)tomato++;
				}
			}
		}
	}
}