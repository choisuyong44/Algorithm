import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] dp = new int[1_000_001];
		
		// 1에서 출발
		dp[1] = 0;
		
		for(int i = 2;i<=N;i++) {
			// 1을 더하는 경우
			int min = dp[i-1] +1;
			
			// 2를 곱하는 경우
			if(i%2 ==0) min = Math.min(min, dp[i/2]+1);
			
			// 3을 곱하는 경우
			if(i%3 ==0) min = Math.min(min, dp[i/3]+1);
		
			dp[i] = min;
		}
		
		System.out.println(dp[N]);
	}
}