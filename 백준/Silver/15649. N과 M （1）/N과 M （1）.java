import java.io.*;
import java.util.*;

public class Main {
	static int SZ, N, M;
	static int[] arr;
	static int[] isVisited;
	static StringBuilder sb ;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[M];
		isVisited = new int[N + 1];

		back(0);
		
	}

	public static void back(int arrIdx) {
		if (arrIdx == M) {
			sb = new StringBuilder();
			for (int i : arr) {
				sb.append(i).append(" ");

			}
			System.out.println(sb);
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (isVisited[i] == 0) {
				isVisited[i] = 1;
				arr[arrIdx] = i;
				back(arrIdx + 1);
				isVisited[i] = 0;
			}
		}
	}
}