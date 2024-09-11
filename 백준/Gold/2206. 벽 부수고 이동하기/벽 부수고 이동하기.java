import java.io.*;
import java.util.*;

public class Main {

	static class Search {
		int r;
		int c;
		boolean hammer;
		int move;

		public Search(int r, int c, boolean hammer, int move) {
			super();
			this.r = r;
			this.c = c;
			this.hammer = hammer;
			this.move = move;
		}

		@Override
		public String toString() {
			return "Search [r=" + r + ", c=" + c + ", hammer=" + hammer + ", move=" + move + "]";
		}
		
		
	}

	static int N, M;
	static int[][] map;

	static boolean[][][] visit;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		if(N==1 && M==1) {
			System.out.println(1);
			return;
		}

		if(!bfs(0, 0)) System.out.println(-1); 
	}

	public static boolean bfs(int r, int c) {
		Queue<Search> q = new LinkedList<Search>();

		visit = new boolean[N][M][2];

		// hammer를 가지고 있고, movement는 0인 상태
		q.add(new Search(r, c, true, 1));
		
		// 알아서 방문처리
		checkVisit(r, c, true);

		while (!q.isEmpty()) {

			Search k = q.poll();

			out: for (int d = 0; d < 4; d++) {
				int nr = k.r + dr[d];
				int nc = k.c + dc[d];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M) {

					// 가장 먼저 방문한 경우
					if (nr == N - 1 && nc == M - 1) {
						System.out.println(k.move + 1);
						return true;
					}

					// 벽을 만난 경우
					if (map[nr][nc] == 1) {
						// 해머가 있는 경우
						if (k.hammer==true) {
							checkVisit(nr, nc, false);
							q.add(new Search(nr, nc, false, k.move + 1));
						}

						// 벽을 만났는 데 해머가 없는 경우;
						// 해당 경우는 포기
						else if (!k.hammer) {
							continue out;
						}
					}

					// 벽x
					else {
						// 방문하지 않은 경우
						if (!isVisit(nr, nc, k.hammer)) {
							checkVisit(nr, nc, k.hammer);
							q.add(new Search(nr, nc, k.hammer, k.move + 1));
						}
					}
				}
			}
		}
		return false;
	}

	// 방문을 체크하는 함수
	// hammer가 있으면 0번으로 탐색
	// hammer가 없으면 1번으로 탐색
	public static boolean isVisit(int r, int c, boolean hammer) {
		if (hammer) {
			if (visit[r][c][0] == true)
				return true;
			return false;
		}

		else {
			if (visit[r][c][1] == true)
				return true;
			return false;
		}
	}

	// 방문 처리를 하는 함수
	public static void checkVisit(int r, int c, boolean hammer) {
		if (hammer) {
			visit[r][c][0] = true;

		} else {
			visit[r][c][1] = true;
		}
	}
}