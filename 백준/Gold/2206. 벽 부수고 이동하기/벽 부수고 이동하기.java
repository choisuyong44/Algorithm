import java.io.*;
import java.util.*;

public class Main {

	static class Move {
		int r;
		int c;
		int cost;
		int state;

		public Move(int r, int c, int cost, int state) {
			super();
			this.r = r;
			this.c = c;
			this.cost = cost;
			this.state = state;
		}
	}

	static int N, M;
	static boolean[][] map;
	static boolean[][][] visited;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		input();
		visited= new boolean[N][M][2];
		bfs(0, 0);
		if(min == Integer.MAX_VALUE) min = -1;
		System.out.println(min);
	}

	public static void bfs(int r, int c) {
		Queue<Move> q = new LinkedList<Move>();
		q.add(new Move(r,c,1,0));
		
		while(!q.isEmpty()) {
			
			Move k = q.poll();
			
			for(int d =0;d<4;d++) {

				if(k.r== N-1 && k.c==M-1) {
					min = k.cost;
					return;
				}
				
				int nr = k.r+dr[d];
				int nc = k.c+dc[d];
				
				if(nr>=0 && nr<N && nc>=00 && nc<M && !visited[nr][nc][k.state]) {
					
					// 벽을 만났을 떄
					if(!map[nr][nc]) {
						// 기회 o
						if(k.state == 0) { 
							q.add(new Move(nr,nc,k.cost+1,1));
							visited[nr][nc][1] = true;
						}
					}
					
					// 벽을 안만났을 떄
					else {
						q.add(new Move(nr,nc,k.cost+1,k.state));
						visited[nr][nc][k.state] = true;
					}
				}
			}
		}
	}

	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				if (s.charAt(j) == '0')
					map[i][j] = true;
				else
					map[i][j] = false;
			}
		}
	}
}