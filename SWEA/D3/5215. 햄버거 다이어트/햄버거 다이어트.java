import java.io.*;
import java.util.*;

public class Solution {
	static int answer = 0;
	static int[] cal;
	static int[] taste;
	static int N; static int L;
	public static void main(String[] args) throws IOException {
		/*
		 * 입력 : 
		 * 1. TestCase 수
		 * 2. N : 재료수, L : 칼로리 수
		 * 3. 재료 맛점수, 칼로리
		 * 
		 * 문제 :
		 * 칼로리 이하의 가장 맛있는 맛 찾기
		 * 
		 * 방법 : 
		 * 1. 가성비 좋은 녀석만 섞어서 L이 안넘게 만든다.
		 * 2. 가성비 좋은 순서로 인덱스 배열에 넣기
		 */
	
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int T = 1; T<TC+1;T++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			cal = new int[N];
			taste = new int[N];
			
			for(int i = 0; i<N;i++) {
				st = new StringTokenizer(br.readLine());
				taste[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			
			answer =0;
			dfs(0,0,0);
			
			System.out.printf("#%d %d\n",T,answer);
		}
	}
	
	public static void dfs(int cnt,int kcal, int sco) {
		// 칼로리 초과
		if (kcal > L) return;
		if (cnt == N) {
			answer = Math.max(answer, sco);
			return;
		}
		
		//  cnt+1 고르기
		dfs(cnt+1,kcal+cal[cnt],sco+taste[cnt]);
		
		// 안고르기 
		dfs(cnt+1,kcal,sco);
	}
}