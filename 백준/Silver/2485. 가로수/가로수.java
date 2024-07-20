import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{

		/*
		 * 문제 :
		 * 가장 적은 수의 나무를 심기
		 * 모든 가로수가 같은 간격이 되도록 새로운 가로수의 최소수
		 * 
		 * 입력 : 
		 * N : 가로수의 갯수
		 * N줄 : 가로수의 위치 (가까운 순서대로 주어짐) -> 맨 마지막 큰 수
		 * 
		 * 출력 : 
		 * 가로수의 최소수를 출력
		 * 
		 * 풀이 : 
		 * 100,000 개 입력이 주어짐
		 * 공차 수열 이용 -> 그래서 차수가 몇개냐 문제 
		 * 간격이 같도록 최소 차이 2개의 최대 공약수로 접근
		 * 시작과 끝, 공차, 현재 갯수 -> 공차 수열상 갯수 - 현재 갯수
		 * 끝항 = 시작항 + 공차(공차수열 갯수-1)
		 * 공차수열 갯수 =  (끝항 - 시작항)/공차 +1;
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		// 차이는 N-1 개
		int[] sub = new int[N-1];
		
		arr[0] = Integer.parseInt(br.readLine());
		for (int i =1;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sub[i-1] = arr[i]-arr[i-1];
		}
		
		Arrays.sort(sub);
		
		int comDiv = sub[0];
		
		for(int i =1;i<sub.length;i++) {
			comDiv = gcd(comDiv,sub[i]);
		}
		
		// 공차수열 갯수 구한 후 현재 갯수 빼기
		int res = (arr[arr.length-1] -arr[0])/comDiv +1 - N;
		
		System.out.println(res);
	
	}
	
	public static int gcd(int a,int b) {
		if(a%b ==0) return b;
		return gcd(b,a%b);
	}
}