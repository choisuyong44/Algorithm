import java.io.*;
import java.util.*;

// 시간 복잡도 V*E*logV

public class Main {

	static class Node implements Comparable<Node>{
		int idx;
		int cost;
		public Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return this.cost-o.cost;
		}
	}
	static PriorityQueue<Node> pq = new PriorityQueue<Node>();
	static int N,M,X,A,B,W;
	static int INF = Integer.MAX_VALUE;
	static boolean[] visited;
	static int[][] dist;
	static List<Node>[] edge;
	static int ans =0;
	public static void main(String[] args) throws IOException {
		input();
		for(int i = 1; i<N+1;i++) {
			pq.clear();
			visited = new boolean[N+1];
			djikstra(i);
		}		
		
		for(int i =1;i<N+1;i++) {
			ans = Math.max(ans, dist[i][X]+dist[X][i]);
		}
		
		System.out.println(ans);
	}
	
	public static void djikstra(int start) {
		pq.add(new Node(start,0)); dist[start][start] =0;
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(visited[now.idx]) continue;
			if(start !=X && now.idx==X) return;
			visited[now.idx] = true;
			for(Node next : edge[now.idx]) {
				if(dist[start][next.idx] > dist[start][now.idx]+next.cost) {
					dist[start][next.idx] = dist[start][now.idx]+next.cost;
					pq.add(new Node(next.idx,dist[start][next.idx]));
				}
			}
		}		
	}
	
	public static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		dist = new int[N+1][N+1];
		visited = new boolean[N+1];
		edge = new List[N+1];
		
		for(int i =0 ;i<N+1;i++) {
			edge[i] = new ArrayList<>();
			Arrays.fill(dist[i],INF);
		}
		
		for(int i = 0; i<M;i++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			edge[A].add(new Node(B,W));
		}
	}
}