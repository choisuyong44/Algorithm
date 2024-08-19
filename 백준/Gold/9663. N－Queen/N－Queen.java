import java.io.*;
import java.util.*;

public class Main {

	static int[] queen;

	static int N;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		queen = new int[N];

		dfs(0);

		System.out.println(cnt);
	}

	public static void dfs(int depth) {

		if (depth == N) {
			cnt++;
			return;
		}

		for (int i = 0; i < N; i++) {
			queen[depth] = i;
			// Possibility() 해당 열에서 i 번째 행에 놓을 수 있는지를 검사하는 함수
			if (possible(depth)) {
				dfs(depth + 1);
			}
		}

		return;
	}

	public static boolean possible(int col) {

		for (int i = 0; i < col; i++) {
			// 행에 일치하는게 있는지 판별
			if (queen[i] == queen[col]) {
				return false;
			}
			// 대각선에 일치하는게 있는지 판별
			else if (Math.abs(col - i) == Math.abs(queen[col] - queen[i])) {
				return false;
			}
		}
		return true;
	}
}