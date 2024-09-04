import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] dp = new int[1000001];
		
		int N = sc.nextInt();
		dp[1] =0;
		dp[2] =1;
		dp[3] =1;
		
		for(int i= 4;i<=1_000_000;i++) {
			dp[i] = dp[i-1]+1;
			if(i%2==0) {
				dp[i] = Math.min(dp[i],dp[i/2]+1);
			}
			if(i%3==0) {
				dp[i] = Math.min(dp[i],dp[i/3]+1);
			}
		}
		
		System.out.println(dp[N]);
	}
}