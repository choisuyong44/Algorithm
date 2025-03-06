import java.io.*;
import java.util.*;

public class Main {

	static class Node implements Comparable<Node>{
		int idx;
		int dist;
		public Node(int idx, int dist) {
			this.idx = idx;
			this.dist = dist;
		}
		@Override
		public int compareTo(Node o) {
			return this.dist-o.dist;
		}
	}
	static int N,M,cost,x,y,z;
	static List<Node>[] list;
	static boolean[] visited;
	static PriorityQueue<Node> pq = new PriorityQueue();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		while(input()) {
			simulation();
		}
	}
	
	static void simulation() {
		pq.clear();
		pq.add(new Node(0,0));
		
		while(!pq.isEmpty()) {
			Node k = pq.poll();
			
			if(visited[k.idx]) continue;
			visited[k.idx] = true;
			cost -= k.dist;
			if((--N)<=0) break;
 			
			for(Node next : list[k.idx]) {
				if(visited[next.idx]) continue;
				pq.add(next);
			}
		}
		
		System.out.println(cost);
	}
	
//	static void union(int x, int y) {
//		x = find(x);
//		y = find(y);
//		if(x>y) parent[y] = x;
//		else parent[x] = y;
//	}
//	
//	static int find(int x) {
//		if(x == parent[x]) return x;
//		else return parent[x] = find(parent[x]);
//	}
	
	static boolean input() throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		if(N ==0 && M == 0) return false;
		
		visited = new boolean[N];
		list = new List[N];
		cost =0;
		
		for(int i =0;i<N;i++) {
			list[i] = new ArrayList<Node>();
		}
		
		for(int i =0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			
			list[x].add(new Node(y,z));
			list[y].add(new Node(x,z));
			cost += z;
		}

		return true;
	}
}