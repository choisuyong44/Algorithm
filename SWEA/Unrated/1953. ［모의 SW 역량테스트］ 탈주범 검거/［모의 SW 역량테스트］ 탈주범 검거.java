import java.io.*;
import java.util.*;

public class Solution {

	static ArrayList<int[]>[] move = new ArrayList[8];

	static {
		// 상하좌우
		move[1] = new ArrayList<int[]>();
		move[1].add(new int[] { -1, 0 });
		move[1].add(new int[] { 1, 0 });
		move[1].add(new int[] { 0, -1 });
		move[1].add(new int[] { 0, 1 });

		// 상하
		move[2] = new ArrayList<int[]>();
		move[2].add(new int[] { -1, 0 });
		move[2].add(new int[] { 1, 0 });

		// 좌우
		move[3] = new ArrayList<int[]>();
		move[3].add(new int[] { 0, -1 });
		move[3].add(new int[] { 0, 1 });

		// 상우
		move[4] = new ArrayList<int[]>();
		move[4].add(new int[] { -1, 0 });
		move[4].add(new int[] { 0, 1 });

		// 하우
		move[5] = new ArrayList<int[]>();
		move[5].add(new int[] { 1, 0 });
		move[5].add(new int[] { 0, 1 });

		// 하좌
		move[6] = new ArrayList<int[]>();
		move[6].add(new int[] { 1, 0 });
		move[6].add(new int[] { 0, -1 });

		// 상좌
		move[7] = new ArrayList<int[]>();
		move[7].add(new int[] { -1, 0 });
		move[7].add(new int[] { 0, -1 });
	}

	static int R, C, N, M, L;
	static int[][] map;
	static int[][] visit;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int TC = Integer.parseInt(br.readLine());

		for (int T = 1; T < TC + 1; T++) {
			// 값 입력
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			visit = new int[N][M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			cnt = 0;
			bfs(R, C);

			sb.append("#").append(T).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}

	public static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();

		q.add(new int[] { r, c });
		cnt++;
		visit[r][c] = 1;

		while (!q.isEmpty()) {

			// 해당 자리로 이동이 가능한 좌표만
			// 따라서 다음 이동이 가능한지만 판별해주면 됨
			int[] tmp = q.poll();

			if(visit[tmp[0]][tmp[1]] == L) {
				return;
			}
			
			// move 결정
			int k = map[tmp[0]][tmp[1]];

			// move에 맞게 동작
			for (int i = 0; i < move[k].size(); i++) {
				int nr = tmp[0] + move[k].get(i)[0];
				int nc = tmp[1] + move[k].get(i)[1];

				// 1. map 범위 안에 있는 지 check && 2. 방문 x인 곳인지 check && 0이어도 안됨
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && visit[nr][nc] == 0 && map[nr][nc] != 0) {

					// 3. 가려고하는 방향의 pipe와 같은 방향으로 연결되어 있는 지
					int nextMove = map[nr][nc];

					// 4. 연결이 가능한지 check
					for (int j = 0; j < move[nextMove].size(); j++) {
						// 이동 가능
						// 다음 파이프의 row + nr이면 tmp[0](현재 r)
						// 다음 파이프의 col + nc이면 tmp[1](현재 c)
						if (move[nextMove].get(j)[0] + nr == tmp[0] && move[nextMove].get(j)[1] + nc == tmp[1]) {
							q.add(new int[] { nr, nc });
							visit[nr][nc] = visit[tmp[0]][tmp[1]] + 1;
							cnt++;
							//printMap();
							break;
						}
						// 이동 불가
					}
				}
			}
		}
	}

	public static void printMap() {
		System.out.println("==================================");
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(visit[i]));
		}
	}
}