import java.io.*;
import java.util.*;

public class Main {

	static List<Integer>[] list;
	static boolean[] attend;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		// 0 제외
		attend = new boolean[N + 1];
		list = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list[a].add(b);
			list[b].add(a);

		}

		// 1의 친구들만 다 queue에 넣고 모두 빼면서 표시
		for (Integer n : list[1]) {
			attend[n] = true;

			for (Integer k : list[n]) {
				attend[k] = true;
			}
		}

		int cnt = 0;
		for (int i = 2; i <= N; i++) {
			if (attend[i])
				cnt++;
		}

		System.out.println(cnt);
	}
}