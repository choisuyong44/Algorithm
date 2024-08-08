import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		int N;
		int[] days;
		
		for(int T = 1; T <TC+1;T++) {
			N = Integer.parseInt(br.readLine());
			days = new int[N];
			
			st = new StringTokenizer(br.readLine());
			
			for(int i =0;i<N;i++) {
				days[i] = Integer.parseInt(st.nextToken());
			}
			
			long sum = 0;
			int max = 0;
			for(int i =N-1;i>=0;i--) {
				if(max > days[i]) {
					sum += max - days[i];
				}
				else {
					max = days[i];
				}
			}
			
			System.out.println("#" + T + " " +sum);
		}
	}
}