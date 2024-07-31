import java.io.*;
import java.util.*;

public class Solution {

	static int[][] map = new int[100][100];

	// 8 9 6 3 2 1 4 7
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		/** 
		 * TC : 10 고정
		 * 배열사이즈 : 100 * 100 고정
		 * 
		 * 최댓값 찾기 -> 100 번 + 100번 + 대각선 2번
		 * 
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = 10;

		for (int T = 1; T < TC + 1; T++) {

			int N = Integer.parseInt(br.readLine());

			for (int r = 0; r < 100; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < 100; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = 0;
			int sum;
			
			// 가로 
			for(int r=0;r<100;r++) {
				sum = 0;
				for(int c =0;c<100;c++) {
					sum +=map[r][c];
				}
				max = Math.max(sum, max);
			}
			
			// 세로
			for(int c=0;c<100;c++) {
				sum = 0;
				for(int r =0;r<100;r++) {
					sum +=map[r][c];
				}
				max = Math.max(sum, max);
			}
			
			// 대각 1 \
			sum =0;
			for(int k =0;k<100;k++) {
				sum += map[k][k]; 
			}
			
			max =Math.max(sum, max);
			
			// 대각 2 /
			sum =0;
			for(int k =0;k<100;k++) {
				sum += map[k][100-1-k]; 
			}
			
			max =Math.max(sum, max);
			
			System.out.printf("#%d %d\n",N,max);
		}
	}
}