import java.io.*;
import java.util.*;

public class Solution {

	// 입력
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int D, W, K;
	static boolean[][] film;

	// 출력
	static int min;

	public static void main(String[] args) throws Exception {
		int TC = Integer.parseInt(br.readLine());

		for (int T = 1; T < TC + 1; T++) {
			input();

			// 기준 통과
			if (check()) {
				sb.append("#").append(T).append(" 0\n");
				continue;
			}
			
			// 아무리 많아야 K보다 작음
			for (int i = 1; i <= K; i++) {
				min = Integer.MAX_VALUE;
				medicine(0, 0, i);
				if (min != Integer.MAX_VALUE) {
					break;
				}
			}
			
			sb.append("#").append(T).append(" ").append(min).append("\n");
		}

		System.out.println(sb.toString());
	}

	// 약투여
	public static void medicine(int idx, int cnt, int depth) {
		// 통과가 이미 되었다. 가지치기
		if (min != Integer.MAX_VALUE) {
			return;
		}

		// 조합을 구해서 집어 넣었다.
		if (cnt == depth) {
			// 기준 통과
			if (check()) {
				min = depth;
			}
			return;
		}

		if(idx >= D) {
			return;
		}
		
		// D+depth만큼 자리를 구하는 조합
		boolean[] origin = film[idx].clone();
		
		// 안고르는 경우
		medicine(idx+1,cnt,depth);

		// A 고르는 경우
		Arrays.fill(film[idx], false);
		medicine(idx + 1, cnt + 1, depth);
		
		// B 고르는 경우
		Arrays.fill(film[idx], true);
		medicine(idx + 1, cnt + 1, depth);
		
		// 원상복구
		film[idx] = origin;
	}

	// 검사하는 함수
	public static boolean check() {
		// 가로줄 기준 : W
		out: for (int i = 0; i < W; i++) {

			boolean flag = film[0][i];
			int cnt = 1;

			for (int j = 1; j < D; j++) {

				if (flag == film[j][i]) {
					cnt++;
				}

				else {
					cnt = 1;
					flag = film[j][i];
				}

				if (cnt == K)
					continue out;
			}

			// cnt == K 가 없음
			return false;
		}

		// 모두 이상 x
		return true;
	}

	// 입력
	public static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		D = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		film = new boolean[D][W];

		for (int i = 0; i < D; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				if (Integer.parseInt(st.nextToken()) == 0) {
					film[i][j] = false;
				} else {
					film[i][j] = true;
				}
			}
		}
	}
}