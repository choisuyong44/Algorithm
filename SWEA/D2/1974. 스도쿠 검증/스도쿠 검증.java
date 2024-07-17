import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {

		/*
		 * 1. 입력
		 * 
		 * 2. 문제 - board 9x9 - 스도쿠 퍼즐이 맞춰졌는 지를 확인 해라 - 숫자가 겹치는 게 없으면 1, 있으면 0
		 * 
		 * 3. 방법 - 입력 받기 - dr,dc 생성 - 가운데 겹치는 게 있는 지 확인 (1,1) (1,4) (1,7) (4,1) (4,4)
		 * (4,7) (7,1) (7,4) (7,7) - 가로 - 세로
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] board = new int[9][9];

		int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
		int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

		int TestCase = Integer.parseInt(br.readLine());
		out:for (int T = 1; T < TestCase + 1; T++) {

			// 입력
			for (int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			
			// 검사
			int[] checkBoard;
			for (int row = 0; row < 9; row++) {

				// 가로 검사 row 고정
				checkBoard = new int[10];
				for (int i = 0; i < 9; i++) {
					checkBoard[board[row][i]] = 1;
				}
				for (int i = 1; i < checkBoard.length; i++) {
					if (checkBoard[i] != 1) {
						System.out.printf("#%d 0\n", T);
						continue out;
					}
				}

				for (int col = 0; col < 9; col++) {

					// 3x3 네모 확인 1, 4, 7 만 확인하면 됨
					if (row % 3 == 1 && col % 3 == 1) {

						// 표시
						// checkBoard 0 1 2 3 4 5 6 7 8 9
						int r;
						int c;
						// 10을 한 이유 0 제외 초기화
						checkBoard = new int[10];
						checkBoard[board[row][col]] += 1;
						for (int d = 0; d < dr.length; d++) {
							r = row + dr[d];
							c = col + dc[d];
							checkBoard[board[r][c]] += 1;
						}

						// 검사
						for (int i = 1; i < checkBoard.length; i++) {
							if (checkBoard[i] != 1) {
								System.out.printf("#%d 0\n", T);
								continue out;
							}
						}
					}

					if (row == 0) {
						
						// 세로 검사 col 고정
						checkBoard = new int[10];

						for (int i = 0; i < 9; i++) {
							checkBoard[board[i][col]] += 1;
						}

						for (int i = 1; i < checkBoard.length; i++) {
							if (checkBoard[i] != 1) {
								System.out.printf("#%d 0\n", T);
								continue out;
							}
						}
					}

				}
			}

			System.out.printf("#%d 1\n", T);
		}
	}
}