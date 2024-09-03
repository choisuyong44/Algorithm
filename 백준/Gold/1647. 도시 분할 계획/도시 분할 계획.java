import java.io.*;
import java.util.*;

public class Main {
	
	static int min =0;
	
	static int N,M;
	
	// 연결 확인
	static int[] parent;
	
	static PriorityQueue<Road> pq = new PriorityQueue<Road>(new Comparator<Road>() {
		@Override
		public int compare(Road o1, Road o2) {
			return o1.w-o2.w;
		};
	});

	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 간선 값 받기 - 0은 버림
		parent = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			parent[i] =i;
		}
		
		// v1, v2, w
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			pq.add(new Road(v1,v2,w));
		}
		
		// 연결하는 함수
		link();
		
		System.out.println(min);
		
	}
	
	public static void link() {
		int tmp =0; int cnt =0;
		while(!pq.isEmpty()) {
			
			Road l = pq.poll();
			
			// 연결이 안되어있는 경우
			if(!isLink(l.v1, l.v2)) {
				cnt++;
				union(l.v1,l.v2);
				min += l.w;
				tmp = l.w;
			}
			
			else continue;
			
			// 모두 연결이 되었는 지 확인
			if(cnt >= N-1 && checklinkedAll()) {
				min -= tmp;
				return;
			}
		}
	}
	
	public static boolean checklinkedAll() {
		int k = find(1);
		for(int i=2;i<=N;i++) {
			if(find(i)!=k) return false;
		}
		return true;
	}
	
	public static void union(int x,int y) {
		x = find(x);
		y = find(y);
		
		if(x==y) return;
		
		if(x<y) parent[y] = x;
		else parent[x] = y;
	}
	
	public static int find(int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	
	public static boolean isLink(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x==y) return true;
		else return false;
	}
	
	static class Road{
		int v1;
		int v2;
		int w;
		
		public Road(int v1, int v2, int w) {
			this.v1 = v1;
			this.v2 = v2;
			this.w = w;
		}
	}
}