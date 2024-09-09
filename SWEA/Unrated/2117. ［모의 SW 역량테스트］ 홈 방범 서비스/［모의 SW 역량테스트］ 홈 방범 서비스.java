import java.io.*;
import java.util.*;

public class Solution {

	static Queue<int[]> q = new LinkedList<int[]>();

	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	static int max_size;
	static int MAP_SZ;
	static int house;
	static int max;

	static int[] table;
	static {
		table = new int[22];
		for (int i = 1; i <= 21; i++) {
			table[i] = i * i + (i - 1) * (i - 1);
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int TC = Integer.parseInt(br.readLine());

		for (int T = 1; T < TC + 1; T++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			MAP_SZ = 3 * N;
			map = new int[MAP_SZ][MAP_SZ];
			house = 0;

			for (int i = N; i < 2 * N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = N; j < 2 * N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1)
						house++;
				}
			}

			// 최대 가능한 면적
			max_size =0;
			for (int i = 1; i <= 20; i++) {
				if (table[i] >=house * M) {
					max_size = table[i];
					break;
				}
			}
			
			if(max_size==0) max_size = table[21];

			max = 0;
			for (int i = N; i < 2 * N; i++) {
				for (int j = N; j < 2 * N; j++) {
					visit = new boolean[MAP_SZ][MAP_SZ];
					bfs(i, j);
				}
			}

			sb.append("#").append(T).append(" ").append(max).append("\n");
		}
		System.out.println(sb.toString());
	}

	public static void bfs(int r, int c) {

		q.clear();

		int profit = 0;
		int cnt = 0;
		q.add(new int[] { r, c });
		visit[r][c] = true;

		out: while (!q.isEmpty()) {

			int[] k = q.poll();

			if (map[k[0]][k[1]] == 1)
				profit += M;

			cnt++;

			// cnt 갯수가 max_size와 크거나 같으면
			if (cnt > max_size) {
				break out;
			}

			if (possible_size(cnt) <= profit) {
				max = Math.max(max, profit / M);
			}

			for (int d = 0; d < 4; d++) {
				int nr = k[0] + dr[d];
				int nc = k[1] + dc[d];

				if (nr >= 0 && nr < MAP_SZ && nc >= 0 && nc < MAP_SZ && !visit[nr][nc]) {
					q.add(new int[] { nr, nc });
					visit[nr][nc] = true;
				}
			}
		}
	}

	public static int possible_size(int cnt) {
		for (int i = 1; i <= 20; i++) {
			if (table[i] >= cnt) {
				return table[i];
			}
		}
		return table[20];
	}

	public static void printMap() {
		System.out.println("_________________________________");
		for (int i = N; i < 2 * N; i++) {
			for (int j = N; j < 2 * N; j++) {
				if (visit[i][j] == true) {
					System.out.print("O");
				} else {
					System.out.print("X");
				}
			}
			System.out.println();
		}
	}
}