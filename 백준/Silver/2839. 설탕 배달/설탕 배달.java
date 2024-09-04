import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int[] dp = new int[5001];
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		N = sc.nextInt();
	
		Arrays.fill(dp, 9999);
		dp[3] =1;
		dp[5] =1;
		
		for(int i= 6;i<=5000;i++) {
			dp[i] = Math.min(dp[i-3]+1, dp[i-5]+1);
		}
		
		if(dp[N]>=9999) {
			System.out.println(-1);
		}
		else {
			System.out.println(dp[N]);
		}
	}
}