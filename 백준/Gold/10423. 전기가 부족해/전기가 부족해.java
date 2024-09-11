import java.io.*;
import java.util.*;

public class Main {

	static class Edge implements Comparable<Edge> {
		int A;
		int B;
		int W;

		public Edge(int a, int b, int w) {
			super();
			A = a;
			B = b;
			W = w;
		}

		@Override
		public int compareTo(Edge o) {
			return this.W - o.W;
		}

		@Override
		public String toString() {
			return "Edge [A=" + A + ", B=" + B + ", W=" + W + "]";
		}
	}

	// 입력
	static int N, M, K;
	static boolean[] isPower;
	static boolean linkPower;
	static PriorityQueue<Edge> pq = new PriorityQueue<>();

	// Union-Find
	static int[] parent;

	/*
	 * 발전소가 최소 1개 이상 연결된 최소신장트리이면 됨 1. MST 2. power check
	 */

	public static void main(String[] args) throws IOException {
		input();
		MST();
	}

	public static void MST() {
		if (N == K) {
			System.out.println(0);
			return;
		}

		int sum = 0;
		int cnt = 0;

		out: while (!pq.isEmpty()) {

			// 연결선 하나 꺼내기
			Edge k = pq.poll();
			
			// 둘 다 발전소에 연결이 되지 않은 경우
			if (!(isPower[find(k.A)] && isPower[find(k.B)])) {
				// 서로 대표가 다른 경우
				if (find(k.A) != find(k.B)) {
					union(k.A, k.B);
					cnt++;
					sum += k.W;
				}
			}

			// 연결이 N-K 일때보다 크거나 같으면 그때부터 확인
			// N-1 개 필요 + 발전기랑 연결
			if (cnt >= N - K) {
				// 모두 연결되었나? 그러면 종료
				for (int i = 1; i <= N; i++) {
					if (isPower[find(i)] == true) {
						continue;
					}
				}

				System.out.println(sum);
				return;
			}
		}

		// 연결이 안되었을 때
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

		// 발전소를 대표 노드로 임명
		// x 가 발전소
		if (isPower[x])
			parent[y] = x;
		
		// y 가 발전소
		else if (isPower[y])
			parent[x] = y;

		// 둘 다 아닌 경우
		else if (x < y)
			parent[y] = x;
		
		else
			parent[x] = y;
	}

	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		// idx 0번 사용 x
		parent = new int[N + 1];
		isPower = new boolean[N + 1];

		// union-find 입력
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int k = Integer.parseInt(st.nextToken());
			isPower[k] = true;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			pq.add(new Edge(A, B, W));
		}
	}
}