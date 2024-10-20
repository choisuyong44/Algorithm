import java.io.*;
import java.util.*;

public class Main {
	
	static int N,d,k,c;
	static int[] arr;
	static int[] kind;
	static int max;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new int[N*2];
		kind = new int[d+1];
		for(int i =0;i<N;i++) {
			arr[i] = arr[N+i] = Integer.parseInt(br.readLine());
		}
		
		// base : 0 ~ k
		int cnt =0;
		for(int i =0;i<k;i++) {
			if(kind[arr[i]]==0) {
				cnt++;
				kind[arr[i]]++;
			}
			else kind[arr[i]]++;
		}
		if(kind[c]==0) max = cnt+1;
		else max = cnt;
		
		for(int i =0 ;i<N;i++) {
			
			// 빼기
			if(kind[arr[i]]==1) {
				kind[arr[i]]--;
				cnt--;
			}
			else kind[arr[i]]--;
			
			// 더하기
			if(kind[arr[i+k]]==0) {
				kind[arr[i+k]]++;
				cnt++;
			}
			else kind[arr[i+k]]++;
			
			// 쿠폰 체크
			if(kind[c]==0) max = Math.max(cnt+1, max);
			else max = Math.max(cnt, max);
		}
		
		System.out.println(max);
	}
}