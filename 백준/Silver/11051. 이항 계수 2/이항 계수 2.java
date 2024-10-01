import java.io.*;
import java.util.*;

public class Main {

	// nCr
	// nCr = (n-1)Cr + (n-1)C(r-1)

	static int[][] dp;
	
	public static void main(String[] args) throws IOException{
		Scanner sc  =new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		// n 과 c로 생각
		// 5C0 은 다 1
		dp = new int[1001][1001];
		for(int i=1;i<1001;i++) {
			dp[i][0] = 1;
			dp[i][1] = i;
		}
		
		for(int n =2;n<=1000;n++) {
			for(int k =2;k<=1000;k++) {
				dp[n][k] = (dp[n-1][k-1]+dp[n-1][k])%10007;
			}
		}
		
		System.out.println(dp[N][K]);
	}
}