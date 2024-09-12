import java.io.*;
import java.util.*;

public class Main {

	final static int R = 0;
	final static int G = 1;
	final static int B = 2;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		// 컬러들의 합을 나타내는 용도
		int[][] dp = new int[1001][3];

		// 각각의 컬러의 비용 기록
		int[][] house = new int[1001][3];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			house[i][R] = Integer.parseInt(st.nextToken());
			house[i][G] = Integer.parseInt(st.nextToken());
			house[i][B] = Integer.parseInt(st.nextToken());
		}

		// 시작 세팅
		dp[1][R] = house[1][R];
		dp[1][G] = house[1][G];
		dp[1][B] = house[1][B];

		for(int i = 2;i<=N;i++) {
			
			// 현재 빨간색을 고른 경우
			// 직전에 초록 아니면 파랑을 골랐다.
			dp[i][R] = Math.min(dp[i-1][G],dp[i-1][B])+house[i][R];
			
			// 현재 초록색을 고른 경우
			// 직전에 빨강 아니면 파랑을 골랐다.
			dp[i][G] = Math.min(dp[i-1][R],dp[i-1][B])+house[i][G];
			
			// 현재 파랑색을 고른 경우
			// 직전에 빨강 아니면 초록을 골랐다.
			dp[i][B] = Math.min(dp[i-1][R],dp[i-1][G])+house[i][B];
		}
		
		// dp[N]의 0~2에서 최소값을 찾아주면 됨
		int min = Math.min(Math.min(dp[N][R], dp[N][G]),dp[N][B]);
		
		System.out.println(min);
	}
}