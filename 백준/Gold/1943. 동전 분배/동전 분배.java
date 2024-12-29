import java.io.*;
import java.util.*;

public class Main {
	
	static int N,sum,coin,cnt;
	static List<int[]> coins;
	static boolean[][] dp;
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		for(int i =0;i<3;i++) {
			input(); 			
			
			if(sum %2 == 1) {
				System.out.println(0);
				continue;
			}
			
			sum /=2;
			dp = new boolean[N+1][sum+1];
			dp[0][0] = true;
			for(int n=1;n<=N;n++) {
				int[] k = coins.get(n-1);
				for(int m=0;m<=sum;m++) {
					if(dp[n-1][m]) {
						for(int cnt =0;cnt<=k[1];cnt++) {
							int tmp = m+k[0]*cnt;
							if(tmp <=sum) {
								dp[n][tmp] = true;
							}
						}
					}
				}
			}
			
			if(dp[N][sum])System.out.println(1);
			else System.out.println(0);
		}
	}
	
	public static void input() throws IOException{
		
		N = Integer.parseInt(br.readLine());
		coins = new ArrayList<>();
		sum =0;
		
		for(int i =0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			coin = Integer.parseInt(st.nextToken());
			cnt = Integer.parseInt(st.nextToken());
			sum += coin * cnt;
			coins.add(new int[] {coin,cnt});
		}
	}
}