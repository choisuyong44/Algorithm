import java.io.*;
import java.util.*;

public class Main {
	
	static int[] arr;
	static int[] ans;
	static int[] tmp;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cnt =0;
		
		arr = new int[9];
		ans = new int[7];
		
		int idx = 0;
		int sum = 0;
		
		for (int i=0;i<9;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}

		int sum_twoFake = sum - 100;
		
		out : for(int i =0;i<8;i++) {
			for(int j =i+1;j<9;j++) {
				if(arr[i] +arr[j] == sum_twoFake){
					for(int k=0;k<9;k++) {
						if(k==i || k==j) {
							continue;
						}
						else {
							ans[idx++] = arr[k];
						}
					}
                    break out;
				}
			}
		}
		
		Arrays.sort(ans);
		for(int i=0;i<7;i++) {
			System.out.println(ans[i]);
		}
		
	}
	
}