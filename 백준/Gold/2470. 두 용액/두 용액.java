import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] liquids = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i =0;i<N;i++) {
			liquids[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(liquids);
		
		
		int left = 0;
		int right = liquids.length-1;
		
		
		int ans1 = 0;
		int ans2 = 0;
		
		int sum =0;
		int min = Integer.MAX_VALUE;
		while(left < right) {
			sum = liquids[left]+liquids[right];
			
			if(Math.abs(sum) < Math.abs(min)) {
				ans1 = liquids[left];
				ans2 = liquids[right];
                min = ans1 +ans2;
			}
			
			if(sum >0) {
				right--;
			}
			
			else {
				left++;
			}
		}
		
		System.out.println(ans1 + " " + ans2);
	}
}