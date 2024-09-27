import java.io.*;
import java.util.*;

public class Main {

	static boolean[][][] move;
	static int[][] map;
	static int K, W, H;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int[] dr_horse = { -2, -2, -1, 1, 2, 2, 1, -1 };
	static int[] dc_horse = { -1, 1, 2, 2, 1, -1, -2, -2 };

	static int ans =-1;

	public static void main(String[] args) throws IOException {
		input();
		bfs(0, 0, 0);
		System.out.println(ans);
	}

	public static void bfs(int k, int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { k, r, c, 0 });

		int nk, nr, nc;
		while (!q.isEmpty()) {

			int[] tmp = q.poll();
			
			if(tmp[1]== H-1 && tmp[2] == W-1) {
				ans = tmp[3];
				return;
			}

			// 원숭이
			for (int d = 0; d < 4; d++) {
				nr = tmp[1] + dr[d];
				nc = tmp[2] + dc[d];

				if (isValid(tmp[0], nr, nc)) {
					q.add(new int[] { tmp[0], nr, nc, tmp[3] + 1 });
					move[tmp[0]][nr][nc] = true;
				}
			}
			
			// 말로 이동하는 경우
			if (tmp[0] < K) {
				for (int d = 0; d < 8; d++) {
					nr = tmp[1] + dr_horse[d];
					nc = tmp[2] + dc_horse[d];
					
					if(isValid(tmp[0]+1,nr,nc)) {
						q.add(new int[] { tmp[0]+1, nr, nc, tmp[3] + 1 });
						move[tmp[0]+1][nr][nc] = true;
					}
				}
			}
		}
	}

	public static boolean isValid(int k, int r, int c) {
		if (r >= 0 && r < H && c >= 0 && c < W) {
			if (!move[k][r][c] && map[r][c] == 0)
				return true;
		}
		return false;
	}

	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken()); H = Integer.parseInt(st.nextToken());

		move = new boolean[K+1][H][W];
		map = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}