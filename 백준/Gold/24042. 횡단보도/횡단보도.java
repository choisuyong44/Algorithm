import java.io.*;
import java.util.*;

public class Main {

	static int N,M,src,dest;
	static long[] dist;
	static class Node implements Comparable<Node>{
		int idx;long cost;
		Node(int idx, long cost) {
			this.idx = idx;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			if(this.cost==o.cost) return 0;
			return this.cost-o.cost>0?1:-1;
		}
	}
	static List<Node>[] edge;
	static PriorityQueue<Node> pq = new PriorityQueue<Node>();
	public static void main(String[] args) throws IOException {
		input();
		djikstra();
		System.out.println(dist[N]);
	}
	static void djikstra() {
		pq.add(new Node(1,0));
		dist[1] = 0;
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			// 현재 비용이 저장되어있는 비용보다 크면 pass
			if(now.cost > dist[now.idx]) continue;
			
			for(Node next : edge[now.idx]) {
				long nextCost = 0;
				
				if(now.cost<=next.cost) {
					nextCost = next.cost+1; 
				}
				else {
					// M으로 쪼갠 후 다시 M으로 담기
					nextCost = ((long)Math.ceil(((double)now.cost-next.cost)/M))*M +next.cost+1;
				}
					
				if(nextCost< dist[next.idx]) {
					dist[next.idx] = nextCost;
					pq.add(new Node(next.idx,nextCost));
				}
			}
		}
	}
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		edge = new List[N+1];
		dist = new long[N+1];
		Arrays.fill(dist,Long.MAX_VALUE);
		for(int i = 1;i<N+1;i++) {
			edge[i] = new ArrayList<Node>();
		}
		for(int i =0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			src = Integer.parseInt(st.nextToken());
			dest = Integer.parseInt(st.nextToken());
			edge[src].add(new Node(dest,i));
			edge[dest].add(new Node(src,i));
		}
	}
}