import java.io.*;
import java.util.*;


public class Main {

	static int N,a,b,max,left;
	static int[] ans;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		ans = new int[N];
		
		// -1 : max 중복 제거
		if(N < a+b-1) {
			System.out.println(-1);
			return;
		}
		
		// max height 찾기
		if (a == 1) {
			if(a>=b) {
				max = a;
				left = b-1;
			}
			else {
				max = b;
				left = a-1;
			}
			aEqualsOne(max, left);
		}
		else if(a>=b) {
			max = a;
			left = b-1;
			forward(max,left);
		}
		else {
			max = b;
			left = a-1;
			backword(max, left);
		}	
		
		StringBuilder sb = new StringBuilder();
		for(int i =0 ;i<N;i++) {
			sb.append(ans[i] + " ");
		}
		System.out.println(sb.toString());
	}
	
	// max : 최대 높이, left : 반대편에서 보는 갯수
	static void forward(int max, int left) {
		// 앞 쪽 : 앞 쪽에 남은 부분
		int idx; int base = 1;
		for(idx =0;idx<N-a-left;idx++) {
			ans[idx] = base;
		}
		
		// 앞쪽 남은 1 처리 후 순차적으로 상승
		for(;idx<N-left;idx++) {
			ans[idx] = base++;
		}
		
		// 뒤쪽 처리
		for(;idx<N;idx++) {
			ans[idx] = left--;
		}
	}
	
	static void backword(int max, int left) {
		// 뒤쪽 순차적으로 상승
		int idx; int base = 1; int cnt = a-1;
		
		// 가장 높은 빌딩은 남겨두고 하나씩 증가
		for(idx = 0;idx<b;idx++) {
			ans[N-idx-1] = base++;
		}

		// 하강
		for(;idx<b+a-1;idx++) {
			ans[N-idx-1] = cnt--;
		}
		
		// 나머지 1로 채우기
		for(;idx<N;idx++) {
			ans[N-idx-1] = 1;
		}
	}
	
	static void aEqualsOne(int max ,int left) {
		// 뒤쪽 순차적으로 상승
		int idx; int base = 1;
		
		// 가장 높은 빌딩은 남겨두고 하나씩 증가
		for(idx = 0;idx<b-1;idx++) {
			ans[N-idx-1] = base++;
		}
		
		// left 까지 1로 채운다.
		for(;idx<N-left-1;idx++) {
			ans[N-idx-1] = 1;
		}
		
		// max 높이를 처리한다.
		ans[N-idx-1] = base;
		idx++;
	}
}