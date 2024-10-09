import java.io.*;
import java.util.*;

public class Main {

	static class Node implements Comparable<Node> {
		int idx;
		int cost;
		public Node(int idx,int cost) {
			super();
			this.idx = idx;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.cost-o.cost;
		}
		@Override
		public String toString() {
			return "Node [idx=" + idx + ", cost=" + cost + "]";
		}
	}
	static int INF = Integer.MAX_VALUE;
	static int[] dist;
	static boolean[] visited;
	static PriorityQueue<Node> pq = new PriorityQueue<Node>();
	static List<Node>[] edge;
	static int N,M,A,B,W;
	
	public static void main(String[] args) throws IOException{
		input();
		djikstra(1);
		System.out.println(dist[N]);
	}
	
	public static void djikstra(int start) {
		pq.add(new Node(start,0)); dist[start] =0;
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(visited[now.idx]) continue;
            if(now.idx==N) return;
			visited[now.idx]=true;
			for(Node next : edge[now.idx]) {
				if(dist[next.idx] > dist[now.idx]+next.cost) {
					dist[next.idx] = dist[now.idx]+next.cost;
					pq.add(new Node(next.idx,dist[next.idx]));
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
		edge = new List[N+1];
		dist = new int[N+1]; Arrays.fill(dist, INF);
		visited = new boolean[N+1];
		for(int i =0;i<=N;i++) {
			edge[i] = new ArrayList<Node>();
		}
		for(int i =0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			edge[A].add(new Node(B,W));
			edge[B].add(new Node(A,W));
		}
	}
}