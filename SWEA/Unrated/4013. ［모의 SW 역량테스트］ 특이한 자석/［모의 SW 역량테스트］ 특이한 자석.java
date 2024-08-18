import java.io.*;
import java.util.*;

public class Solution {

	static int[][] chain;
	static boolean[] flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());

		for (int T = 1; T < TC + 1; T++) {
			int COUNT = Integer.parseInt(br.readLine());

			chain = new int[5][8];
			flag = new boolean[5];
			
			for (int i = 1; i < 5; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < 8; j++) {
					chain[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < COUNT; i++) {
				st = new StringTokenizer(br.readLine());
				doRotate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			//printChain();
			
			int digit = 1;
			int sum = 0;
			for (int i = 1; i < 5; i++) {
				sum += chain[i][0] * digit;
				digit *=2;
			}
			
			sb.append("#").append(T).append(" ").append(sum).append("\n");
		}
		
		System.out.println(sb.toString());
	}

	public static void doRotate(int n, int d) {
		flag = new boolean[5];
		
		int direction = d;
		// 오른쪽
		for (int i = n; i < 4; i++) {
			if (chain[i][2] != chain[i + 1][6]) {
				flag[i + 1] = true;
			} else {
				break;
			}
		}

		// 오른쪽
		for (int i = n; i < 4; i++) {
			if (flag[i + 1] == true) {
				direction = -1 * direction;
				rotate(i + 1, direction);
			} else {
				break;
			}
		}

		// 왼쪽
		direction = d;
		for (int i = n; i > 1; i--) {
			if (chain[i][6] != chain[i - 1][2]) {
				flag[i - 1] = true;
			} else {
				break;
			}
		}

		// 왼쪽
		for (int i = n; i > 1; i--) {
			if (flag[i - 1] == true) {
				direction = -1 *direction;
				rotate(i - 1, direction);
			} else {
				break;
			}
		}
		
		rotate(n, d);
	}

	public static void rotate(int n, int d) {
		// 시계
		if (d == 1) {
			int tmp = chain[n][7];
			for (int i = 6; i >= 0; i--) {
				chain[n][i + 1] = chain[n][i];
			}
			chain[n][0] = tmp;

			return;
		}

		// 반시계
		else if(d== -1){
			int tmp = chain[n][0];
			for (int i = 1; i <=7; i++) {
				chain[n][i - 1] = chain[n][i];
			}
			chain[n][7] = tmp;
			return;
		}
	}
	
	public static void printChain() {
		System.out.println("++++++++++++++++++++++++++++++++++++++++");
		for(int i=1;i<5;i++) {
			for(int j=0;j<8;j++) {
				System.out.print(chain[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("++++++++++++++++++++++++++++++++++++++++");
	}
}