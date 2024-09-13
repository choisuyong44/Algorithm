import java.io.*;
import java.util.*;

public class Main {

	static class Edge implements Comparable<Edge> {
		int A;
		int B;
		int W;

		public Edge(int a, int b, int w) {
			A = a;
			B = b;
			W = w;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.W - o.W;
		}

		@Override
		public String toString() {
			return "Edge [A=" + A + ", B=" + B + ", W=" + W + "]";
		}
	}

	static int ans;
	static int V, E;
	static int[] parent;

	static PriorityQueue<Edge> pq = new PriorityQueue<Edge>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			pq.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		}

		// 마을이 2개면 연결할 필요가 없음
		if(V==2) {
			System.out.println(0);
			return;
		}
		
		solution();
	}

	public static void solution() {
		// 대표노드 set
		parent = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}
		
		int cnt = 0; ans =0;
		while (!pq.isEmpty()) {

			Edge e = pq.poll();
			
			if(find(e.A)!=find(e.B)) {
				ans += e.W;
				cnt++;
				union(e.A, e.B);
			
				// MST의 규칙에 따라 E = V-1 모두 연결 완료;
				// 우리는 2개로 분리하고자 함
				if(cnt == V-2) {
					System.out.println(ans);
					return;
				}
			}
		}
	}
	
	public static int find(int x) {
		if(x == parent[x]) return x;
		return parent[x] = find(parent[x]);
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x < y) parent[y] = x;
		else parent[x] = y;
	}
}