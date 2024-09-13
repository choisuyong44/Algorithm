import java.io.*;
import java.util.*;

public class Main {

	// 과자의 길이는 최대 10억
	// 할당량은 최대 10억+1로 set
	static int M, N;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		// 과자 길이 받기
		int pmax = 0;
		int pmin = 0;
		long sum = 0;
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
			pmax = Math.max(pmax, arr[i]);
		}

		// 1개씩도 나누어줄 수 없는 경우
		if (sum < M) {
			System.out.println(0);
			return ;
		}
		
		binarySearch(pmin, pmax+1);
	}
	
	public static void binarySearch(int min, int max) {
		int mid =0; long cnt =0;
		
		while(min < max) {
			mid = (min+max)/2;
			
			cnt =0;
			for(int i = 0;i <arr.length;i++) {
				cnt += arr[i]/mid;
			}
			
			if(cnt < M) {
				max = mid;
			}
			else {
				min = mid+1;
			}
		}
		
		System.out.println(min-1);
	}
}