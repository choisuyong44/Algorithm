import java.io.*;
import java.util.*;

public class Main {

	// Left Center Right
	final static int L = 0;
	final static int C = 1;
	final static int R = 2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		
		char[][] num = new char[100_001][3];
		int[][] max = new int[100_001][3];
		int[][] min = new int[100_001][3];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			num[i][L] = (char)(st.nextToken().charAt(0)-'0');
			num[i][C] = (char)(st.nextToken().charAt(0)-'0');
			num[i][R] = (char)(st.nextToken().charAt(0)-'0');
		}
		
		max[1][L] = num[1][L];
		max[1][C] = num[1][C];
		max[1][R] = num[1][R];
		
		min[1][L] = num[1][L];
		min[1][C] = num[1][C];
		min[1][R] = num[1][R];
	
		for(int i = 2;i<=N;i++) {
			// 현재 L
			// 직전 L 또는 C
			max[i][L] = Math.max(max[i-1][L],max[i-1][C])+num[i][L];
			// 현재 C
			// 직전 L 또는 C 또는 R
			max[i][C] = Math.max(Math.max(max[i-1][L],max[i-1][C]),max[i-1][R])+num[i][C];
			// 현재 R
			// 직전 C 또는 R
			max[i][R] = Math.max(max[i-1][C],max[i-1][R])+num[i][R];
			
			// 현재 L
			// 직전 L 또는 C
			min[i][L] = Math.min(min[i-1][L],min[i-1][C])+num[i][L];
			// 현재 C
			// 직전 L 또는 C 또는 R
			min[i][C] = Math.min(Math.min(min[i-1][L],min[i-1][C]),min[i-1][R])+num[i][C];
			// 현재 R
			// 직전 C 또는 R
			min[i][R] = Math.min(min[i-1][C],min[i-1][R])+num[i][R];
		}
		
		// max
		int maxValue = Math.max(Math.max(max[N][L], max[N][C]),max[N][R]);
		// min
		int minValue = Math.min(Math.min(min[N][L], min[N][C]),min[N][R]);
		
		System.out.println(maxValue + " " +minValue);
	}
}