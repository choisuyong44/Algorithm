import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		// 0번 계단부터 300번 계단 까지
		int[] stair = new int[301];
		int[] dp = new int[301];
		

		for(int i = 1;i<=N;i++) {
			stair[i] = sc.nextInt();
		}
		
		// dp의 각 계단에 섰을 때 최댓값을 저장
		dp[1] = stair[1];
		dp[2] = stair[1]+stair[2];
		
		for(int i = 3;i<=N;i++) {
			// 연속 3칸 이동 x -> 3칸을 이동하려면 
			// 한칸 뛰고 두칸 뛰기
			// 두칸 뛰고 한칸 뛰기
			dp[i] = Math.max(dp[i-3]+stair[i-1]+stair[i], dp[i-2]+stair[i]);
		}
		
		System.out.println(dp[N]);
	}
}