import java.io.*;
import java.util.*;

public class Main {

	static List<Integer>[] list;
	static int visit[];
	static int V;
	static int E;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());

		for (int T = 1; T < TC + 1; T++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			// V+1 인 이유 -> 0번 인덱스 안쓸려고
			list = new List[V + 1];
			
			// list 구현 및 초기화
			for(int i =0;i<=V;i++) {
				list[i] = new ArrayList<Integer>();
			}
			
			int s;
			int e;
			
			// 간선만큼 받기
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				s = Integer.parseInt(st.nextToken());
				e = Integer.parseInt(st.nextToken());
				list[s].add(e);
				list[e].add(s);
			}
			
			visit = new int[V + 1];
			bfs(1);
		}
	}

	public static void bfs(int v) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i = 1;i<=V;i++) {
			if(visit[i]==0) {
				visit[i] =1;
				q.add(i);
			}
			
			while(!q.isEmpty()) {
				int pos = q.poll();
				
				for(int next : list[pos]) {
					
					if(visit[next] ==visit[pos]) {
						System.out.println("NO");
						return;
					}
					
					if(visit[next]==0) {
						q.add(next);
						
						if(visit[pos] == 1) {
							visit[next] =2;
						}else {
							visit[next] = 1;
						}
					}
				}
			}
		}
		
		System.out.println("YES");
	}
}