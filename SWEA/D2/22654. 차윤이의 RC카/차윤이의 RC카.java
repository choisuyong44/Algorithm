import java.io.*;
import java.util.*;

import sun.util.locale.StringTokenIterator;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static boolean[][] map;
	static char[] control;
	static int N, Q, C, nr, nc, src_r, src_c, dest_r, dest_c, ans;
	// 상 -> 오 -> 하 -> 왼
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T + 1; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new boolean[N][N];
			// map 입력
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					if (s.charAt(j) == 'T')
						map[i][j] = false;
					else
						map[i][j] = true;
					if (s.charAt(j) == 'X') {
						src_r = i;
						src_c = j;
					}
					if (s.charAt(j) == 'Y') {
						dest_r = i;
						dest_c = j;
					}
				}
			}
			// Control 입력
			Q = Integer.parseInt(br.readLine());
			sb.append("#").append(tc);
			for (int i = 0; i < Q; i++) {
				ans = 0;
				st = new StringTokenizer(br.readLine());
				C = Integer.parseInt(st.nextToken());
				control = new char[C];
				String s = st.nextToken();
				for (int j = 0; j < C; j++) {
					control[j] = s.charAt(j);
				}
				simulation();
				if (ans == 1)
					sb.append(" 1");
				else
					sb.append(" 0");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	public static void simulation() {
		int r = src_r;
		int c = src_c;
		int d = 0;
		for (int i = 0; i < control.length; i++) {
			if (control[i] == 'A') {
				nr = r + dr[d];
				nc = c + dc[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if (map[nr][nc]) {
						r = nr;
						c = nc;
					}
				}
			} else if (control[i] == 'R') {
				d = (d + 4 + 1) % 4;
			} else if (control[i] == 'L') {
				d = (d + 4 - 1) % 4;
			}

		}
		if (r == dest_r && c == dest_c)
			ans = 1;
	}
}