import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[][] subject;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		input();
		
		// i 과목 인덱스
		for (int i = 1; i < M+1; i++) {
			// j 시간
			for (int j = 1; j < N + 1; j++) {
                // 한 과목에 소요되는 시간이 j보다 클 때, 이전 값 가져오기
				if (subject[i][1] > j) {
					dp[i][j] = dp[i - 1][j];
				}
                // 아닌 경우, 이전 값과 해당 과목을 추가했을 떄 값 비교
				else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - subject[i][1]] + subject[i][0]);
				}
			}
		}

		System.out.println(dp[M][N]);
	}

	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		subject = new int[M+1][2];
		dp = new int[M+1][N+1];
		for (int i = 1; i < M+1; i++) {
			st = new StringTokenizer(br.readLine());
			subject[i][0] = Integer.parseInt(st.nextToken());
			subject[i][1] = Integer.parseInt(st.nextToken());
		}
	}
}