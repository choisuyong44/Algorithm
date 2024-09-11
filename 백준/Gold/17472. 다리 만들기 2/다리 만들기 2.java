import java.io.*;
import java.util.*;

public class Main {

	static class Link implements Comparable<Link> {
		int A;
		int B;
		int W;

		public Link(int a, int b, int w) {
			super();
			A = a;
			B = b;
			W = w;
		}

		@Override
		public int compareTo(Link o) {
			// 가중치(길이)가 작은 순서대로
			return this.W - o.W;
		}

		@Override
		public String toString() {
			return "Link [A=" + A + ", B=" + B + ", W=" + W + "]";
		}
	}

	// map 입력
	static int N, M;
	static int[][] map;

	// map 영역을 기록 및 갯수 파악
	static boolean[][] visit;
	static int isLandCnt;
	static Queue<int[]> q = new LinkedList<int[]>();
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	// map 탐색 -> 가장 작은 연결다리 만들기
	static List<int[]>[] conn;

	// pq에 넣기
	static PriorityQueue<Link> pq = new PriorityQueue<>();

	// union-find
	static int[] parent;

	public static void main(String[] args) throws IOException {
		// 1. map 입력
		input();

		// 2. map 영역을 기록 및 갯수 파악
		visit = new boolean[N][M];
		isLandCnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 방문 x 이고, 섬(1)이면 bfs 출발
				if (!visit[i][j] && map[i][j] == 1) {
					isLandCnt++;
					bfs(i, j);
				}
			}
		}

		// 3. map 탐색 -> 가장 작은 연결다리 만들기
		conn = new ArrayList[isLandCnt + 1]; // 0은 사용x
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				findConn(i, j);
			}
		}

		// 4. PrioirityQueue 에 넣기
		for (int i = 1; i <= isLandCnt; i++) {
			for (int j = 0; j < conn[i].size(); j++) {
				pq.add(new Link(i, conn[i].get(j)[0], conn[i].get(j)[1]));
			}
		}

		
		// 5. pq에서 꺼내서 Union-Find
		parent = new int[isLandCnt + 1];
		int max_Edge = isLandCnt - 1;

		for (int i = 1; i <= isLandCnt; i++) {
			parent[i] = i;
		}

		int cnt = 0;
		int sum = 0;
		while (!pq.isEmpty()) {
			Link k = pq.poll();
			
			// 부모가 다른 경우에만 union
			if (find(k.A) != find(k.B)) {
				union(k.A, k.B);
				cnt++;
				sum += k.W;
			}

			if (max_Edge == cnt) {
				System.out.println(sum);
				return;
			}
		}
		System.out.println(-1);
		return;
	}

	public static int find(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = find(parent[x]);
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x < y)
			parent[y] = x;
		else
			parent[x] = y;
	}

	public static void findConn(int r, int c) {
		// 바다(0)이면 종료
		if (map[r][c] == 0)
			return;

		// 사방 탐색으로 연결 찾기
		// 1. 해당 번호의 섬의 연결리스트 생성
		int k = map[r][c];
		// 해당 리스트가 없는 경우 - 새로운 리스트 생성
		if (conn[k] == null) conn[k] = new ArrayList<int[]>();

		// 2. 조건에 맞는 섬 conn에 추가
		out: for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			int length = 0;

			// 찾기
			while (true) {
				// 범위 초과
				if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
					// 자기 자신을 만난 경우
					if (map[nr][nc] == k) {
						continue out;
					}

					// 바다를 만난 경우
					else if (map[nr][nc] == 0) {
						nr = nr + dr[d];
						nc = nc + dc[d];
						length++;
					}

					// 다른 육지를 만난 경우 - length가 2보다 커야함
					else {
						if (length >= 2) {
							// 이미 있으면
							for (int i = 0; i < conn[k].size(); i++) {
								// 1. 목적지가 이미 배열에 있고
								// 2. 작다면 바꾸기
								if (conn[k].get(i)[0] == map[nr][nc]) {
									// length 값이 더 작다면 갱신
									if (conn[k].get(i)[1] > length) {
										conn[k].get(i)[1] = length;
									}
									continue out;
								}
							}
							
							// 없으면 추가
							conn[k].add(new int[] { map[nr][nc], length });
						}
						continue out;
					}
				}

				else
					continue out;
			}
		}
	}

	public static void bfs(int r, int c) {
		q.add(new int[] { r, c });
		visit[r][c] = true;
		map[r][c] = isLandCnt;

		while (!q.isEmpty()) {

			int[] k = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = k[0] + dr[d];
				int nc = k[1] + dc[d];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
					// 방문 x이고, 섬
					if (visit[nr][nc] == false && map[nr][nc] == 1) {
						visit[nr][nc] = true;
						map[nr][nc] = isLandCnt;
						q.add(new int[] { nr, nc });
					}
				}
			}
		}
	}

	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	public static void printMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}