import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Edge implements Comparable<Edge>{
		int A;
		int B;
		double W;
		public Edge(int a, int b, double w) {
			A = a;
			B = b;
			W = w;
		}
		@Override
		public int compareTo(Edge o) {
			return this.W > o.W ? 1: -1;
		}
	}
	static int N;
	static double[][] list;
	static int[] parent;
	static PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
	public static void main(String[] args) throws IOException{
		input();
		int cnt = N-1; double ans = 0;
		for(int i=1;i<=N-1;i++) {
			for(int j =i+1;j<=N;j++) {
				pq.add(new Edge(i,j,distance(i,j)));
			}
		}
		while(!pq.isEmpty()) {
			if(cnt==0)break;
			// 둘이 find가 아니면 연결
			Edge k = pq.poll();
			if(find(k.A)!=find(k.B)) {
				union(k.A, k.B);
				ans += k.W;
				cnt--;
			}
		}
		System.out.printf("%.2f",ans);
	}
	
	public static double distance(int i, int j) {
		double tmp = Math.pow(list[i][0]-list[j][0],2)+ Math.pow(list[i][1]-list[j][1],2);
		return Math.sqrt(tmp);
	}
	
	public static int find(int x) {
		if(parent[x] == x)return x;
		return parent[x] = find(parent[x]);
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x>y) parent[y] =x;
		else parent[x] =y;
	}
	
	public static void input() throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		parent = new int[N+1];
		for(int i =1;i<=N;i++) {
			parent[i] = i;
		}
		list = new double[N+1][2];
		for(int i =1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			list[i][0] = Double.parseDouble(st.nextToken());
			list[i][1] = Double.parseDouble(st.nextToken());
		}
	}
}