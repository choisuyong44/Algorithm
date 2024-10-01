import java.io.*;
import java.util.*;

public class Main {
	
	static int N,M,K,nr,nc,nk;
	static boolean visited[][][];
	static boolean map[][];  
	static Queue<int[]> q = new LinkedList<int[]>();
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int ans =-1;
	
	public static void main(String[] args) throws IOException{
		input();
		simulation(0,0,0);
		System.out.println(ans);
	}
	
	public static void simulation(int k , int r, int c) {
		q.add(new int[] {k,r,c,1});
		visited[k][r][c] = true;
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			if(tmp[1]==N-1 && tmp[2]==M-1) {
				ans = tmp[3];
				return;
			}
			for(int d =0 ;d<4;d++) {
				nr = tmp[1]+dr[d];
				nc = tmp[2]+dc[d];
				nk = tmp[0];
				
				if(nr>=0 && nr<N && nc>=0 && nc<M) {
					// 벽인 경우
					if(map[nr][nc]== true) {
						if(nk<K && !visited[nk+1][nr][nc]) {
							visited[nk+1][nr][nc] = true;
							q.add(new int[] {nk+1,nr,nc,tmp[3]+1});
						}
					}
					// 벽이 아닌 경우
					else {
						if(!visited[nk][nr][nc]) {
							visited[nk][nr][nc] = true;
							q.add(new int[] {nk,nr,nc,tmp[3]+1});
						}
					}
				}
			}
		}
	}
	
	public static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new boolean[K+1][N][M];
		map = new boolean[N][M];
		for(int i =0;i<N;i++) {
			String s= br.readLine();
			for(int j =0;j<M;j++) {
				if(s.charAt(j)=='1')map[i][j] = true;
			}
		}
	}
}