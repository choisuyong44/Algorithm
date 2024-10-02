import java.io.*;
import java.util.*;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N, M, gr, gc;
	static char[][] map;
	static boolean[][] visited;
	static Queue<int[]> sq = new LinkedList<int[]>();
	static Queue<int[]> dq = new LinkedList<int[]>();
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int ans;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T + 1; tc++) {
			input();
			simulation();
			sb.append("#").append(tc).append(" ").append(ans==0? "GAME OVER":ans).append("\n");
		}
		System.out.println(sb.toString());
	}

	public static void simulation() {
		int time = 0;
		int dq_size, sq_size;
		while (!sq.isEmpty()) {
			dq_size = dq.size();
			sq_size = sq.size();
			// devil
			for (int i = 0; i < dq_size; i++) {
				int[] dk = dq.poll();
				for (int d = 0; d < 4; d++) {
					int nr = dk[0] + dr[d];
					int nc = dk[1] + dc[d];
					if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == '.') {
						dq.add(new int[] { nr, nc });
						map[nr][nc] = '*';
					}
				}
			}
			// suyeon
			for (int i = 0; i < sq_size; i++) {
				int[] sk = sq.poll();
				
				if(sk[0]==gr && sk[1]==gc) {
					ans = time;
					return;
				}
				
				for (int d = 0; d < 4; d++) {
					int nr = sk[0] + dr[d];
					int nc = sk[1] + dc[d];
					if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
						if (!visited[nr][nc] && (map[nr][nc] == '.' || map[nr][nc] == 'D')) {
							sq.add(new int[] { nr, nc });
							visited[nr][nc] = true;
						}
					}
				}
			}
			time++;
		}
	}
	
	public static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M]; ans = 0;
		visited = new boolean[N][M];
		sq.clear(); dq.clear();
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == '*')
					dq.add(new int[] { i, j });
				else if (map[i][j] == 'S') {
					sq.add(new int[] { i, j });
					visited[i][j] = true;
					map[i][j] = '.';
				} else if (map[i][j] == 'D') {
					gr = i;
					gc = j;
				}
			}
		}
	}
}