import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

	static int[] dr = { 1, 1, -1, -1 };
	static int[] dc = { 1, -1, -1, 1 };

	static int N;
	static int max;
	static int[][] map;
	static boolean[][] visit;
	static boolean[] desert;

	static int ROW, COL;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int TC = Integer.parseInt(br.readLine());

		for (int T = 1; T < TC + 1; T++) {

			N = Integer.parseInt(br.readLine());

			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			max = 0;
			for (ROW = 0; ROW < N; ROW++) {
				for (COL = 0; COL < N; COL++) {
					visit = new boolean[N][N];
					desert = new boolean[101];
					dfs(ROW, COL, 0, 0);
				}
			}

			if(max ==0) {
				max= -1;
			}
			
			sb.append("#").append(T).append(" ").append(max).append("\n");
		}
		System.out.println(sb.toString());
	}

	public static void dfs(int r, int c, int d, int num) {
		// 시작점을 이미 방문했는 데 방문
		if(r== ROW && c==COL && visit[r][c]) {
			max = Math.max(max, num);
			return;
		}
		
		// 4번 다 돈 경우
		if(d==4) return;
		
		
		// 방향 그대로
		int nr = r+dr[d];
		int nc = c+dc[d];
		if(nr>=0 && nr<N && nc>=0 && nc<N) {
			if(!visit[nr][nc] && !desert[map[nr][nc]]) {
				visit[nr][nc] =true;
				desert[map[nr][nc]] = true;
				dfs(nr,nc,d,num+1);
				visit[nr][nc] =false;
				desert[map[nr][nc]] = false;
			}
		}
		
		if (d == 3)
			return;

		// 방향 전환
		d = d+1;
		nr = r+dr[d];
		nc = c+dc[d];
		if(nr>=0 && nr<N && nc>=0 && nc<N) {
			if(!visit[nr][nc] && !desert[map[nr][nc]]) {
				visit[nr][nc] =true;
				desert[map[nr][nc]] = true;
				dfs(nr,nc,d,num+1);
				visit[nr][nc] =false;
				desert[map[nr][nc]] = false;
			}
		}

	}
}