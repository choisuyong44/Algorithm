import java.io.*;
import java.util.*;

public class Solution {

	static int[][] map = new int[100][100];
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = 10;

		out: for (int T = 1; T < TC + 1; T++) {

			// 입력 받기
			int N = Integer.parseInt(br.readLine());
			for (int r = 0; r < 100; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < 100; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			
			for (int Col = 0; Col < map.length; Col++) {
				
				// 사람x pass
				if (map[0][Col] == 0) {
					continue;
				}
				
				int r = 0;
				int c = Col;
				int d = 0;
				
				/**
				 * 왼쪽 확인, 오른쪽 확인 아래로
				 * 
				 * d=0이면 직전에 아래쪽 이동
				 * d=1이면 직전에 왼쪽 이동
				 * d=2이면 직전에 오른쪽 이동
				 * 
				 * */
				
				// d=0이면 직전에 아래쪽 이동
				// d=1이면 직전에 왼쪽 이동
				// d=2이면 직전에 오른쪽 이동
				
				
				while (r <= 99) {
					if (r == 99) {
						if (map[r][c] == 2) {
							System.out.printf("#%d %d\n",T,Col);
							continue out;
						} else {
							break;
						}
					}

					// 왼쪽 보고
					// 직전에 오른쪽 이동 x, map 안에서 움직임,나아갈 공간 있음
					if (d != 2 && c - 1 >= 0 && map[r][c - 1] == 1) {
						d = 1;
						c = c - 1;
					}

					// 오른쪽 보고
					// 직전에 왼쪽 이동 x, map 안에서 움직임, 나아갈 공간 있음 
					else if (d != 1 && c + 1 <= 99 && map[r][c + 1] == 1) {
						d = 2;
						c = c + 1;
					}

					// 왼쪽 오른쪽 별일 없으면 내려가고
					else {
						d = 0;
						r = r + 1;
					}
				}
			}
		}
	}
}