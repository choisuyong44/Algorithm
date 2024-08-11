import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int M;

	static int[] arr;
	static boolean[] visit;
	static int[] temp;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		visit = new boolean[N];
		temp = new int[M];
		
		st = new StringTokenizer(br.readLine());
		int idx =0;
		while(st.hasMoreTokens()) {
			arr[idx++] = Integer.parseInt(st.nextToken()); 
		}
		
		Arrays.sort(arr);
		dfs(0,0);
		
		System.out.println(sb.toString());
		
	}
	
	public static void dfs(int idx,int cnt) {
		if (cnt ==M) {
			for(int i= 0;i<M;i++) {
				sb.append(temp[i]+ " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i =0;i<N;i++) {
			temp[cnt] = arr[i];
			dfs(i,cnt+1);
		}
	}
}