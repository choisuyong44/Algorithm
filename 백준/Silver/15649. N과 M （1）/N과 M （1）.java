import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] arr;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[M];
		visit= new boolean[N+1];
		
		per(0);
	}

	public static void per(int cnt) {
		if(cnt == M) {
			for(int i=0;i<M;i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 1;i<=N;i++) {
			if(visit[i] == false) {
				visit[i] = true;
				arr[cnt] = i;
				per(cnt+1);
				visit[i] = false;
			}
		}
	
	}
}