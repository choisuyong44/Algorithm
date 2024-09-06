import java.util.*;
import java.io.*;

public class Solution {
	
	static int last;
	static int N,start;
	static List[] adj;
	static boolean[] visit;
	
	static Comparator<int[]> condition = new Comparator<int[]>() {
		
		@Override
		public int compare(int[] o1, int[] o2) {
			return o1[1] - o2[1];
		};
	};
	
	static PriorityQueue<int[]> pq = new PriorityQueue<int[]>(condition);
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = 10;
		
	
		for(int T = 1; T<TC+1;T++) {
			pq.clear();
			// 연락을 완료했는 지 확인하는 배열
			visit = new boolean[101];
			adj = new List[101];
			
			for(int i=0;i<101;i++) {
				adj[i] = new ArrayList<int[]>();
			}
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
		
			st = new StringTokenizer(br.readLine());
			for(int i =0;i<N/2;i++) {
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				
				adj[A].add(new int[] {A,B});
			}
			
			last = 0;
			contact(start);
			
			System.out.println("#"+T+" "+last);
		}
		
	}
	
	
	public static void contact(int start) {
		pq.addAll(adj[start]);
		visit[start] = true;
		while(!pq.isEmpty()) {
			
			PriorityQueue<int[]> tmp = new PriorityQueue<int[]>(condition);
			
			// 생성
			while(!pq.isEmpty()) {
				
				int[] k = pq.poll();
				
				if(visit[k[1]]) continue;
							// 방문처리
				last = k[1];
				visit[k[1]] = true;
			
				 tmp.addAll(adj[k[1]]);
			}
			
			pq = tmp;
		}
	};
}