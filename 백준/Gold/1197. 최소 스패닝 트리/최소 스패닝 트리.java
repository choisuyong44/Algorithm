import java.io.*;
import java.util.*;

public class Main {

	static class Edge implements Comparable<Edge> {

		int v1;
		int v2;
		int w;

		public Edge(int v1, int v2, int w) {
			this.v1 = v1;
			this.v2 = v2;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.w - o.w;
		}
	}

	static int[] parent;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int V,E;
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		parent = new int[V+1];
		for(int i=1;i<=V;i++) {
			parent[i] = i;
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			pq.add(new Edge(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		
		int cnt =0; int sum =0;
		while(true) {
			Edge k = pq.poll();
			
			if(find(k.v1)!=find(k.v2)) {
				sum += k.w;
				union(k.v1,k.v2);
				cnt++;
				if(cnt == V-1) break;
			}
		}
		System.out.println(sum);
	}

	public static int find(int x) {
		if (x == parent[x])return x;
		return parent[x] = find(parent[x]);
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x < y) parent[y] = x;
		else parent[x] = y;
	}
}