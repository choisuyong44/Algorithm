import java.io.*;


public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long[] dp = new long[N+1];
		
		
		// delete NumCount;
		dp[0] = 0;
		dp[1] = 1;
		
		if(N== 1) {
			System.out.println(1);
			return;
		}
		
		int dpIdx= 2;
		
		while(dpIdx <= N) {
			dp[dpIdx] = dp[dpIdx-1] + dp[dpIdx-2];
			dpIdx++;
		}
		
		System.out.println(dp[dpIdx-1]);
	}
}