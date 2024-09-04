import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long[] dp = new long[1001];
		
		dp[1] = 1;
		dp[2] = 2;
		
		for (int i = 3; i < 1001; i++) {
			// 1로 만드는 경우
			dp[i] = (dp[i-1]+dp[i-2])%10007;
		}

		int N = sc.nextInt();
		System.out.println(dp[N]);

	}
}