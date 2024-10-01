import java.io.*;
import java.util.*;

/*
 * -1: handOfDevil
 * 0 : 이동가능한 곳
 * 1 : 벽
 * 2 : 수연이
 * 3 : 여신
 */
public class Solution {
	static int N, M;
	static int map[][];
	static boolean visited[][];
	static int RS, CS, RG, CG, nr, nc;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int ans;
	static Queue<int[]> q = new LinkedList<int[]>();
	static Queue<int[]> dq = new LinkedList<int[]>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int TC = 1; TC < T + 1; TC++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			ans = Integer.MAX_VALUE;
			map = new int[N][M];
			visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < M; j++) {
					char tmp = str.charAt(j);
					if (tmp == '*') map[i][j] = -1;
					else if (tmp == '.')map[i][j] = 0;
					else if (tmp == 'X')map[i][j] = 1;
					else if (tmp == 'S') {RS = i;CS = j;} 
					else if (tmp == 'D') {map[i][j] = 3;RG = i;CG = j;
					}
				}
			}
			bfs(RS, CS);
			if (ans == Integer.MAX_VALUE)
				sb.append("#").append(TC).append(" GAME OVER\n");
			else
				sb.append("#").append(TC).append(" ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}

	public static void bfs(int r, int c) {
		q.clear();int time = 0;
		q.add(new int[] { r, c, 0 });
		visited[r][c] = true;

		while (!q.isEmpty()) {
			int[] k = q.poll();
			if (k[2] == time) {
				moveDevil();
				time++;
			}
			if (k[0] == RG && k[1] == CG) {
				ans = k[2];
				return;
			}
			for (int d = 0; d < 4; d++) {
				nr = k[0] + dr[d];
				nc = k[1] + dc[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if (!visited[nr][nc] && map[nr][nc] != -1 && map[nr][nc] != 1) {
						q.add(new int[] { nr, nc, k[2] + 1 });
						visited[nr][nc] = true;
					}
				}
			}
		}
	}

	public static void moveDevil() {
		dq.clear();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == -1) dq.add(new int[] { i, j });
			}
		}

		while (!dq.isEmpty()) {
			int[] k = dq.poll();
			for (int d = 0; d < 4; d++) {
				nr = k[0] + dr[d];
				nc = k[1] + dc[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if (map[nr][nc] == 0) map[nr][nc] = -1;
				}
			}
		}
	}
}