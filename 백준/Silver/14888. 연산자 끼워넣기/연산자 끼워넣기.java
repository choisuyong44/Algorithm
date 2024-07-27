import java.io.*;
import java.util.*;

public class Main {

	static int nums[];
	static int op[];
	static int max;
	static int min;
	static int N;
	
	public static void main(String[] args) throws IOException {

		// 숫자 최대 N 개
		// 연산자 최대 10개
		// 최대 10! -> 50만 이내 -> 완전 탐색

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		nums = new int[N+1];
		op = new int[4];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N+1; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}

		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		int sum  = nums[1];
		
		dfs(0,sum,0, 0, 0, 0,0);	

		System.out.println(max);
		System.out.println(min);
		
	}

	public static void dfs(int cnt,int sum, int plus, int minus, int mul, int div,int selection) {
		
		switch (selection) {
		case 1:
			sum = sum + nums[cnt+1];
			break;
		
		case 2:
			sum = sum - nums[cnt+1];
			break;
		
		case 3:
			sum = sum * nums[cnt+1];
			break;
		
		case 4:
			sum = sum/nums[cnt+1];
			break;
		default:
			break;
		}
		
		// if 해당 ip[idx] 와 각각의 value보다 크다면 그냥 종료
		if(op[0] < plus || op[1] < minus || op[2] < mul || op[3] < div) {
			return;
		}
		
		// if cnt가 N-1(연산자 갯수)이라면 
		// return Min 또는 Max
		if(cnt == N-1) {
			min = Math.min(sum, min);
			max = Math.max(sum, max);
			return;
		}
		
		dfs(cnt+1,sum,plus+1,minus,mul,div,1);
		dfs(cnt+1,sum,plus,minus+1,mul,div,2);
		dfs(cnt+1,sum,plus,minus,mul+1,div,3);
		dfs(cnt+1,sum,plus,minus,mul,div+1,4);
	}
}