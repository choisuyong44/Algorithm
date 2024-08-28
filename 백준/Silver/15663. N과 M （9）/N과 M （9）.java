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
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		dfs(0);

		System.out.println(sb.toString());
	}

	public static void dfs(int cnt) {

        if (cnt == M) {
            for (int val : ans) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before = 0;
        
      for(int i=0; i<N; i++){
          if(visit[i]) continue;

          if(before!=arr[i]){
              //System.out.println("before : "+before + " arr[i] : "+arr[i]);
              visit[i] = true;
              ans[cnt] = arr[i];
              before = arr[i];
              dfs(cnt+1);
              visit[i] = false;
          }
      }
    }
}