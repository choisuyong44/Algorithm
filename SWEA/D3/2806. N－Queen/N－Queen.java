import java.io.*;
import java.util.*;

public class Solution {

	static int N;
	static int[] row;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int T = 1; T < TC + 1; T++) {
			N = Integer.parseInt(br.readLine());

			row = new int[N];
			cnt = 0;
			dfs(0);

			sb.append("#").append(T).append(" ").append(cnt).append("\n");
		}

		System.out.println(sb.toString());
	}

	public static void dfs(int depth) {
		// 탈출 조건
		if (depth == N) {
			cnt++;
			return;
		}

		out: for (int c = 0; c < N; c++) {
			for(int r = 0; r<depth;r++) {
				if( row[r] == c || Math.abs(c-row[r])== depth-r) {
					continue out;
				}
			}
			row[depth] = c;
			dfs(depth+1);
		}
	}

}