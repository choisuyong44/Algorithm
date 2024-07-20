import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		
		/*
		 * 문제 : 창문을 열고 닫는데 최종적으로 열린 창문 갯수를 구하라
		 * 
		 * 입력 : 창문 갯수(21억까지)
		 * 
		 * 출력 : 열린 창문 갯수
		 * 
		 * 풀이 : 
		 * 1. 1억에 1초, 완전 탐색 x
		 * 2. 21억 에라토스테네스 x -> 메모리 터짐
		 * 
		 * 1 -> 1 
		 * 2 -> 1
		 * 3 -> 1
		 * 4 -> 2
		 * 5 -> 2
		 * 6 -> 3
		 * 7 -> 3
		 * 8 -> 3
		 * 
		 * 1 1 1 1 1 1 1 1
		 * 1 0 1 0 1 0 1 0
		 * 1 0 0 0 1 1 1 0
		 * 1 0 0 1 1 1 1 1
		 * 1 0 0 1 0 1 1 1
		 * 1 0 0 1 0 0 1 1
		 * 1 0 0 1 0 0 0 1
		 * 1 0 0 1 0 0 0 0
		 * 1 0 0
		 * 
		 * 
		 * 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
		 * 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0
		 * 1 0 0 0 1 1 1 0 0 0 1 1 1 0 0 0
		 * 1 0 0 1 1 1 1 1 0 0 1 0 1 0 0 1
		 * 1 0 0 1 0 1 1 1 0 1 1 0 1 0 1 0
		 * 1 0 0 1 0 0 1 1 0 1 1 1 1 0 1 0
		 * 1 0 0 1 0 0 0 1 0 1 1 1 1 1 1 0
		 * 1 0 0 1 0 0 0 0 0 1 1 1 1 1 1 1
		 * 1 0 0 1 0 0 0 0 1 1 1 1 1 1 1 1 
		 * .
		 * .
		 * .
		 * 1 0 0 1 0 0 0 0 1 0 0 0 0 0 0 1
		 * 
		 * -> 약수의 갯수는 짝수 개-> 제곱 수만 홀수
		 * -> 창문은 홀수번 반복했을 때만 열린다 -> 제곱수만 찾아라
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long N = Long.parseLong(br.readLine()); // int 21억 4743만
	
		int cnt =0;
		// 무한루프 가능성이 있음 -> 만약 int 1억만 되도 overflow 발생 범위 안에 존재
		for(long i =1;;i =i +1) {
			if(i*i <= N) cnt++; 
			else break;
		}

		System.out.println(cnt);
	}
}