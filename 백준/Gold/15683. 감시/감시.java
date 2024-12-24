import java.io.*;
import java.util.*;

public class Main {

	static int N, M, nr, nc;
	static int[][] map;
	static int ans, max, sum;
	static boolean[][] visited,check;

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static List<CCTV> list;

	static class CCTV {
		int r, c, type, dir;

		CCTV(int r, int c, int type) {
			this.r = r;
			this.c = c;
			this.type = type;
		}

		@Override
		public String toString() {
			return "CCTV [r=" + r + ", c=" + c + ", type=" + type + ", dir=" + dir + "]";
		}
	}

	public static void main(String[] args) throws IOException {
		input();
		dfs(0);
		System.out.println(ans - max);
	}

	static void dfs(int depth) {
		if (depth == list.size()) {
			updateVisible();
			return;
		}

		// 5번 경우 방향 필요 x
		if (list.get(depth).type == 5) dfs(depth + 1);

		for (int d = 0; d < 4; d++) {
			list.get(depth).dir = d;
			dfs(depth + 1);
		}
	}

	static void updateVisible() {
		check = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				check[i][j] = visited[i][j];
			}
		}
		sum = 0;
		for (CCTV cctv : list) {
			if (cctv.type == 1) {
				sum += cntVisible(cctv,0);
			}

			else if (cctv.type == 2) {
				for (int d = 0; d < 3; d += 2) {
					sum += cntVisible(cctv,d);
				}
			}

			else if (cctv.type == 3) {
				for (int d = 0; d < 2; d++) {
					sum +=cntVisible(cctv, d);
				}
			}

			else if (cctv.type == 4) {
				for (int d = 0; d < 3; d++) {
					sum +=cntVisible(cctv, d);

				}
			}

			else if (cctv.type == 5) {
				for (int d = 0; d < 4; d++) {
					sum +=cntVisible(cctv, d);
				}
			}
		}
		max = Math.max(sum, max);
	}
	
	static int cntVisible(CCTV cctv, int d) {
		int cnt =0;
		nr = cctv.r;
		nc = cctv.c;
		while (true) {
			nr = nr + dr[(cctv.dir + d) % 4];
			nc = nc + dc[(cctv.dir + d) % 4];
			if (!isValid(nr, nc)) break;
			if (!check[nr][nc]) {
				check[nr][nc] = true;
				cnt++;
			}
		}
		return cnt;
	}

	static boolean isValid(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= M) return false;
		if(map[r][c]==6) return false;
		return true;
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		list = new ArrayList<CCTV>();
		ans = 0; max = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > 0 && map[i][j] < 6) {
					list.add(new CCTV(i, j, map[i][j]));
				}
				if (map[i][j] == 0) ans++;
				else visited[i][j] = true;
			}
		}
	}
}