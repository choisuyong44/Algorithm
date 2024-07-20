import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		/*
		 *
		 * 문제 : n보다 크고 2n보다 작거나 같은 소수 구하기
		 * 
		 * 입력 : N이 여러 개 주어지고 0이면 stop (N 범위 123,456)
		 * 
		 * 출력 : 소수의 갯수
		 * 
		 * 풀이 : 에라토스테네스의 체 구현해서 풀기
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int k = 123456*2;
		
		boolean[] isNotPrime= new boolean[k+1];
		
		isNotPrime[0] = true;
		isNotPrime[1] = true;
		
		// Prime 찾기
		for(int i =2;i<(int)Math.sqrt(isNotPrime.length)+1;i++) {
			if(isNotPrime[i]==true) continue; 
			for(int j = i+1;j<=isNotPrime.length;j++) {
				if(j%i==0) isNotPrime[j] = true;
			}
		}
		
		int N; int cnt = 0;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N ==0) return;
			cnt = 0;
			for(int i =N+1;i<=2*N;i++) {
				if(isNotPrime[i]==false) cnt++;
			}
			System.out.println(cnt);
		}
	}
}