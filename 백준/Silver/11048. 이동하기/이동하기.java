import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[1001][1001];
		int[][] dp = new int[1001][1001];
		
		// input
		for(int i =0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0;j<M;j++) {
				map[i][j] =Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = map[0][0];
		
		// row base
		for(int i =1;i<N;i++) {
			dp[i][0] = dp[i-1][0] + map[i][0];
		}
		
		// col base
		for(int i =1;i<M;i++) {
			dp[0][i] = dp[0][i-1] + map[0][i];
		}
		
		// dp
		for(int i =1;i<N;i++) {
			for(int j =1;j<M;j++) {
				// 세로에서 온 것 과 가로에서 온 것의 최댓값
				// 어짜피 0보다 크기 때문에 굳이 대각선을 방문할 필요 x
				dp[i][j] =Math.max(dp[i-1][j]+map[i][j], dp[i][j-1]+map[i][j]);
			}
		}
		

		System.out.println(dp[N-1][M-1]);
	}
	
	public static void printMap(int[][] dp,int N ,int M) {
		for(int i=0;i<N;i++) {
			for(int j =0;j<M;j++) {
				System.out.print(dp[i][j] +" ");
			}
			System.out.println();
		}
	}
}