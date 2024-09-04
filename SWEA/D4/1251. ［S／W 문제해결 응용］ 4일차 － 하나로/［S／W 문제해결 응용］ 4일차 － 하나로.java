import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static double E;

	static final int A = 0;
	static final int B = 1;
	static final int W = 2;

	static final int X = 0;
	static final int Y = 1;
	static final int REP = 2;

	static int[][] points;
	static long[][] edge;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int TC = Integer.parseInt(br.readLine());

		for (int T = 1; T < TC + 1; T++) {
			N = Integer.parseInt(br.readLine());

			edge = new long[N * (N - 1)][3];
			points = new int[N + 1][3];

			// X 받기
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				points[i][X] = Integer.parseInt(st.nextToken());
				points[i][REP] = i;
			}
			
			// Y 받기
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				points[i][Y] = Integer.parseInt(st.nextToken());
			}
			E = Double.parseDouble(br.readLine());

			int idx = 0;
			for (int i = 1; i < N; i++) {
				for (int j = i + 1; j <= N; j++) {
					edge[idx++] = new long[] { i, j, calDiff(points[i], points[j]) };
				}
			}

			Arrays.sort(edge, new Comparator<long[]>() {
				@Override
				public int compare(long[] o1, long[] o2) {
					if(o1[2] > o2[2]){
						return 1;
					}
					else if(o1[2] < o2[2]){
						return -1;
					}
					return 0;
				}
			});
			
			int cnt = 0;
			long sum = 0;
			for (long[] e : edge) {
				if (find((int) e[A]) != find((int) e[B])) {
					union((int) e[A], (int) e[B]);
					sum += e[W];
					cnt++;
					if (cnt == N - 1) {
						break;
					}
				}
			}

			long ans = Math.round(sum * E);

			sb.append("#").append(T).append(" ").append(ans).append("\n");
		}

		System.out.println(sb.toString());
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x < y)
			points[y][2] = x;
		else
			points[x][2] = y;
	}

	public static int find(int x) {
		if (x == points[x][2])
			return x;
		return points[x][2] = find(points[x][2]);
	}

	public static long calDiff(int[] v1, int[] v2) {
		return (long)Math.abs(v1[X] - v2[X]) * (long)Math.abs(v1[X] - v2[X]) +
				(long)Math.abs(v1[Y] - v2[Y]) * (long)Math.abs(v1[Y] - v2[Y]);
	}
}