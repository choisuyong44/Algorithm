import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static boolean[] visit;
	static int[] ans;
	static int[] arr;
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		ans = new int[M];
		visit = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		per(0,0);

		System.out.println(sb.toString());
	}

	public static void per(int idx, int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(ans[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = idx; i < N; i++) {
			if (visit[i] == false) {
				visit[i] = true;
				ans[cnt] = arr[i];
				per(i+1,cnt + 1);
				visit[i] = false;
			}
		}
	}
}