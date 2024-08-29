import java.io.*;
import java.util.*;

public class Main {

	static int[] small;
	static int[] ans;
	static boolean findAns = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		small = new int[9];
		ans = new int[7];

		for (int i = 0; i < 9; i++) {
			small[i] = Integer.parseInt(br.readLine());
		}

		dfs(0, 0, 0);
	}

	public static void dfs(int idx, int sum, int depth) {
		// 이미 구하면 탈출
		if (findAns)
			return;

		// 100 넘으면 탈출
		if (sum > 100)
			return;

		// 7인데 합이 100
		if (depth == 7) {
			if (sum == 100) {
				Arrays.sort(ans);
				for (int i = 0; i < 7; i++) {
					System.out.println(ans[i]);
				}
				findAns = true;
			}
            				
            return;
		}

		for (int i = idx; i < 9; i++) {
			ans[depth] = small[i];
			dfs(i + 1, sum + small[i], depth + 1);
		}
	}
}