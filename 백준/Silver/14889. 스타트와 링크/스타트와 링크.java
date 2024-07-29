import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[][] team;
	static int min;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		team = new int[N][N];
		visit = new boolean[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				team[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		min = Integer.MAX_VALUE;

		dfs(0, 0);

		System.out.println(min);
	}

	public static void dfs(int idx, int cnt) {

		if (cnt == N / 2) {
			calDiff();
			return;
		}

		for (int i = idx; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				dfs(i + 1, cnt + 1);
				visit[i] = false;
			}
		}
	}

	public static void calDiff() {

		int visitTeam = 0;
		int nonVisitTeam = 0;

		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {

				if (visit[i] && visit[j]) {
					visitTeam += team[i][j];
					visitTeam += team[j][i];
				}

				else if (!visit[i] && !visit[j]) {
					nonVisitTeam += team[i][j];
					nonVisitTeam += team[j][i];
				}
			}
		}

		min = Math.min(min, Math.abs(visitTeam - nonVisitTeam));
		
		if(min == 0) {
			System.out.println(0);
			System.exit(0);
		}
	}
}