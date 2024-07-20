import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		/*
		 * 문제 : 2보다 큰 짝수는 두 소수의 합으로 나타낼 수 있다.
		 * 		N을 두 짝수의 합으로 나타내보자
		 * 
		 * 입력 : T 테스트 케이스(1<=T<=100)
		 * N 은 2<N<=1,000,000 백만
		 * 
		 * 출력 : 골드바흐의 파티션의 수를 구하자
		 * 
		 * 풀이 : 
		 * 에라토스테네스의 체로 풀고, 소수를 뺏을 때, 나머지가 소수면 ++
		 * 소수를 뺐을 때, 같은 수면 pass
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		boolean[] isNotPrime = new boolean[1000000];
		isNotPrime[0] = true;
		isNotPrime[1] = true;
		
		for(int i = 2;i<=(int)Math.sqrt(1000000)+1;i++) {
			if(isNotPrime[i] == true) continue;
			for(int j =i+1;j<1000000;j++) {
				if(j%i==0) isNotPrime[j] = true;
			}
		}
		
		for(int i =0;i<T;i++) {
			int N = Integer.parseInt(br.readLine());
			int cnt = 0;
			for(int j =2;j<=N/2;j++) {
				if(isNotPrime[j]==false && isNotPrime[N-j] == false) cnt++;
			}
			System.out.println(cnt);
		}
		
	}

}