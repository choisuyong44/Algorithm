import java.io.*;
import java.util.*;

public class Main {

	static Queue<Move> q = new LinkedList<Move>();

	static class Move {
		int x;
		int y;
		int z;
		int cost;

		public Move(int x, int y, int z, int cost) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
			this.cost = cost;
		}
	}

	static int min = 9999;

	static boolean[][][] ans;
	static boolean[][][] map;

	static boolean[][][] vistiedToBFS;
	static boolean[] visitedToArray;
	static int[] orderDirection = new int[5];

	static final int[][] START_POINT = { { 0, 0, 0 }, { 4, 0, 0 }, { 0, 4, 0 }, { 4, 4, 0 } };
	static final int[][] END_POINT = { { 4, 4, 4 }, { 0, 4, 4 }, { 4, 0, 4 }, { 0, 0, 4 } };
	static final int[] dx = { -1, 1, 0, 0, 0, 0 };
	static final int[] dy = { 0, 0, -1, 1, 0, 0 };
	static final int[] dz = { 0, 0, 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		input();
		simulation();

		if (min == 9999)
			min = -1;
		System.out.println(min);
	}

	public static void simulation() {
		visitedToArray = new boolean[5];
		perm(0);
	}

	// 층에 대한 순열
	public static void perm(int depth) {
		if (depth == 5) {
			decisionDirection(0);
			return;
		}

		for (int i = 0; i < 5; i++) {
			if (!visitedToArray[i]) {
				visitedToArray[i] = true;
				ans[depth] = map[i];
				perm(depth + 1);
				visitedToArray[i] = false;
			}
		}
	}

	// 5층에 대한 각각의 회전에 대한 순열
	public static void decisionDirection(int depth) {
		if (depth == 5) {
			int min = 0;
			// 원판 돌리기
			for (int i = 0; i < 5; i++) {
				rotate(i, 1, orderDirection[i]);
			}

			// 원판 돌리기
			bfs();

			// 원판 원상복구
			for (int i = 0; i < 5; i++) {
				rotate(i, -1, orderDirection[i]);
			}

			return;
		}

		for (int i = 0; i < 4; i++) {
			orderDirection[depth] = i;
			decisionDirection(depth + 1);
		}
	}

	public static void bfs() {

		out: for (int idx = 0; idx < 4; idx++) {
			int spx, spy, spz;
			spx = START_POINT[idx][0];
			spy = START_POINT[idx][1];
			spz = START_POINT[idx][2];

			int epx, epy, epz;
			epx = END_POINT[idx][0];
			epy = END_POINT[idx][1];
			epz = END_POINT[idx][2];

			// 둘 중하나가 false인 경우는 안됌
			if (!ans[spz][spy][spx] || !ans[epz][epy][epx])
				continue out;

			q.clear();
			q.add(new Move(spx, spy, spz, 0));
			vistiedToBFS = new boolean[5][5][5];
			vistiedToBFS[spz][spy][spx] = true;

			int nx, ny, nz;
			while (!q.isEmpty()) {

				Move k = q.poll();

				if (k.cost >= min) continue out;
				if(min==12)return;
				
				if (k.x == epx && k.y == epy && k.z == epz) {
					min = Math.min(min, k.cost);
					continue out;
				}

				for (int d = 0; d < 6; d++) {
					nx = k.x + dx[d];
					ny = k.y + dy[d];
					nz = k.z + dz[d];

					if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && nz >= 0 && nz < 5) {
						if (!vistiedToBFS[nz][ny][nx] && ans[nz][ny][nx]) {
							q.add(new Move(nx, ny, nz, k.cost + 1));
							vistiedToBFS[nz][ny][nx] = true;
						}
					}
				}
			}
		}
	}

	public static void rotate(int f, int direct, int cnt) {
		// direct가 -1이면 반시계 방향 회전 -> 시계 방향으로 cnt 값을 4에서 뺀 값으로 설정
		if (direct == -1) {
			cnt = 4 - cnt;
		}

		// cnt만큼 90도씩 회전
		for (int i = 0; i < cnt; i++) {
			boolean[][] temp = new boolean[5][5]; // 임시 배열

			// 5x5 배열의 90도 회전 구현
			for (int r = 0; r < 5; r++) {
				for (int c = 0; c < 5; c++) {
					// 90도 회전: ans[f][r][c]를 temp[c][4 - r]에 배치
					temp[c][4 - r] = ans[f][r][c];
				}
			}

			// 회전된 배열을 다시 원본 배열에 복사
			for (int r = 0; r < 5; r++) {
				for (int c = 0; c < 5; c++) {
					ans[f][r][c] = temp[r][c];
				}
			}
		}
	}

	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		ans = new boolean[5][5][5];
		map = new boolean[5][5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 5; k++) {
					if (Integer.parseInt(st.nextToken()) == 1)
						map[i][j][k] = true;
				}
			}
		}
	}

}