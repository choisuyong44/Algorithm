import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N,K,ans,max_height;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	// 높이가 같거나 낮은 지형 연결 x
	// 가로 세로만 연결 가능
	// 한 곳만 K만큼 깎을 수 있다.

	public static void main(String[] args) throws IOException{
		int T = Integer.parseInt(br.readLine());
		for(int tc =1;tc<T+1;tc++) {
			ans=0; max_height=0;
			input();
			
			// 정상 후보들 list에 담기
			List<int[]> list = new ArrayList<>();
			for(int i = 0;i<N;i++) {
				for(int j =0;j<N;j++) {
					if(max_height==map[i][j]) {
						list.add(new int[] {i,j});
					}
				}
			}
			
			// 정상 후보들에 대해서 dfs
			for(int[] k : list) {
				visited[k[0]][k[1]] =true;
				dfs(k[0],k[1],1,0);
				visited[k[0]][k[1]] =false;
			}
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
	public static void dfs(int r, int c, int depth, int cut) {
	    ans = Math.max(ans, depth); // 현재 깊이를 답과 비교
	    
	    for(int d = 0; d < 4; d++) {
	        int nr = r + dr[d];
	        int nc = c + dc[d];
	        
	        if(nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
	            if(map[nr][nc] < map[r][c]) { // 단순히 이동 가능
	                visited[nr][nc] = true;
	                dfs(nr, nc, depth + 1, cut);
	                visited[nr][nc] = false;
	            } else if(cut == 0 && map[nr][nc] - K < map[r][c]) { // 깎고 이동
	                visited[nr][nc] = true;
	                int original = map[nr][nc];
	                map[nr][nc] = map[r][c] - 1;
	                dfs(nr, nc, depth + 1, cut + 1);
	                map[nr][nc] = original; // 원상 복구
	                visited[nr][nc] = false;
	            }
	        }
	    }
	}
	
	public static void input() throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visited = new boolean[N][N];
		for(int i =0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max_height = Math.max(max_height, map[i][j]);
			}
		}
	}
}