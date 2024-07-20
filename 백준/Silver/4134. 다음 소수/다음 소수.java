import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		/*
		 * 문제 : N(0<=4*10^9)일 때, N보다 크거나 같은 소수중 가장 작은 소수 찾기
		 * 
		 * 입력 : T : 테스트 케이스 수 N :
		 * 
		 * 출력 : N
		 * 
		 * 풀이 : 40억의 제곱근 20만 -> 하나하나 체크
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		long k;
		int res;
		for (int i = 0; i < T; i++) {
			k = Long.parseLong(br.readLine());
			if (k == 0 || k == 1) {
				System.out.println(2);
				continue;
			}
			System.out.println(findPrime(k));
		}
	}

	public static long findPrime(long n) {

		out: for (long i = n; i < Long.MAX_VALUE; i++) {
			for (int j = 2; j < (long) Math.sqrt(i) + 1; j++) {
				if (i % j == 0)
					continue out;
			}
			return i;
		}
		return -1;
	}
}