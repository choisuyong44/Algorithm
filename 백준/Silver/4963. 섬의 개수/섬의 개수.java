import java.io.*;
import java.util.*;

public class Main {

	static Queue<int[]> q = new LinkedList<int[]>();

	static boolean[][] visit;
	static boolean[][] map;
	static int w, h;

	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		while (w != 0 || h != 0) {
			map = new boolean[h][w];
			visit = new boolean[h][w];

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					if(Integer.parseInt(st.nextToken())==1) map[i][j] = true;
				}
			}

			int cnt = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (!visit[i][j] && map[i][j]) {
						visit[i][j] = true;
						bfs(i, j);
						cnt++;
					}
				}
			}

			sb.append(cnt).append("\n");

			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(sb.toString());
	}

	public static void bfs(int r, int c) {
		q.add(new int[] { r, c });
		visit[r][c] = true;

		while (!q.isEmpty()) {

			int[] k = q.poll();

			for (int d = 0; d < 8; d++) {
				int nr = k[0] + dr[d];
				int nc = k[1] + dc[d];

				if (nr >= 0 && nr < h && nc >= 0 && nc < w) {
					if (!visit[nr][nc] && map[nr][nc]) {
						q.add(new int[] { nr, nc });
						visit[nr][nc] = true;
					}
				}
			}
		}
	}
}