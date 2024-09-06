import java.io.*;
import java.util.*;

public class Solution {

	
	static int min;
	static int N,H;
	static int p[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int T = 1; T<TC+1;T++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			p = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				p[i] = Integer.parseInt(st.nextToken());
			}
			
			min =Integer.MAX_VALUE;
			powerSet(0,0);
			
			sb.append("#").append(T).append(" ").append(min-H).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void powerSet(int idx, int sum) {
		if(sum >= H) {
			min = Math.min(min,sum);
			return;
		}
		
		if(idx >=N) {
			return;
		}
		
		powerSet(idx+1,sum);
		powerSet(idx+1,sum+p[idx]);
	}
}