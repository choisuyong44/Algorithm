import java.io.*;
import java.util.*;

/**
 * 1. 처음,마지막 원소가 S 인 경우
 * 2. 원소가 없는 경우
 * 3. 
 */
public class Main {

	// N의 모든 합은 Int 범위
	static int N, S;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		input();
		int start = -1; int end =0;
		int ans = Integer.MAX_VALUE; int sum =arr[end];
		
		while(start < end) {
			if(sum >= S) ans =Math.min(ans, end-start);
			if((end >= N-1) || ( sum >= S)) { 			// end가 범위를 초과, 또는 sum >= S면 줄여도 됨
				start++;
				sum -= arr[start];
				
			}
			else if(sum < S) {							// 조건보다 작은 경우 end 추기
				end++;
				sum += arr[end];
			}
		}
		
		if(ans == Integer.MAX_VALUE) ans =0;
		System.out.println(ans);
	}
	
	public static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i =0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}		
	}
}