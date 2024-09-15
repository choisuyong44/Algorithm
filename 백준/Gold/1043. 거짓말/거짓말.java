import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static boolean[] truth;
	static List<Integer>[] party;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 사람 수와 파티 수 입력
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 진실을 아는 사람 번호를 입력
		truth = new boolean[N + 1];
		st = new StringTokenizer(br.readLine());
		if (Integer.parseInt(st.nextToken()) != 0) {
			while (st.hasMoreTokens()) {
				truth[Integer.parseInt(st.nextToken())] = true;
			}
		}

		// 파티 입력
		party = new List[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			party[i] = new ArrayList<Integer>();
			for (int j = 0; j < k; j++) {
				party[i].add(Integer.parseInt(st.nextToken()));
			}
		}

		solution();
	}

	public static void solution() {
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		// 연결
		for (int i = 0; i < M; i++) {
			// 파티 내에서 truth 찾기
			for (int j = 0; j < party[i].size() - 1; j++) {
				for (int k = j + 1; k < party[i].size(); k++) {
					// 진실을 아는 그룹으로 처리
					if (find(party[i].get(j)) !=find(party[i].get(k))) {
						union(party[i].get(j), party[i].get(k));
					}
				}
			}
		}

		// 확인
		int cnt = 0;
		out: for (int i = 0; i < M; i++) {
			for (int j = 0; j < party[i].size(); j++) {
				if (truth[find(party[i].get(j))]) {
					continue out;
				}
			}
			cnt++;
		}

		System.out.println(cnt);
	}

	public static int find(int x) {
		if (x == parent[x])
			return x;
		return parent[x] = find(parent[x]);
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);

		// 둘 중 한명은 진실을 아는 경우
		if (truth[x]) {
			parent[y] = x;
		}

		else if (truth[y]) {
			parent[x] = y;
		}

		// 둘 다 모르는 경우
		else {
			if (x < y)
				parent[y] = x;
			else
				parent[x] = y;
		}
	}
}