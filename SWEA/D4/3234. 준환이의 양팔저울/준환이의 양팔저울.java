import java.io.*;
import java.util.*;

public class Solution {

	static int cnt;
	static int N;
	static boolean[] visit;
	static int[] perm;
	static int[] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int T = 1 ;T<TC+1;T++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			arr = new int[N];
			visit = new boolean[N];
			perm = new int[N];
			
			for(int i =0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			cnt =0;
			perm(0);
			
			sb.append("#").append(T).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void perm(int depth) {
		if(depth == N) {
			checkCondition(0,0,0);
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(visit[i]== false) {
				visit[i] = true;
				perm[depth] = arr[i];
				perm(depth+1);
				visit[i] = false;
			}
		}
	}
	
	public static void checkCondition(int depth,int left, int right) {
		if(left < right) return;
		
		if(depth == N) {
			cnt++;
			return;
		}
		
		checkCondition(depth+1, left+perm[depth], right);
		checkCondition(depth+1, left, right+perm[depth]);
	}
}