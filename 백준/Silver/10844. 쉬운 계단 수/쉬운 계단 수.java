import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int mod = 1_000_000_000;
		
		long[][] dp = new long[N+1][10];
		
		for(int i=1;i<10;i++) {
			dp[1][i] = 1;
		}
		
		for(int i=2;i<=N;i++) {
			dp[i][0] = dp[i-1][1];
			dp[i][9] = dp[i-1][8];
			for(int j =1;j<9;j++) {
				dp[i][j] = dp[i-1][j-1]%mod+dp[i-1][j+1]%mod;
			}
		}
		
		long sum =0;
		
		for(int i=0;i<=9;i++) {
			sum += dp[N][i]%mod;
		}

	System.out.println(sum%mod);
}
}