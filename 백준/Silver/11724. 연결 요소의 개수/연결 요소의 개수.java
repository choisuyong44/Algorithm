import java.io.*;
import java.util.*;

public class Main {

	static boolean[] visit;
	static int[][] graph;
	static int N,M;
	static int cnt =0;
	
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N+1][N+1];
		visit = new boolean[N+1];
		int u,v;
		
		for(int i =0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			graph[u][v] = 1;
			graph[v][u] = 1;
		}
		
		for(int i =1;i<=N;i++) {
			if(visit[i]== false) {
				bfs(i);
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}
	
	public static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(v); int k;
		visit[v] = true;
		
		while(!queue.isEmpty()) {
			k = queue.poll();
			
			for(int i =1;i<=N;i++) {
				if(graph[k][i] == 1 && visit[i] ==false) {
					queue.add(i);
					visit[i] = true;
				}
			}
		}
	}

}