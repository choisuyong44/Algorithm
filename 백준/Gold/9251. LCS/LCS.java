import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		
		// 0부터 1000까지
		int[][] dp = new int[1001][1001];
	
		int N = s1.length();
		int M = s2.length();
		
		for(int i =1;i<=N;i++) {
			for(int j =1;j<=M;j++) {
				// 문자가 같은 경우
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1]+1;
				}
				// 문자가 다른 경우
				else {
					dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}
		
		System.out.println(dp[N][M]);
	}
}