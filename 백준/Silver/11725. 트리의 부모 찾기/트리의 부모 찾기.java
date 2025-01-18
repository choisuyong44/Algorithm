import java.io.*;
import java.util.*;

/*
 * root인 1이 언제 나올지 모름
 * 일단 다 연결해놓고, 1부터 bfs 출발하면 됨
 * parent[]에 자신의 부모를 저장
 * 
 * 주의 N+1 사이즈로 배열 받기, 1부터 시작
 */
public class Main {
	static int N,src,dest;
	static int[] parent;
	static boolean[] visited;
	static List<Integer>[] edge;
	static Queue<Integer> q;
	public static void main(String[] args) throws IOException{
		input();
		bfs(1);
		StringBuilder sb = new StringBuilder();
		for(int i = 2;i<N+1;i++) {
			sb.append(parent[i]).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void bfs(int start) {
		q = new LinkedList<Integer>();
		q.add(start);
		while(!q.isEmpty()) {
			int now = q.poll();
			if(visited[now]) continue;
			visited[now] = true;
			
			for(int next : edge[now]) {
				if(visited[next]) continue;
				parent[next] = now;
				q.add(next);
			}
		}
	}
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		parent = new int[N+1];
		visited = new boolean[N+1];
		edge = new List[N+1];
		for(int i =1;i<N+1;i++) {
			edge[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			src = Integer.parseInt(st.nextToken());
			dest = Integer.parseInt(st.nextToken());
			edge[src].add(dest);
			edge[dest].add(src);
		}
	}
}