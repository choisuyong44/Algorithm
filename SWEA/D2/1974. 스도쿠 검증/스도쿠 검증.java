import java.io.*;
import java.util.*;

public class Solution {

	static int[][] map = new int[9][9];
	static boolean[] check = new boolean[9];

	static int[] dr = {-1,-1,0,1,1,1,0,-1};
	static int[] dc = {0,1,1,1,0,-1,-1,-1};
	
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		out : for(int T = 1; T<TC+1;T++) {
			
			for(int i =0;i<9;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j =0;j<9;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 네모 검사
			for(int r =0 ;r<9;r++) {
				for(int c=0;c<9;c++) {
					if(r%3 == 1 && c%3==1) {
						check = new boolean[9];
						
						check[map[r][c]-1] = true;
						for(int d=0;d<8;d++) {
							int row = r + dr[d];
							int col = c + dc[d];
							
							check[map[row][col]-1] = true;
						}
						
						// 검사
						for(int i =0;i<check.length;i++) {
							if(check[i]==false) {
								System.out.printf("#%d 0\n",T);
								continue out;
							}
						}
					}
				}
			}
			
			// 가로 검사
			for(int r =0 ;r<9;r++) {
				check = new boolean[9];
				for(int c =0;c<9;c++) {
					check[map[r][c]-1] = true;
				}
				
				for(int i =0;i<check.length;i++) {
					if(check[i]==false) {
						System.out.printf("#%d 0\n",T);
						continue out;
					}
				}
			}
			
			
			// 세로 검사
			for(int c =0 ;c<9;c++) {
				check = new boolean[9];
				for(int r =0;r<9;r++) {
					check[map[r][c]-1] = true;
				}
				
				for(int i =0;i<check.length;i++) {
					if(check[i]==false) {
						System.out.printf("#%d 0\n",T);
						continue out;
					}
				}
			}
			
			System.out.printf("#%d 1\n",T);
		}
		
	}
}