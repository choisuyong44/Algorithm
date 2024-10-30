import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static boolean[] visited;
	static int max = 0;
	static int N, M;
	static char[][] map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		visited = new boolean[26];
		visited[map[0][0]-'A'] = true;
		dfs(0, 0, 0);
		System.out.println(max);
	}

	static void dfs(int r, int c, int depth) {
		max = Math.max(max, depth+1);
		
		for(int d= 0;d<4;d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if(isValid(nr,nc) && !visited[map[nr][nc]-'A']) {
				int k = map[nr][nc] -'A';
				visited[k] = true;
				dfs(nr,nc,depth+1);
				visited[k] = false;
			}
		}
	}

	static boolean isValid(int r, int c) {
		if (r >= 0 && r < N && c >= 0 && c < M) {
			return true;
		}
		return false;
	}
}