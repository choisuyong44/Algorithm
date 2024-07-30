import java.io.*;
import java.util.*;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int N;
	static int M;
	static boolean visit[];     
	static int arr[];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visit = new boolean[N + 1];
		arr = new int[M];
		
		dfs(0,0);

		System.out.println(sb);
	}

	public static void dfs(int idx,int cnt) {

		if (cnt == M) {
			
			for (int i = 0; i < M; i++) {
				sb.append(arr[i] +" ");
			}
			
			sb.append("\n");
			return;
		}

		else {

			for (int i = 1; i <= N; i++) {
				if (!visit[i]) {
					arr[cnt] = i;  
					visit[i] = true;
					dfs(i+1,cnt+1);
					visit[i] = false;
				}
			}
		}
	}
}