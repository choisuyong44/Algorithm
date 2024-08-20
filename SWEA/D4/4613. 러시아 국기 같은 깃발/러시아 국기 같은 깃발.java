import java.io.*;
import java.util.*;

public class Solution {

	static final int W = 0;
	static final int B = 1;
	static final int R = 2;
	
	static int[][] colorCnt;
	static int N, M;

	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// TestCase 받기
		int TC = Integer.parseInt(br.readLine());

		// for T
		for (int T = 1; T < TC + 1; T++) {
			
			// N M
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			// for-for map
			colorCnt = new int[N][3];
			String s; char c;
			min = Integer.MAX_VALUE;
			
			for(int i=0;i<N;i++) {
				s = br.readLine();
				for(int j =0;j<M;j++) {
					c = s.charAt(j);
					switch(c) {
					case 'W':
						colorCnt[i][W]++;
						break;
					case 'B':
						colorCnt[i][B]++;
						break;
					case 'R':
						colorCnt[i][R]++;
						break;
					}
				}
			}
			
			// findMin()
			findMin();
			
			// sb.append
			sb.append("#").append(T).append(" ").append(min).append("\n");
		}
		
		System.out.println(sb.toString());
	}

	public static void findMin() {
		for(int L1 =1;L1<N-1;L1++) {
			for(int L2=L1+1;L2<N;L2++) {
				
				int sum = 0;
				
				// white
				for(int w = 0; w<L1;w++) {
					sum += M-colorCnt[w][W];
				}
				
				// blue
				for(int b = L1; b<L2;b++) {
					sum += M-colorCnt[b][B];
				}
				
				// red
				for(int r = L2; r<N;r++) {
					sum += M-colorCnt[r][R];
				}
				
				min = Math.min(sum, min);
			}
		}
	}
}