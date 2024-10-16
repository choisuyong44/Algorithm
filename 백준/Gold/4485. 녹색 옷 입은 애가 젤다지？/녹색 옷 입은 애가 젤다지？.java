import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] map, dist;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static class Node implements Comparable<Node> {
		int r, c, cost;

		public Node(int r, int c, int cost) {
			super();
			this.r = r;
			this.c = c;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node n) {
			return Integer.compare(this.cost, n.cost);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = 1;
		
		while(true) {
			N = Integer.parseInt(br.readLine());
			
			if(N == 0) break;
			
			map = new int[N][N];
			for (int r = 0; r < N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			dist = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			}
			
			dijkstra();
			
			sb.append("Problem " + tc++ + ": " + dist[N - 1][N - 1]).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(0, 0, map[0][0]));
		dist[0][0] = map[0][0];
		
		boolean[][] visit = new boolean[N][N];
		visit[0][0] = true;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || visit[nr][nc]) continue;
				
				if(dist[nr][nc] > cur.cost + map[nr][nc]) {
					dist[nr][nc] = cur.cost + map[nr][nc];
					visit[nr][nc] = true;
					
					pq.offer(new Node(nr, nc, dist[nr][nc]));
				}
			}
		}
	}

}