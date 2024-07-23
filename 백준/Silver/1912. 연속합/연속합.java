import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		// 연속된 수들의 합
		// 1000 * 십만 -> 1억 안 (int 사용)
		
		// 연속적으로 계속 더하는 방식을 사용
		// 1개 <= n <= 100,000
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int[] dp = new int[N];
		
		int max = 0;
		int sum =0;
		// +만 쌓아나가기
		for(int i =0;i<N;i++) {
			int k = Integer.parseInt(st.nextToken());
			dp[i] =k;
			sum += k;
			if(sum > 0) {
				if(max < sum) {
					max = sum;
				}
			}
			else {
				sum = 0;
			}
		}
		
		// 만약 max가 0이 나오면 (+만 고르면 0이 나올리 없음) -> 가장 작은 - 찾기
		if(max ==0) {
			
			int maxAmongMinus = Integer.MIN_VALUE;
			for(int i=0;i<N;i++) {
				if(maxAmongMinus < dp[i]) {
					maxAmongMinus = dp[i];
				}
			}
			System.out.println(maxAmongMinus);
			return;
		}
		
		System.out.println(max);
	}

}