import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N;
	static PriorityQueue<Long> pq = new PriorityQueue<>();
	static long ans;

	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		for (int T = 1; T < TC + 1; T++) {
			init();
			input();
			solution();
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}

	public static void solution() {
		while (true) {
			// 만약 한 pq 사이즈 1개이면 return;
			if (pq.size() == 1) {
				return;
			}

			long A = pq.poll();
			long B = pq.poll();
			pq.add(A+B);
			ans += A+B;
		}
	}

	public static void init() {
		pq.clear();
		ans = 0;
	}

	public static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			pq.add(Long.parseLong(st.nextToken()));
		}
	}

}