import java.io.*;
import java.util.*;

public class Main {

	static int[] time;
	static int N, D;
	static int min;
	static List<int[]> highRoad = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		// 10,000 *4 byte = 40KB
		time = new int[D + 1];
		Arrays.fill(time, D+1);

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			highRoad.add(new int[] { s, e, w });
		}

		bfs();

		System.out.println(time[D]);
	}

	public static void bfs() {
		time[0] = 0;
		for (int i = 0; i <= D; i++) {
			if(i!=0) time[i] = Math.min(time[i], time[i - 1] + 1);
			for (int[] r : highRoad) {
				// 출발지 동일
				if (r[0] == i) {
					// 도착지가 D보다 작을 때, 도착지의 시간은 도착지의 시간과 출발지시간 + 거리
					if (r[1] <= D) {
						time[r[1]] = Math.min(time[r[1]], time[i] + r[2]);
					}
				}
			}
		}
	}
}