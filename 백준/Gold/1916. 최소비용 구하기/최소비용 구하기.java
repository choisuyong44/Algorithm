import java.io.*;
import java.util.*;

public class Main {

	static class Node implements Comparable<Node>{
		int idx;
		int cost;
		Node(int idx, int cost){
			this.idx =idx;
			this.cost =cost;
		}
		@Override
		public int compareTo(Node o) {
			return this.cost-o.cost;
		}
	}
	static int N,M,src,dest;
	static int dist[];
	static boolean visited[];
	static List<Node>[] edge;
	static PriorityQueue<Node> pq;

	public static void main(String[] args) throws IOException {
		input();
		djikstra();
		System.out.println(dist[dest]);
	}
	
	static void djikstra() {
		pq = new PriorityQueue<Node>();
		pq.add(new Node(src,0)); 
		dist[src] = 0;
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(visited[now.idx]) continue;
			visited[now.idx] = true;
			
			for(Node next : edge[now.idx]) {
				if(dist[next.idx] > dist[now.idx]+next.cost) {
					dist[next.idx] = dist[now.idx]+next.cost;
					pq.add(new Node(next.idx, dist[next.idx]));
				}
			}
		}
	}
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		visited = new boolean[N+1];
		edge = new List[N+1];
		for(int i =1;i<N+1;i++) {
			edge[i] = new ArrayList<Node>();
		}
		
		for(int i =0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			edge[start].add(new Node(end,cost));
		}
		st = new StringTokenizer(br.readLine());
		src = Integer.parseInt(st.nextToken());
		dest = Integer.parseInt(st.nextToken());
	}
}