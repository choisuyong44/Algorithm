import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	
	static class Edge implements Comparable<Edge>{
		int v1;
		int v2;
		long w;
		
		public Edge(int v1, int v2, long w) {
			super();
			this.v1 = v1;
			this.v2 = v2;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			if(this.w > o.w) return 1;
			else if(this.w < o.w) return -1;
			else return 0;
		}

		@Override
		public String toString() {
			return "Edge [v1=" + v1 + ", v2=" + v2 + ", w=" + w + "]";
		}
	}

	final static int X = 0;
	final static int Y = 1;
	final static int REP =2;
	
	static int N;
	static double E;
	
	static int[][] point;
	
	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int TC = Integer.parseInt(br.readLine());

		for (int T = 1; T < TC + 1; T++) {
			pq.clear();
			
			N = Integer.parseInt(br.readLine());
			
			// x, y, rep
			point = new int[N][3];
			
			for(int i=0;i<N;i++) {
				point[i][REP] = i;
			}

			// 입력
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				point[i][X] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				point[i][Y] = Integer.parseInt(st.nextToken());
			}
			
			E = Double.parseDouble(br.readLine());
			
			// 간선 생성 N * (N-1) /2
			for(int i=0;i<N-1;i++) {
				for(int j=i+1;j<N;j++) {
					pq.add(new Edge(i, j, diff(i,j)));
				}
			}
			
			// Union Find
			int cnt =0;
			long sum = 0;
			while(cnt < N-1) {
				Edge k = pq.poll();
				
				if(find(k.v1)!=find(k.v2)) {
					cnt++;
					sum += k.w;
					union(k.v1,k.v2);
				}
			}

			sum = Math.round(E*sum);
			sb.append("#").append(T).append(" ").append(sum).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x < y) point[y][REP] = x;
		else point[x][REP] = y;
	}
	
	public static int find(int x) {
		if(point[x][REP] == x) return x;
		return point[x][REP] = find(point[x][REP]);
	}
	
	public static long diff(int v1, int v2) {
		return (long)(Math.pow(point[v1][X]-point[v2][X],2)+Math.pow(point[v1][Y]-point[v2][Y],2));
	}
}