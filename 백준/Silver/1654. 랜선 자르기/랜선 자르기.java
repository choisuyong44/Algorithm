import java.io.*;
import java.util.*;

public class Main {

	static long limit;
	static int N, K;
	static long[] arr;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		// 가지고 있는 랜선의 갯수
		K = Integer.parseInt(st.nextToken());
		// 필요한 랜선의 갯수
		N = Integer.parseInt(st.nextToken());

		// 1. 가지고 있는 랜선의 길이를 저장하는 배열 생성
		limit = 0;
		arr = new long[K];
		for (int i = 0; i < K; i++) {
			arr[i] = Long.parseLong(br.readLine());
			limit = Math.max(limit, arr[i]);
		}

		// 2. 이분탐색으로 1부터 2^20까지 이분탐색 -> 20번
		long min = 0;
		long max = limit + 1;
		long mid = (min + max) / 2;
		binarySearch(min, max);

	}

	public static void binarySearch(long min, long max) {
		long n;
		long mid;
		while (min < max) {
			n = 0;
			mid = (min + max) / 2;

			for (int i = 0; i < K; i++) {
				n += (arr[i] / mid);
			}
			
            if(n<N){ // 랜선 개수가 모자라면 max값을 줄임
                max = mid;
            }
            else{
                min = mid +1;
            }
		}
		System.out.println(min-1);
	}
}