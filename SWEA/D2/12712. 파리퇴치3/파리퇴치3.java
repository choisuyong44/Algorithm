import java.io.*;
import java.util.*;

public class Solution {

	static int[][] map;
	static int max = Integer.MIN_VALUE;

	static int N;
	static int M;
	
	static int[] dr = {-1,-1,0,1,1,1,0,-1};
	static int[] dc = {0,1,1,1,0,-1,-1,-1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// TC 받기
		int TC = Integer.parseInt(br.readLine());
		
		// for T ~ TC
		for(int T = 1; T<TC+1;T++) {
		
		// N과 M 입력
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		max = Integer.MIN_VALUE;
		for(int r =0;r<N;r++) {
			for(int c =0 ;c<N;c++) {
				findMax(r,c);
			}
		}
		
		//System.out.printf("#%d %d\n",T,max);
		sb.append("#").append(T).append(" ").append(max).append("\n");
		}
		
		System.out.println(sb.toString());
	}

	public static void findMax(int r, int c) {
		int nr,nc;
		int sum;
		
		// +
		sum = map[r][c];
		for(int d =0;d<8;d+=2) {
			for(int i=1;i<M;i++) {
				nr = r+dr[d]*i;
				nc = c+dc[d]*i;
				
				if(nr >=0 && nr<N && nc >=0 && nc<N) {
					sum += map[nr][nc];
				}
			}
		}
		max = Math.max(sum, max);
		
		
		// x
		sum = map[r][c];
		for(int d =1;d<8;d+=2) {
			for(int i=1;i<M;i++) {
				nr = r+dr[d]*i;
				nc = c+dc[d]*i;
				
				if(nr >=0 && nr<N && nc >=0 && nc<N) {
					sum += map[nr][nc];
				}
			}
		}
		max = Math.max(sum, max);
	}
}