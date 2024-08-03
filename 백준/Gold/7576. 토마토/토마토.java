import java.io.*;
import java.util.*;

class Pair {
	int x, y;

	Pair(int y, int x) {
		this.x = x;
		this.y = y;
	}
}

public class Main {

	static int N, M;
	static int[][] box;

	static Queue<Pair> queue = new LinkedList<>();
	static int days;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {

		// 1 익은 토마토
		// 0 안 익은 토마토
		// -1 토마토가 없는 곳

		// 익은 토마토 근처에 있는 (상하좌우) 안익은 토마토는 하루 뒤에 익은 토마토
		// 저절로 익지는 않는다.
		// 얼마가 걸리는 지 최소 일수를 구해라
		// 모두 익지 않는 다면 -1을 출력
		// 토마토는 무조건 1개는 있다. 익은 토마토가 있다는 보장 x

		// 처음부터 모든 토마토가 익어있는 상태이면 0
		// 토마토가 모두 익지 못하는 상황이면 -1을 출력

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// M 이 가로, N이 세로
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		box = new int[N][M];

		boolean isAllOldTomato = true;
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				box[r][c] = Integer.parseInt(st.nextToken());
				if (box[r][c] == 0)
					isAllOldTomato = false;
				if (box[r][c] == 1)
					queue.offer(new Pair(r, c));
			}
		}

		// 1. 모두 익었는 지 부터 검사 -> 0 (예외처리)
		if (isAllOldTomato) {
			System.out.println(0);
			return;
		}

		// 2. 모두 익지 못하는 상태 -> bfs 를 돌았는 데도 0이 남아있으면 -> -1
		while(!queue.isEmpty()) {
			Pair xy = queue.poll();
			bfs(xy.y,xy.x);
		}

		// printMap();
		// 3. 그게 아니면 그냥 출력
		int max = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (box[r][c] == 0) {
					System.out.println(-1);
					return;
				}
				max = Math.max(max, box[r][c]);
			}
		}

		System.out.println(max - 1);
	}

	public static void bfs(int row, int col) {

		queue.offer(new Pair(row, col));
		Pair xy;
		int r, c;
		box[row][col] = 1;
		while (!queue.isEmpty()) {

			xy = queue.poll();
			r = xy.y;
			c = xy.x;

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M) {

					if (box[nr][nc] == -1) {
						continue;
					}

					// box == 0 이거나 nr nc가 이미 컸을 떄
					if (box[nr][nc] == 0 || box[r][c] + 1 < box[nr][nc]) {
						box[nr][nc] = box[r][c] + 1;
						queue.offer(new Pair(nr, nc));
					}
				}
			}
		}
	}

	public static void printMap() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				System.out.printf("%2d", box[r][c]);
			}
			System.out.println();
		}
	}
}