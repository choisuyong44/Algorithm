import java.io.*;
import java.util.*;

public class Solution {
	
	static int max;
	static int[] tree;
	static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int T = 1; T<TC+1; T++) {
			N = Integer.parseInt(br.readLine());
			tree = new int[N];
			
			int tmp; 
			max = 0;
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				tmp = Integer.parseInt(st.nextToken());
				tree[i] = tmp;
				max = Math.max(tmp,max);
			}
			
			int odd =0; int even =0;
			for(int i=0;i<N;i++) {
				int diff = max - tree[i];
				odd += diff%2;
				even += diff/2;
			}

			//2 -> 1로 변경
			if(even > odd) {
				while(Math.abs(even - odd) > 1) {
					even--;
					odd += 2;
				}
			}
			
			int result = 0;
			if(odd > even) { //1이 많을 경우
				result = odd * 2 - 1;
				
			} else if(even > odd) { //2가 많을 경우 
				result = even * 2;
				
			} else { //1과 2의 숫자가 같을 경우
				result = odd + even;
			}
			
			
			sb.append("#").append(T).append(" ").append(result).append("\n");
			
		}
		System.out.println(sb.toString());
	}
}