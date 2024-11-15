import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


// 1칸에는 사다리 또는 뱀 하나만 가능
// 가장 먼저 도착한 게 가장 빠른길
public class Main {

	static int N,M;
	static boolean[] visited;
	static Queue<int[]> q;
	static int[][] link;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		q = new LinkedList<int[]>();
		link = new int[N+M][2];
		visited = new boolean[101];
		
		for(int i =0;i<N+M;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0;j<2;j++) {
				link[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
	}
	
	public static void bfs() {
		q.add(new int[] {1,0}); // 0 : 위치 | 1 : 비용
		visited[1] = true;
		while(!q.isEmpty()) {
			int[] k = q.poll();	
			
			if(k[0]==100) {
				System.out.println(k[1]);
				return;
			}
			
			out: for(int i =1;i<=6;i++) {
				if(k[0]+i > 100 || visited[k[0]+i]) continue;
				
				// 사다리 타기
				for(int[] point : link) {
					if(point[0]==k[0]+i) {
						q.add(new int[]{point[1],k[1]+1});	// 0 : 출발 | 1 : 도착
						visited[point[1]] = true;
						continue out;
					}
				}
				
				// 그냥 가기
				q.add(new int[] {k[0]+i, k[1]+1});
				visited[k[0]+i] = true;
			}
		}
	}
}