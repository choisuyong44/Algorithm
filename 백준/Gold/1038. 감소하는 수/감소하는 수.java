import java.io.*;
import java.util.*;

public class Main {

	static int[] num = {9,8,7,6,5,4,3,2,1,0};
	static boolean[] visit;
	static long[] desc;
	static int index =0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 2^10 승 -> 0~1023까지 아무것도 안뽑히는 경우 { } 제외
		desc = new long[1024];
		
		if(N<=9) {
			System.out.println(N);
			return;
		}
		
		else if(N>=1023) {
			System.out.println(-1);
			return;
		}
		
		// 9 8 7 6 5 4 3 2 1
		for(int i=1;i<=10;i++) {
			visit = new boolean[10];
			dfs(0,0,i);
		}
		
		Arrays.sort(desc);
		
		System.out.println(desc[N+1]);
	}
	
	public static void dfs(int idx, int cnt, int depth) {
		
		if(cnt == depth) {
			long tmp = 0; int digit = 10;
			for(int i=0;i<10;i++) {
				if(visit[i] == true) {
					tmp *= digit;
					tmp += num[i];
				}
			}
			desc[index++] = tmp;
			return;
		}
		
		for(int i = idx;i<10;i++) {
			visit[i] = true;
			dfs(i+1,cnt+1,depth);
			visit[i] = false;
		}
	}
}