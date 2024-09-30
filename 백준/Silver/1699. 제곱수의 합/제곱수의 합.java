import java.io.*;
import java.util.*;

public class Main {

	static long[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		dp = new long[100001];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		dp[4] = 1;
		for (int i = 2; i < 100001; i++) {
			dp[i] = i;
			for (int j = 1; j * j <= i; j++) {
				if (dp[i] > dp[i - j * j] + 1) {
					dp[i] = dp[i - j * j] + 1;
				}
			}
		}
		System.out.println(dp[N]);
	}
}