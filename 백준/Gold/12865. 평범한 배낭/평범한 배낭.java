import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int W = sc.nextInt();

		int[] weights = new int[N + 1];
		int[] cost = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			weights[i] = sc.nextInt();
			cost[i] = sc.nextInt();
		}

		int[][] dp = new int[N + 1][W + 1];

		// 물건을 고려
		for (int i = 1; i <= N; i++) {

			// 임시 무게
			for (int w = 0; w <= W; w++) {

				// 내가 고려할 물건의 무게가 임시무게보다 작다면..
				if (weights[i] <= w) {
					dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-weights[i]]+cost[i]);
				} else {
					// 아니라면 이전까지 고민한게 베스트
					dp[i][w] = dp[i-1][w];
				}
			}
		}
		
		System.out.println(dp[N][W]);
	}
}