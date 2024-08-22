import java.io.*;
import java.util.*;

public class Main {

	static int[] parent; 
	static PriorityQueue<Link> pq = new PriorityQueue<>(new Comparator<Link>() {
		@Override
		public int compare(Link o1, Link o2) {
			return o1.weight - o2.weight;
		}; 
	});
	
	static int N;
	static int M;
	
	static int min =0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		parent = new int[N+1];
		
		for(int i = 1;i<=N;i++) {
			parent[i] = i;
		}
		
		int a,b,c;
		for(int i =0;i<M;i++) {
			// union
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			pq.add(new Link(a,b,c));
		}
		
		while(!pq.isEmpty()) {
			union(pq.poll());
		}
		
		System.out.println(min);
	}
	
	public static int find(int x) {
		if(x == parent[x]) {
			return x;
		}
		
		return parent[x] = find(parent[x]);
	}
	
	public static void union(Link link) {
		int x = link.x;
		int y = link.y;
		
		x = find(x);
		y = find(y);
		
		if(x!=y) {
			min += link.weight;
			if(x<y) parent[y] = x;
			else parent[x] = y;
		}
	}
	
	static class Link{
		int x;
		int y;
		int weight;
		
		public Link(int x, int y, int weight) {
			this.x = x;
			this.y = y;
			this.weight = weight;
		}
	}
}