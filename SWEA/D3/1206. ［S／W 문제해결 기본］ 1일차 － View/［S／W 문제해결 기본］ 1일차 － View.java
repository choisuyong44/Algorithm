import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arr;
		for (int t = 1; t < 11; t++) {
			int N = Integer.parseInt(br.readLine());

			arr = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i =0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int count =0;
			// target building
			for(int i = 0;i<arr.length;i++) {
				
				// -2 -1 0 1 2
				int max = 0;
				int second = 0;
				int max_i =0;
				for(int j =-2;j<=2;j++) {
					
					if(i+j < 0 || i+j >= arr.length) continue;
					
					if(arr[i+j] > max) {
						max_i = i+j;
						max = arr[i+j];
					}
				}
				
				for(int j =-2;j<=2;j++) {
					
					if(i+j < 0 || i+j >= arr.length) continue;
					
					if(i+j !=max_i) {
						second = Math.max(second, arr[i+j]);
					}
				}
				
				if(arr[i] == max) {
					count += max-second;
				}
				
			}
			
			System.out.printf("#%d %d\n",t,count);
		}
	}
}